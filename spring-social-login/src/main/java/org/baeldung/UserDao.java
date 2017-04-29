package org.baeldung;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class UserDao {
	private DriverManagerDataSource dataSource;
	public UserDao(){
		this.dataSource = new DriverManagerDataSource();
		this.dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		this.dataSource.setUrl("jdbc:mysql://localhost:3306/spring_social_login"
				+ "?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		this.dataSource.setUsername("root");
		this.dataSource.setPassword("");
	}
	
	public DriverManagerDataSource getDataSource(){
		return this.dataSource;
	}
}
