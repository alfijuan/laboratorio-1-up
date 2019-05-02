package main;

import basico.jdbc.DBManager;
import dao.EmpleadoDao;
import empresa.Empleado;
import exceptions.HorasException;
import utils.Dentre;

public class Test {

	
	public static void main(String[] args) {
	
		EmpleadoDao empleadoDao = new EmpleadoDao();
		boolean sigo = true;
		DBManager con = DBManager.getInstance();
		
		
		while (sigo) {			
			System.out.println("Menu de opciones");
			System.out.println("1- Alta de Empleado.\n");
			System.out.println("2- Baja de Empleado.\n");
			System.out.println("3- xxxxxx.\n");
			System.out.println("4- xxxxxx.\n");
			System.out.println("5- Salir.\n");
			int opcion = Dentre.entero("Ingrese opcion:");

			switch (opcion) {
			case 1:
				try {
					empleadoDao.crearEmpleado(altaEmpleado());
				} catch (HorasException e) {
					e.printStackTrace();
				}
				break;
			case 2:


			default:
				System.out.println("Opción incorrecta!");
				break;
			}

		}


	}
	
	
	
	
	
	public static Empleado altaEmpleado() {
		
		Empleado empleado = new Empleado();
		
		empleado.setLegajo(Dentre.entero("Ingrese Legajo: "));
		empleado.setNombre(Dentre.texto("Ingrese nombre: "));
		empleado.setApellido(Dentre.texto("Ingrese apellido: "));
		empleado.setDni(Dentre.entero("Ingrese dni: "));
		empleado.setDireccion(Dentre.texto("Ingrese direccion: "));
		empleado.setHonorarios(Dentre.flotante("Ingrese honorarios: "));
		empleado.setNombreUsuario(Dentre.texto("Ingrese el nombre de usuario: "));
		empleado.setPassword(Dentre.texto("Ingrese el password: "));
		return empleado;
	}

}
