package view;

import modelos.*;
import Utilidades.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GestorLavGui {

	private JFrame frmGestorLavanderia;
	private JMenu mnuEmpleados;
	private  GestorLav gestorLav;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorLavGui window = new GestorLavGui();
					window.frmGestorLavanderia.setVisible(true);
					//show maximaxed
					window.frmGestorLavanderia.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestorLavGui() {
		initialize();
		gestorLav = new GestorLav();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestorLavanderia = new JFrame();
		frmGestorLavanderia.setTitle("Gestor Lavanderia");
		frmGestorLavanderia.setBounds(100, 100, 904, 786);
		frmGestorLavanderia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestorLavanderia.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		frmGestorLavanderia.getContentPane().add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		frmGestorLavanderia.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cuenta");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Iniciar Sesion");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginview login = new Loginview(GestorLavGui.this);
				desktopPane.add(login);
				login.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar programa");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dialogo de confirmación para salir
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION);
                if(respuesta == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
			}
		});
		
		JMenuItem MnIusuario = new JMenuItem("Crear nuevo empleado");
		MnIusuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpleadocrearFrame empleadocrearFrame = new EmpleadocrearFrame(GestorLavGui.this);
				desktopPane.add(empleadocrearFrame);
				empleadocrearFrame.setVisible(true);
			}
		});
		mnNewMenu.add(MnIusuario);
		mnNewMenu.add(mntmNewMenuItem_1);

		mnuEmpleados = new JMenu("Empleados");
		mnuEmpleados.setMnemonic('E');
		mnuEmpleados.setEnabled(false);
		menuBar.add(mnuEmpleados);
		
		JMenuItem CrearempleadomenuI = new JMenuItem("Crear");
		mnuEmpleados.add(CrearempleadomenuI);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem MnIcliente = new JMenuItem("Lista de clientes");
		MnIcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clienteframe clienteframe = new Clienteframe(GestorLavGui.this);
				desktopPane.add(clienteframe);
				clienteframe.setVisible(true);
			}
		});
		mnCliente.add(MnIcliente);

	}
	public void mostrarMenus(boolean estado) {
		mnuEmpleados.setEnabled(estado);
	}
	public usuario iniciarSesion(String correo, String clave) {
		usuario usuario1 = gestorLav.obtenerUsuariocorreo(correo);
		boolean resultadoValidacion = Utilities.comprobarclave(usuario1.getClave(),clave);
		if(resultadoValidacion){
            return usuario1;
        }else{
            return null;
        }

	}

	public List<Rol> getRoles() {
		return gestorLav.getRolList();
	}

	public usuario obtenerUsuariocorreo(String correo) {
		return gestorLav.obtenerUsuariocorreo(correo);
	}

	public empleado crearEmpleado(empleado empleado1) {
		return gestorLav.crearEmpleado(empleado1);
	}

	public usuario crearUsuario(usuario usuario1) {
		return gestorLav.crearUsuario(usuario1);
	}

	public boolean brorrarEmpleado(int idEmpleado) {
		return gestorLav.borrarEmpleado(idEmpleado);
	}

	public cliente crearcliente(cliente cliente) {
		return gestorLav.crearCliente(cliente);
	}

	public List<cliente> getclientes() {
		return gestorLav.getClientes();
	}

	public cliente getClientedatos(String nombre, String apellido) {
		return gestorLav.getClientedatos(nombre, apellido);

	}
}
