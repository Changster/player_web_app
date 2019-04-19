package com.bo;

import com.exception.BusinessException;
import com.model.User;

public interface LoginBO {
	public boolean isValidUser(User user) throws BusinessException;
	
}
