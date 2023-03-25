package com.app.leave;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LeaveConfig {
	@Bean
	 RestTemplate restTemplate() {
		 return new RestTemplate();
	 }
}
