package com.pms.demo.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class ReadExternalProperty {

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	{
		
		PropertySourcesPlaceholderConfigurer property=new PropertySourcesPlaceholderConfigurer();
		property.setLocation(new FileSystemResource("D:/config/module1.properties"));
		
		return property;
	}
}
