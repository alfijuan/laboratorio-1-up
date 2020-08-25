package ui.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import empresa.Empleado;
import handler.Handler;

public class EmpleadoTable2 extends TableBase {
	
	private static final long serialVersionUID = 1L;
	
	private List<Empleado> lista;
	
	public EmpleadoTable2(Handler handler, List<Empleado> l) {
		super(handler);
		setLista(l);
		setHandler(handler);
		System.out.println("hereee");
		agregarBotones();
	}
	
	protected void agregarColumnas() {
		getModelo().addColumn("Legajo");
		getModelo().addColumn("Nombre");
		getModelo().addColumn("DNI");
		getModelo().addColumn("Honorarios");
		getModelo().addColumn("Username");
		getModelo().addColumn("Password");
		
		getColumnModel().getColumn(0).setPreferredWidth(500);
		getColumnModel().getColumn(1).setPreferredWidth(500);
		getColumnModel().getColumn(2).setPreferredWidth(500);
		getColumnModel().getColumn(3).setPreferredWidth(500);
		getColumnModel().getColumn(4).setPreferredWidth(500);
		getColumnModel().getColumn(5).setPreferredWidth(500);
		
		System.out.println(getLista());
//		for (int i = 0; i < getLista().size(); i++) {
//			getModelo().addRow(new Object[] {
//				lista.get(i).getLegajo(),
//				lista.get(i).getNombre(),
//				lista.get(i).getApellido(),
//				lista.get(i).getDni(),
//				lista.get(i).getDireccion(),
//				lista.get(i).getHonorarios(),
//				lista.get(i).getNombreUsuario(),
//				lista.get(i).getPassword()
//			});
//		}
	}
	
	protected Box agregarBotones() {
		Box botonera = Box.createHorizontalBox();
		JButton editBtn = new JButton("Editar");
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = getTabla().getSelectedRow();
				if(index != -1) {
					getHandler().mostrarEditarEmpleado(lista.get(index));
				} else {
					getHandler().mostrarModal("Debe seleccionar una fila");
				}
			}
		});
		JButton deleteBtn = new JButton("Borrar");
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = getTabla().getSelectedRow();
				if(index != -1) {
					int input = JOptionPane.showConfirmDialog(null, "¿Estas seguro que queres borrar?", "", JOptionPane.OK_CANCEL_OPTION);
					if(input == 0) {
						getHandler().mostrarBorrarEmpleado(lista.get(index).getLegajo());
					}
				} else { 
					getHandler().mostrarModal("Debe seleccionar una fila");
				}
			}
		});
		botonera.add(editBtn);
		botonera.add(Box.createHorizontalGlue());
		botonera.add(deleteBtn);
		return botonera;
	}

	public List<Empleado> getLista() {
		return lista;
	}

	public void setLista(List<Empleado> lista) {
		this.lista = lista;
	}
	
	

}
