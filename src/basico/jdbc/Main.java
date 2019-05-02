package basico.jdbc;

import java.sql.Connection;

public class Main {

	public static void main(String [] args) {
		
		System.out.println("here");
		Connection c = DBManager.getInstance().connect();
		System.out.println(c);
		System.out.println("here 2");
		
//		TableManager tm = new TableManager();
//		tm.createUserTable();
//		
//		
//		DataManager dm = new DataManager();
//		
//		String user = "user1";
//		String email = "email1";
//		String pass = "pass1";
//		
//		dm.crearUsuario(user, email, pass);
//		
//		String userx = "userx";
//		String emailx = "emailx";
//		String passx = "passx";
//		
//		dm.crearUsuario(userx, emailx, passx);
//		
//		System.out.println("Ahora voy a mostrar el usuario recien cargado");
//		String unUser = "user1";
//		dm.muestraUsuario(unUser);
//		System.out.println("---------");
//		
//		System.out.println("Voy a modificar un usuario");
//		String user2 = "user2";
//		String email2 = "email2";
//		String pass2 = "pass2";
//		dm.actualizaUsuario(user2, email2, pass2);
//		
//		System.out.println("Tengo estos usuarios:");
//		dm.muestraTodosLosusuarios();
//		System.out.println("------");
//		
//		
//		System.out.println("Voy a borrar un usuario segun su username");
//		String user3 = "use2";
//		dm.borraUsuario(user3);
//		
//		System.out.println("Tengo estos usuarios:");
//		dm.muestraTodosLosusuarios();
//		System.out.println("------");
//		
//		tm.dropUserTable();
//		
	}
	
}
