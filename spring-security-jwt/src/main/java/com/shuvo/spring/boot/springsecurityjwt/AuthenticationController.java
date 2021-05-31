package com.shuvo.spring.boot.springsecurityjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shuvo.spring.boot.springsecurityjwt.model.AuthenticationRequest;
import com.shuvo.spring.boot.springsecurityjwt.model.AuthenticationResponse;
import com.shuvo.spring.boot.springsecurityjwt.util.JWTUtil;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		
		try {
			authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			
		}
		catch(BadCredentialsException ex) {
			throw new Exception("Incorrect credential exception "+ex);
		}
		
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtUtil.generateToken(userDetails);
	
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}

}
