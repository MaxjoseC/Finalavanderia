package view;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;

import Utilidades.Utilities;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import modelos.Rol;
import modelos.empleado;
import modelos.usuario;
import org.apache.commons.validator.routines.IntegerValidator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpleadocrearFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField txtNombre;
	private final JTextField txtApellido;
	private final JTextField fielsueldo;
	private final JTextField txtcorreocrear;
	private final JPasswordField passcrearEmple;
	GestorLavGui gestorLavGui;

	private Map<String, Integer> opcionesroles;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EmpleadocrearFrame(GestorLavGui gestorLavGui) {
		setClosable(true);
		this.gestorLavGui = gestorLavGui;

		setTitle("Creación empleados");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel empleadopanel = new JPanel();
		empleadopanel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		getContentPane().add(empleadopanel, BorderLayout.CENTER);
		empleadopanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblnombre = new JLabel("Nombre:");
		empleadopanel.add(lblnombre, "2, 2");
		
		txtNombre = new JTextField();
		empleadopanel.add(txtNombre, "6, 2, fill, default");
		txtNombre.setColumns(10);
		
		JLabel lblapellido = new JLabel("Apellido:");
		empleadopanel.add(lblapellido, "2, 4");
		
		txtApellido = new JTextField();
		empleadopanel.add(txtApellido, "6, 4, fill, default");
		txtApellido.setColumns(10);
		
		JLabel lblsueldo = new JLabel("Sueldo:");
		empleadopanel.add(lblsueldo, "2, 6");
		
		fielsueldo = new JTextField();
		empleadopanel.add(fielsueldo, "6, 6, fill, default");
		fielsueldo.setColumns(10);
		
		JLabel lblrol = new JLabel("Rol:");
		empleadopanel.add(lblrol, "2, 8");
		
		JComboBox Rolescombo = new JComboBox();
		empleadopanel.add(Rolescombo, "6, 8, fill, default");
		
		JLabel lblcorreo = new JLabel("Correo:");
		empleadopanel.add(lblcorreo, "2, 10");
		
		txtcorreocrear = new JTextField();
		empleadopanel.add(txtcorreocrear, "6, 10, fill, default");
		txtcorreocrear.setColumns(10);
		
		JLabel lblpass = new JLabel("Contraseña:");
		empleadopanel.add(lblpass, "2, 12");
		
		passcrearEmple = new JPasswordField();
		empleadopanel.add(passcrearEmple, "6, 12, fill, default");
		
		JButton btncrearEmpleado = new JButton("Crear");
		btncrearEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String sueldo = fielsueldo.getText();
				String rol = (String) Rolescombo.getSelectedItem().toString();
                String correo = txtcorreocrear.getText();
                String pass = new String(passcrearEmple.getPassword());
				if (nombre.isEmpty()){
					JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "Debe ingresar nombres.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (apellido.isEmpty()) {
					JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "Debe ingresar apellidos.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (sueldo.isEmpty()) {
					JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "Debe ingresar sueldo.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				IntegerValidator integerValidator = new IntegerValidator();
				if (!integerValidator.isValid(sueldo)) {
					JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "Debe ingresar un sueldo válido. Debe ser un valor numérico.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int sueldo1 = Integer.parseInt(sueldo);

				if (sueldo1 <= 0) {
					JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "Debe ingresar un sueldo válido. Debe ser un valor numérico mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Utilities.validarEmail(correo)) {
					JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "Debe ingresar un correo válido.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!Utilities.validarPassword(pass)) {
					JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "Debe ingresar una contraseña válida. Debe tener al menos un carácter en minúscula, en mayúscula, al menos un número, y debe tener entre 8 y 20 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				usuario usuario1 = gestorLavGui.obtenerUsuariocorreo(correo);
				if (usuario1 != null) {
                    JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "Ya existe un usuario con ese correo.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

				empleado empleado1 = new empleado();
				empleado1.setNombre(nombre);
				empleado1.setApellido(apellido);
				empleado1.setSueldo(sueldo1);
				empleado1.setId_rol(opcionesroles.get(rol));

				usuario1  = new usuario();
				usuario1.setCorreo(correo);
				usuario1.setClave(pass);

				empleado1 = gestorLavGui.crearEmpleado(empleado1);
				if (empleado1 == null) {
					JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "No se pudo crear el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

                usuario1.setId_empleado(empleado1.getId_empleado());

				usuario1 = gestorLavGui.crearUsuario(usuario1);

				if (usuario1 == null) {
                    JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "No se pudo crear el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    if(!gestorLavGui.brorrarEmpleado(empleado1.getId_empleado())){
						JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "No se pudo borrar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					return;
                }

				JOptionPane.showMessageDialog(EmpleadocrearFrame.this, "Empleado creado correctamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
				limpiarCampos();
			}
		});
		empleadopanel.add(btncrearEmpleado, "6, 16");
		cargarRoles(Rolescombo);

	}

	private void limpiarCampos() {
		txtNombre.setText("");
        txtApellido.setText("");
        fielsueldo.setText("");
        txtcorreocrear.setText("");
        passcrearEmple.setText("");
	}

	private void cargarRoles(JComboBox Rolescombo) {
		List<Rol> roles = gestorLavGui.getRoles();
		opcionesroles = new HashMap<String, Integer>();
		for (Rol rol : roles) {
			Rolescombo.addItem(rol.getDescripcion());
			opcionesroles.put(rol.getDescripcion(), rol.getId_rol());
		}
	}

}
