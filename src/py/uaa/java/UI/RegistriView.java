package py.uaa.java.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


import py.uaa.java.dao.RegistroDao;
import py.uaa.java.model.Registro;
import javax.swing.JFormattedTextField;


public class RegistriView {

	private JFrame frmRegistro;
	private JTextField txtidPC;
	private JTextField txtDetalle;
	private JTextField txtObservacion;
	private JTextField txtTecnico;
	private JTextField txtCliente;
	private JTextField txtFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistriView window = new RegistriView();
					window.frmRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistriView() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistro = new JFrame();
		frmRegistro.setTitle("Registro de PC");
		frmRegistro.setBounds(100, 100, 392, 353);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		
		JLabel lblidPC = new JLabel("Id PC:");
		lblidPC.setBounds(22, 42, 46, 14);
		frmRegistro.getContentPane().add(lblidPC);
		
		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setBounds(22, 76, 46, 14);
		frmRegistro.getContentPane().add(lblDetalle);
		
		JLabel lblObservacion = new JLabel("Observacion:");
		lblObservacion.setBounds(22, 111, 75, 14);
		frmRegistro.getContentPane().add(lblObservacion);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 152, 46, 14);
		frmRegistro.getContentPane().add(lblFecha);
		
		JLabel lblTecnico = new JLabel("Tecnico:");
		lblTecnico.setBounds(22, 184, 46, 14);
		frmRegistro.getContentPane().add(lblTecnico);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(22, 218, 46, 14);
		frmRegistro.getContentPane().add(lblCliente);
		
		txtidPC = new JTextField();
		txtidPC.setBounds(96, 39, 86, 20);
		frmRegistro.getContentPane().add(txtidPC);
		txtidPC.setColumns(10);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(96, 73, 246, 20);
		frmRegistro.getContentPane().add(txtDetalle);
		txtDetalle.setColumns(10);
		
		txtObservacion = new JTextField();
		txtObservacion.setBounds(96, 108, 246, 20);
		frmRegistro.getContentPane().add(txtObservacion);
		txtObservacion.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(253, 280, 89, 23);
		frmRegistro.getContentPane().add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(137, 280, 89, 23);
		frmRegistro.getContentPane().add(btnActualizar);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInsertar.addMouseListener(new MouseAdapter() {
			
			/**
			 * Click en el boton Agregar
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					
					Registro registro = new Registro();
					
					
					String idPC = txtidPC.getText();
					registro.setidPC(Integer.valueOf(idPC));
					
					registro.setDetalle(txtDetalle.getText());
					registro.setObservacion(txtObservacion.getText());
					registro.setFecha(txtFecha.getText());
					registro.setTecnico(txtTecnico.getText());
					registro.setCliente(txtCliente.getText());
					

					RegistroDao registroDao = new RegistroDao();
					Boolean isInserted = registroDao.insertarRegistro(registro);
					
					if (isInserted){
				        JOptionPane.showMessageDialog(null, "Registro insertado correctamente", "", JOptionPane.INFORMATION_MESSAGE);

					}else{
				        JOptionPane.showMessageDialog(null, "No se pudo insertar el registro ", null, JOptionPane.ERROR_MESSAGE, null);
					}
					
				} catch (SQLException e) {
		 
					System.out.println(e.getMessage());
		 
				}
			} 
		});
		
		
		
		
		btnInsertar.setBounds(22, 280, 89, 23);
		frmRegistro.getContentPane().add(btnInsertar);
		
		txtTecnico = new JTextField();
		txtTecnico.setBounds(96, 181, 246, 20);
		frmRegistro.getContentPane().add(txtTecnico);
		txtTecnico.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(96, 215, 246, 20);
		frmRegistro.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(96, 149, 86, 20);
		frmRegistro.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
	}
  }

