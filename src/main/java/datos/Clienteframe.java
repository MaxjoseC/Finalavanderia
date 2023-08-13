package datos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Clienteframe extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clienteframe frame = new Clienteframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clienteframe() {
		setBounds(100, 100, 450, 300);

	}

}
