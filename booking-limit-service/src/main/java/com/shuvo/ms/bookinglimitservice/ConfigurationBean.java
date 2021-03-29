package com.shuvo.ms.bookinglimitservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@ConfigurationProperties("booking-limit-service")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ConfigurationBean {
	private int minimum;
	private int maximum;
	
	
}
