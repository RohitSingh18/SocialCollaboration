package com.collaborate.SocialMiddleware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.collaborate")

public class WebResolver {
	
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		System.out.println("Resover Created");
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
		
	}

}
