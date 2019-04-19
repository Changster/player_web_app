package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.BusinessException;
import com.model.User;
import com.dbutil.OracleDBConnection;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isValidUser(User user) throws BusinessException {
		Boolean b = false;
		String sql = "select username from playerlogin where username = ? and password = ?";
		try(Connection connection = OracleDBConnection.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				b = true;
			}
			else {
				throw new BusinessException("Username/Password not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("error from logindaoimpl   " + e.getMessage());
			e.printStackTrace();
		} 
		
		return b;
	}

}
