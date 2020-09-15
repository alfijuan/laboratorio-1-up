package bo;

import dao.UserDAO;
import empresa.User;
import exceptions.SystemException;
import exceptions.user.UserOrPassDontExistException;

public class UserBO {
	private UserDAO userDao;
	
	public UserBO() {}
	
	public void loginUser(User user) throws SystemException, UserOrPassDontExistException {
		if(userDao.loginUser(user) == 0) {
			throw new UserOrPassDontExistException("Usuario o password incorrectos");
		}
	}
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
