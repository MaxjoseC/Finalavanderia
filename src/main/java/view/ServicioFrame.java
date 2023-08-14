package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServicioFrame extends JInternalFrame {
	private JTextField txtservicioID;
	private JTextField txtDescripcionS;
	private JTable tableS;


	/**
	 * Create the frame.
	 */
	public ServicioFrame() {
		setTitle("Servicios");
		setClosable(true);
		setBounds(100, 100, 600, 700);
		
		JPanel Pnelservicios = new JPanel();
		Pnelservicios.setBorder(new TitledBorder(null, "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(Pnelservicios, BorderLayout.NORTH);
		Pnelservicios.setLayout(new BorderLayout(0, 0));
		
		JPanel pnelDatos = new JPanel();
		pnelDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Pnelservicios.add(pnelDatos, BorderLayout.NORTH);
		pnelDatos.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblservicioID = new JLabel("ID:");
		pnelDatos.add(lblservicioID, "2, 2");
		
		txtservicioID = new JTextField();
		pnelDatos.add(txtservicioID, "10, 2, fill, default");
		txtservicioID.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		pnelDatos.add(lblDescripcion, "2, 4");
		
		txtDescripcionS = new JTextField();
		pnelDatos.add(txtDescripcionS, "10, 4, fill, default");
		txtDescripcionS.setColumns(10);
		
		JLabel lblEmpleadoS = new JLabel("Empleado:");
		pnelDatos.add(lblEmpleadoS, "2, 6");
		
		JComboBox cmbEmpleadoS = new JComboBox();
		pnelDatos.add(cmbEmpleadoS, "10, 6, fill, default");
		
		JLabel lblClienteS = new JLabel("Clientel");
		pnelDatos.add(lblClienteS, "2, 8");
		
		JComboBox cmbClienteS = new JComboBox();
		pnelDatos.add(cmbClienteS, "10, 8, fill, default");
		
		JPanel pnlSacciones = new JPanel();
		Pnelservicios.add(pnlSacciones, BorderLayout.CENTER);
		pnlSacciones.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnnuevoS = new JButton("Nuevo");
		btnnuevoS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlSacciones.add(btnnuevoS);
		
		JButton btnguardarservicio = new JButton("Guardar");
		pnlSacciones.add(btnguardarservicio);
		
		JButton btnNuevo = new JButton("Actualizar");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlSacciones.add(btnNuevo);
		
		JButton btnBuscarS = new JButton("Buscar");
		btnBuscarS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlSacciones.add(btnBuscarS);
		
		JButton btnBorrar = new JButton("Borrar");
		pnlSacciones.add(btnBorrar);
		
		JPanel pnRegistro = new JPanel();
		pnRegistro.setBorder(new TitledBorder(null, "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Pnelservicios.add(pnRegistro, BorderLayout.SOUTH);
		pnRegistro.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPnServicioR = new JScrollPane();
		pnRegistro.add(scrollPnServicioR, BorderLayout.CENTER);
		
		tableS = new JTable();
		tableS.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Descripci\u00F3n", "Empleado", "Cliente"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPnServicioR.setViewportView(tableS);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Atenciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnRegistro.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

	}

}
