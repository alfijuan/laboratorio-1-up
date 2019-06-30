package dao;

import exceptions.SystemException;
import exceptions.login.WrongDataException;

public interface LoginDAO {
	void loguearUser(String username, String password) throws WrongDataException, SystemException;
}
