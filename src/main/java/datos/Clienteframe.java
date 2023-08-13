package datos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Clienteframe extends JInternalFrame {
	private JTextField txtNombrecliente;
	private JTextField txtApellidoCliente;
	private JTable tblRegistros;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Clienteframe() {
		setBounds(100, 100, 454, 619);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnDatos = new JPanel();
		pnDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		getContentPane().add(pnDatos, BorderLayout.NORTH);
		pnDatos.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblID = new JLabel("ID:");
		pnDatos.add(lblID, "2, 2");
		
		JSpinner IDspin = new JSpinner();
		pnDatos.add(IDspin, "6, 2");
		
		JLabel lblnombre = new JLabel("Nombre:");
		pnDatos.add(lblnombre, "2, 4, default, center");
		
		txtNombrecliente = new JTextField();
		pnDatos.add(txtNombrecliente, "6, 4, fill, default");
		txtNombrecliente.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		pnDatos.add(lblApellido, "2, 6");
		
		txtApellidoCliente = new JTextField();
		pnDatos.add(txtApellidoCliente, "6, 6, fill, default");
		txtApellidoCliente.setColumns(10);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
		
		JButton btnBuscar = new JButton("Buscar");
		panel.add(btnBuscar);
		
		JButton btneditar = new JButton("Editar\r\n");
		panel.add(btneditar);
		
		JButton btnEliminar = new JButton("Èliminar");
		panel.add(btnEliminar);
		
		JPanel pnlRegistros = new JPanel();
        pnlRegistros.setBorder(new TitledBorder(null, "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        getContentPane().add(pnlRegistros, BorderLayout.SOUTH);
        pnlRegistros.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        pnlRegistros.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        	},
        	new String[] {
        		"ID", "Nombre", "Apellido"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        scrollPane.setViewportView(table);
        

	}

}
