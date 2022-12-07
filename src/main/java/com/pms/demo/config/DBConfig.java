package com.pms.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfig {

	private String url;
	private String username;
	private String password;
	private String name;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Profile("dev")
	@Bean
	public String devDbConnection()
	{
		System.out.println("url----"+url);
		System.out.println("appName----"+name);
		return "DB connection for Dev";
	}
	
	@Profile("test")
	@Bean
	public String testDbConnection()
	{
		System.out.println("url----"+url);
		return "DB connection for test";
	}
	
	@Profile("prod")
	@Bean
	public String prodDbConnection()
	{
		System.out.println("url----"+url);
		return "DB connection for prod";
	}
	
	
}
