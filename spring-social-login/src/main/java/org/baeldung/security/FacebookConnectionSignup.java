package org.baeldung.security;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String execute(Connection<?> connection) {
		System.out.println("signup === ");
		String username = connection.getDisplayName();
		String password = randomAlphabetic(8);
		System.out.println("user : " + username + ", password : " + password);
		final User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);
		return user.getUsername();
	}

}
