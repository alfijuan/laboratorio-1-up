package dao;

import empresa.User;
import exceptions.SystemException;

public interface UserDAO {
	
	Integer loginUser(User user) throws SystemException;
}
