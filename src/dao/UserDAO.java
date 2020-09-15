package dao;

import empresa.User;
import exceptions.user.UserOrPassDontExistException;

public interface UserDAO {
	
	Integer loginUser(User user) throws UserOrPassDontExistException;
}
