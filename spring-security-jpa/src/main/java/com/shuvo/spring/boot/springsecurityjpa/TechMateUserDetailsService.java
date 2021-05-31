package com.shuvo.spring.boot.springsecurityjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class TechMateUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<User> user = userRepository.findByusername(username);
		
		user.orElseThrow(()->
			new UsernameNotFoundException("User not Found :: "+username)
		);
		
		
		return new TechMateUserDetails(user.get());
		
		//return null;
	}

}
