package com.ymsli.mvc.model.persistance.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.ymsli.mvc.model.persistance.factory.ConnectionFactory;

public class UserDaoImpl implements UserDao {
	private Connection connection;

	public UserDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addUser(User user) {
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("insert into users(username, password, profile) values(?,?,?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getProfile());

			pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public Optional<User> getUser(String username, String password) {
		User user=null;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("select * from users where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user=new User(username, password, rs.getString("profile"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(user);
	}

}
