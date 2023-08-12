package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class EmpleadocrearFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpleadocrearFrame frame = new EmpleadocrearFrame();
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
	public EmpleadocrearFrame() {
		setBounds(100, 100, 450, 300);

	}

}
