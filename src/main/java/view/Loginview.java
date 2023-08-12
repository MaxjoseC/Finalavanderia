package view;

import modelos.usuario;
import org.apache.commons.validator.routines.EmailValidator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Loginview extends JInternalFrame {
	private JTextField txtcorreo;
	private JPasswordField txtclave;

	public Loginview(GestorLavGui gestorLavGui) {
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
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(37, 63, 167, 20);
		panel.add(txtcorreo);
		txtcorreo.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(72, 94, 92, 28);
		panel.add(lblContrasea);
		
		txtclave = new JPasswordField();
		txtclave.setBounds(39, 133, 165, 20);
		panel.add(txtclave);
		
		JButton btninicio = new JButton("Iniciar sesion");
		btninicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String correo = txtcorreo.getText();
                String clave = new String(txtclave.getPassword());

				EmailValidator emailValidator = EmailValidator.getInstance();
				if (!emailValidator.isValid(correo)) {
					JOptionPane.showMessageDialog(Loginview.this, "Correo incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// validar password character
				// minimum lenght 8 characters
				final String PASSWORD_PATTERN =
						"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
				if (!clave.matches(PASSWORD_PATTERN)){
					JOptionPane.showMessageDialog(Loginview.this, "Contraseña incorrecta, los caracteres no son correctos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
				}
				usuario usarioo = GestorLavGui.iniciarSesion(correo,clave);

				if(usarioo == null){
					JOptionPane.showMessageDialog(Loginview.this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
				}
				//Mensage de bienvenido
				JOptionPane.showMessageDialog(Loginview.this, "Bienvenido " + usarioo.getCorreo(), "Información", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);

			}
		});
		btninicio.setBounds(59, 166, 125, 28);
		panel.add(btninicio);

	}
}
