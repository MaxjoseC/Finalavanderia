package view;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpleadocrearFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField fielsueldo;
	private JTextField txtcorreocrear;
	private JPasswordField passcrearEmple;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EmpleadocrearFrame() {
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
			}
		});
		empleadopanel.add(btncrearEmpleado, "6, 16");

	}

}