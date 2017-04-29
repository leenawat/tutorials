package org.baeldung.security;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.HashMap;
import java.util.Map;

import org.baeldung.UserService;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UserService userService;
    
	@Autowired
	private UserRepository userRepository;

	@Override
	public String execute(Connection<?> connection) {
		System.out.println("signup === ");
		Facebook facebook = (Facebook) connection.getApi();
        String [] fields = { "id", "email",  "first_name", "last_name" };
        FacabookUser facabookUser = facebook.fetchObject("me", FacabookUser.class, fields);
        
		String username = connection.getDisplayName();
		String password = randomAlphabetic(8);
		System.out.println("user : " + username + ", password : " + password);
		final User user = new User();

        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("email", facabookUser.getEmail());
        userMap.put("username", facabookUser.getFirst_name());
        userMap.put("password", password);
        userService.save(userMap);
		
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);
		return user.getUsername();
	}

//	private UserRegistrationForm toUserRegistrationObject(final String userId, final SocialProvider socialProvider,
//			FacabookUser facebookUser) {
//		logger.info("userid : " + userId);
//		logger.info("facebookUser.getUserId() : " + facebookUser.getId());
//		logger.info("");
//		String password = randomAlphabetic(8);
//		System.out.println("password : " + password);
//		return UserRegistrationForm.getBuilder().addUserId(userId).addFirstName(facebookUser.getFirst_name())
//				.addEmail(facebookUser.getEmail()).addPassword(password).addSocialProvider(socialProvider).build();
//	}

}

class FacabookUser {
	private Long id;
	private String email;
	private String first_name;
	private String last_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
