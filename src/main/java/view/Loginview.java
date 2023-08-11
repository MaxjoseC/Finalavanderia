package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loginview extends JInternalFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginview frame = new Loginview();
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
	public Loginview() {
		setClosable(true);
		setTitle("Login");
		setBounds(100, 100, 273, 253);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(86, 24, 63, 28);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(37, 63, 167, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(72, 94, 92, 28);
		panel.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(39, 133, 165, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Iniciar sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(59, 166, 125, 28);
		panel.add(btnNewButton);

	}
}
