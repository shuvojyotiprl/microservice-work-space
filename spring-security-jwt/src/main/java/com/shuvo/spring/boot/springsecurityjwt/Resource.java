package com.shuvo.spring.boot.springsecurityjwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {

	@GetMapping("/")
	public String helloAll() {
		return "Hello All";
	} 
	
	
	@GetMapping("/user")
	public String helloAllUser() {
		return "Hello All User";
	} 
	
	
	@GetMapping("/admin")
	public String helloAllAdmin() {
		return "Hello All Admin Users  ";
	} 
	
	
}
