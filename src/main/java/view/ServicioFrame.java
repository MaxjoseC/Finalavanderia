package view;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.util.List;

import modelos.cliente;
import modelos.empleado;
import view.combobox.ClientesComboBoxModel;
import view.combobox.EmpleadosComboBoxModel;

public class ServicioFrame extends JInternalFrame {
	private JTextField txtservicioID;
	private JTextField txtDescripcionS;
	private JTable tableS;
	private JTextField txtatencionID;
	private JTextField txtPrecio;
	private JTable table;
	private GestorLavGui gestorLavGui;
	private ClientesComboBoxModel clienteComboBoxModel;
	private EmpleadosComboBoxModel empleadoComboBoxModel;
	private JComboBox cmbClienteS;
	private JComboBox cmbEmpleadoS;
	private JSpinner spinner;
	private JComboBox cmbTipoAten;


	/**
	 * Create the frame.
	 */
	public ServicioFrame(GestorLavGui gestorLavGui) {
		this.gestorLavGui = gestorLavGui;
		setTitle("Servicios");
		setClosable(true);
		setBounds(100, 100, 841, 654);

		JPanel Pnelservicios = new JPanel();
		Pnelservicios.setBorder(new TitledBorder(null, "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(Pnelservicios, BorderLayout.NORTH);
		Pnelservicios.setLayout(new BorderLayout(0, 0));

		JPanel pnelDatos = new JPanel();
		pnelDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Pnelservicios.add(pnelDatos, BorderLayout.NORTH);
		pnelDatos.setLayout(new FormLayout(new ColumnSpec[]{
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
				new RowSpec[]{
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
				String servicioid = txtatencionID.getText();
				String descripcion = txtDescripcionS.getText();
				int clienteIndice = cmbClienteS.getSelectedIndex();

				if (!servicioid.isEmpty() || !descripcion.isEmpty() || clienteIndice > 0) {
					//dialogo de confirmacion
					int confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea iniciar un nuevo servicio?", "Confirmacion", JOptionPane.YES_NO_OPTION);
					if (confirmacion == JOptionPane.YES_OPTION) {
						limpiarcamposServicios();
					}
					return;
				}else{
					limpiarcamposServicios();
				}
			}

			private void limpiarcamposServicios() {
				txtservicioID.setText("");
				txtDescripcionS.setText("");
				empleado empleado1 = gestorLavGui.getEmpleado();
				cargarEmpleados(empleado1.getId_empleado());

			}
		});
		pnlSacciones.add(btnnuevoS);

		JButton btnguardarservicio = new JButton("Agregar");
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

		JButton btnBorrar = new JButton("Eliminar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});


		pnlSacciones.add(btnBorrar);

		JPanel pnRegistro = new JPanel();
		pnRegistro.setBorder(new TitledBorder(null, "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Pnelservicios.add(pnRegistro, BorderLayout.SOUTH);
		pnRegistro.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPnServicioR = new JScrollPane();
		scrollPnServicioR.setMaximumSize(new Dimension(600, 700));
		scrollPnServicioR.setSize(new Dimension(600, 600));
		pnRegistro.add(scrollPnServicioR, BorderLayout.CENTER);

		tableS = new JTable();
		tableS.setRowHeight(8);
		tableS.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"ID", "Descripci\u00F3n", "Empleado", "Cliente"
				}
		) {
			boolean[] columnEditables = new boolean[]{
					false, false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPnServicioR.setViewportView(tableS);
		tableS.setSize(200, 200);
		tableS.setPreferredScrollableViewportSize(new Dimension(600, 80));
		JPanel pnAtenciones = new JPanel();
		pnAtenciones.setBorder(new TitledBorder(null, "Atenciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnRegistro.add(pnAtenciones, BorderLayout.SOUTH);
		pnAtenciones.setLayout(new BorderLayout(0, 0));

		JPanel pndatosA = new JPanel();
		pndatosA.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnAtenciones.add(pndatosA, BorderLayout.CENTER);
		pndatosA.setLayout(new FormLayout(new ColumnSpec[]{
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				new RowSpec[]{
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

		JLabel lblidAten = new JLabel("ID:");
		pndatosA.add(lblidAten, "2, 2");

		txtatencionID = new JTextField();
		pndatosA.add(txtatencionID, "14, 2, fill, default");
		txtatencionID.setColumns(10);

		JLabel lblAtencionCantidad = new JLabel("Cantidad:");
		pndatosA.add(lblAtencionCantidad, "2, 4");

		JSpinner spinner = new JSpinner();
		pndatosA.add(spinner, "14, 4");

		JLabel lblPrecioA = new JLabel("Precio:");
		pndatosA.add(lblPrecioA, "2, 6");

		txtPrecio = new JTextField();
		pndatosA.add(txtPrecio, "14, 6, fill, default");
		txtPrecio.setColumns(10);

		JLabel lblnuevo = new JLabel("Tipo");
		pndatosA.add(lblnuevo, "2, 8");

		JComboBox cmbTipoAten = new JComboBox();
		pndatosA.add(cmbTipoAten, "14, 8, fill, default");

		JButton btnAtenAgregar = new JButton("Agregar");
		btnAtenAgregar.addActionListener(e -> {

		});
		pndatosA.add(btnAtenAgregar, "14, 10");

		JPanel pnRegistroA = new JPanel();
		pnRegistroA.setBorder(new TitledBorder(null, "Registros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnAtenciones.add(pnRegistroA, BorderLayout.SOUTH);
		pnRegistroA.setLayout(new BorderLayout(0, 0));

		JScrollPane scrpnRegistroA = new JScrollPane();
		pnRegistroA.add(scrpnRegistroA, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[]{
						"ID", "Precio", "Cantidad", "Tipo"
				}
		) {
			boolean[] columnEditables = new boolean[]{
					false, false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		scrpnRegistroA.setViewportView(table);
		table.setSize(200, 200);
		table.setPreferredScrollableViewportSize(new Dimension(600, 80));


		}
	private void cargarclientes() {
		List<cliente> clientes = gestorLavGui.getclientes();

		cliente[] clientesArray = new cliente[clientes.size()];
		clientes.toArray(clientesArray);

		clienteComboBoxModel = new ClientesComboBoxModel(clientesArray);
		cmbClienteS.setModel(clienteComboBoxModel);
		cmbClienteS.setSelectedIndex(0);

		final int clienteId = clientes.get(0).getId_cliente();
	}
	private void cargarEmpleados(int Id_empleado) {
		empleado empleadoActual = gestorLavGui.obtenerEmpleadoActual();
		List<empleado> empleados = gestorLavGui.obtenerempleados();

		empleado[] empleadosArray = new empleado[empleados.size()];
		empleados.toArray(empleadosArray);

		empleadoComboBoxModel = new EmpleadosComboBoxModel(empleadosArray);
		cmbEmpleadoS.setModel(empleadoComboBoxModel);
		cmbEmpleadoS.setSelectedIndex(empleadoComboBoxModel.getIndexOf(empleadoActual.getId_empleado()));
	}
	/**
	 * limpiar los campos de atencion
	 *
	 */
	private void limpiarCamposAtencion() {
        txtatencionID.setText("");
        spinner.setValue(0);
        txtPrecio.setText("");
        cmbTipoAten.setSelectedIndex(0);
    }
	/**limpiar la tabla de atenciones;
	 *
	 */
	private void limpiarTablaAtenciones() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
    /**
     * limpiar los campos de registro
     *
     */
    private void limpiarCamposRegistro() {
        txtatencionID.setText("");
        spinner.setValue(0);
        txtPrecio.setText("");
        cmbTipoAten.setSelectedIndex(0);
    }
    /**limpiar la tabla de registros;
     *
     */
    private void limpiarTablaRegistro() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
  



}


