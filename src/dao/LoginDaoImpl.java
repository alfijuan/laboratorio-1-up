package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import basico.jdbc.DBManager;
import exceptions.SystemException;
import exceptions.login.WrongDataException;

public class LoginDaoImpl implements LoginDAO{
	
	public void loguearUser(String username, String password) throws WrongDataException, SystemException{
		
		Connection con = DBManager.getInstance().connect();
		
		try {
			PreparedStatement sql = con.prepareStatement("SELECT * FROM empleado where usuario=? AND password=?");
			sql.setString(1, username);
			sql.setString(2, password);
			
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()) { 
				System.out.println(rs);
			} else {
				throw new WrongDataException("Los datos ingresados no son correctos");
			}
			
		}catch (SQLException e) {
			try {
				con.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("Error en la base de datos");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

}
