package view;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestorLavGui {

	private JFrame frmGestorLavanderia;

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
				Loginview login = new Loginview();
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
		mnNewMenu.add(mntmNewMenuItem_1);
	}
}
