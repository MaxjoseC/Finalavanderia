package view;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import modelos.cliente;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class Clienteframe extends JInternalFrame {
	private JTextField txtNombrecliente;
	private JTextField txtApellidoCliente;
	private JTable tblRegistros;
	private JTable table;
	JSpinner IDspin;
	private GestorLavGui gestorLavGui;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Clienteframe(GestorLavGui gestorLavGui) {
		this.gestorLavGui = gestorLavGui;


		setBounds(100, 100, 454, 619);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setClosable(true);

		JPanel pnDatos = new JPanel();
		pnDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		getContentPane().add(pnDatos, BorderLayout.NORTH);
		pnDatos.setLayout(new FormLayout(new ColumnSpec[]{
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[]{
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblID = new JLabel("ID:");
		pnDatos.add(lblID, "2, 2");

		IDspin = new JSpinner();
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
				if (haydatosPresentes()){
					//preguntar si desea limpiar los datos
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea limpiar los datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION){
                        limpiar();
                    }

				}
			}
		});
		panel.add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//guardar los campos en la tabla cliente
				String nombre = txtNombrecliente.getText().trim();
				String apellido = txtApellidoCliente.getText().trim();

				cliente cliente1 = new cliente();
				cliente1.setNombre(nombre);
				cliente1.setApellido(apellido);
				if (nombre.isEmpty() || apellido.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (gestorLavGui.crearcliente(cliente1) != null){
					JOptionPane.showMessageDialog(null, "El cliente se creó correctamente");
                    limpiar();
					agregarregistroclientetabla(cliente1);
				}else{
					JOptionPane.showMessageDialog(null, "Error al crear el cliente", "Error", JOptionPane.WARNING_MESSAGE);
					limpiar();

				}
			}

			private void agregarregistroclientetabla(cliente cliente1) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();

				modelo.addRow(new Object[]{cliente1.getId_cliente(),cliente1.getNombre(),cliente1.getApellido()});

			}
		});
		panel.add(btnGuardar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
				new Object[][]{
						{null, null, null},
				},
				new String[]{
						"ID", "Nombre", "Apellido"
				}
		) {
			boolean[] columnEditables = new boolean[]{
					false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		cargarregistroscliente();
	}

	private void cargarregistroscliente() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);

		for (cliente cliente1 : gestorLavGui.getclientes()) {
			modelo.addRow(new Object[]{cliente1.getId_cliente(),cliente1.getNombre(),cliente1.getApellido()});

		}
	}

	private void limpiar() {
		txtNombrecliente.setText("");
        txtApellidoCliente.setText("");
	}

	private boolean haydatosPresentes() {
		return !txtNombrecliente.getText().trim().isEmpty() ||
		!txtApellidoCliente.getText().trim().isEmpty();
	}
}
