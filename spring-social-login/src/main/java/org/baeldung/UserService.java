package org.baeldung;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

	public Map<String, Object> getUserByUsername(String username) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(new UserDao().getDataSource());
		Map<String, Object> userMap = jdbcTemplate.queryForMap("select * from user where username = ?",
				new Object[] { username });

		if (!userMap.isEmpty()) {
			userMap.put("role", "admin");
			return userMap;
		}
		/*
		 * Map<String, Object> userMap = null; // logic here to get your user
		 * from the database if (username.equals("admin") ||
		 * username.equals("user")) { userMap = new HashMap<>();
		 * userMap.put("username", "admin"); userMap.put("password",
		 * "password"); // if username is admin, role will be admin, else role
		 * is user // only userMap.put("role", (username.equals("admin")) ?
		 * "admin" : "user"); // return the usermap return userMap; }
		 */
		// if username is not equal to admin, return null
		return null;
	}

	public int save(Map<String, Object> userMap) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(new UserDao().getDataSource());
		String sql = "";
		sql += "INSERT INTO `user` (`username`, `password`, `enabled`, `accountNonExpired`, `accountNonLocked`, `credentialsNonExpired`, `emailId`) ";
		sql += "VALUES ";
		sql += "(?, ?, 1, 1, 1, 1, ?)";
		int result = jdbcTemplate.update(sql,
				new Object[] { userMap.get("username"), userMap.get("password"), userMap.get("email") });

		return result;
	}
}
