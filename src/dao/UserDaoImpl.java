package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import basico.jdbc.DBManager;
import empresa.User;
import exceptions.SystemException;

public class UserDaoImpl implements UserDAO{
	

	@Override
	public Integer loginUser(User user) throws SystemException {
		Connection con = DBManager.getInstance().connect();
		Integer resultado = 0;
		try {
			PreparedStatement sql = con.prepareStatement("SELECT count(*) from user_data where username=? AND  password =?");
			sql.setString(1, user.getUser());
			sql.setString(2, user.getPassword());
			
			
			
			ResultSet rs = sql.executeQuery();
			if(rs.next()) { 
				resultado = rs.getInt("count");
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
		
		return resultado;
		
	}
	
}
