package view;

import modelos.GestorLav;
import modelos.Rol;
import modelos.empleado;
import modelos.usuario;
 import Utilidades.Utilities;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
		frmGestorLavanderia.setBounds(100, 100, 591, 513);
		frmGestorLavanderia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestorLavanderia.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 575, 452);
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
}
