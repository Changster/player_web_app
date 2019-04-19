package com.bo;

import com.dao.LoginDAOImpl;
import com.exception.BusinessException;
import com.model.User;

public class LoginBOImpl implements LoginBO {

	@Override
	public boolean isValidUser(User user) throws BusinessException {
		boolean b = false;
		if(user != null && user.getUsername() != null && user.getPassword() != null && user.getUsername().matches("[A-Za-z0-9]{1,20}") && user.getPassword().matches("[A-Za-z0-9]{5,20}")) {
			b = new LoginDAOImpl().isValidUser(user);
		}
		else {
			System.out.println("error from loginboimpl");
			throw new BusinessException("Invalid User ID/Password");
		}
		return b;
	}

}
