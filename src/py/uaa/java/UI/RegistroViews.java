package py.uaa.java.UI;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import py.uaa.java.dao.RegistroDao;
import py.uaa.java.model.Registro;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;

import javax.swing.JMenuItem;




public class RegistroViews extends JFrame {
	
	JPopupMenu popup = new JPopupMenu();
	JMenuItem jMItem = new JMenuItem("Eliminar registro");

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNropc;
	private JTextField txtObservacion;
	private JTextField txtTecnico;
	private JTextField txtCliente;
	private JTextField txtDetalle;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroViews dialog = new RegistroViews();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @return 
	 * 
	 */
	
	
	public RegistroViews() {
		setBounds(100, 100, 660, 468);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNropc = new JLabel("Nro Pc:");
		lblNropc.setBounds(15, 16, 71, 14);
		
		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setBounds(15, 41, 71, 14);
		
		JLabel lblObeservacion = new JLabel("Observacion:");
		lblObeservacion.setBounds(15, 69, 80, 14);
		
		JLabel lblfecha = new JLabel("Fecha:");
		lblfecha.setBounds(15, 106, 71, 14);
		
		JLabel lblTecnico = new JLabel("Tecnico:");
		lblTecnico.setBounds(15, 131, 71, 14);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(15, 165, 71, 14);
		
		txtNropc = new JTextField();
		txtNropc.setBounds(124, 16, 45, 20);
		txtNropc.setColumns(10);
		
		txtObservacion = new JTextField();
		txtObservacion.setBounds(124, 66, 405, 20);
		txtObservacion.setColumns(10);
		
		txtTecnico = new JTextField();
		txtTecnico.setBounds(124, 131, 405, 20);
		txtTecnico.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(124, 162, 405, 20);
		txtCliente.setColumns(10);
		
		JDateChooser txtFecha = new JDateChooser();
		txtFecha.setBounds(124, 97, 95, 20);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(124, 42, 405, 20);
		txtDetalle.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(543, 37, 91, 23);
		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					Registro registro = new Registro();
										
					String nroPc = txtNropc.getText();
					registro.setNroPC(Integer.valueOf(nroPc));
					
					registro.setDetalle(txtDetalle.getText());
					registro.setObservacion(txtObservacion.getText());
					registro.setFecha(txtFecha.getDate());
					registro.setTecnico(txtTecnico.getText());
					registro.setCliente(txtCliente.getText());
					

					RegistroDao registroDao = new RegistroDao();
					Boolean isInserted = registroDao.insertarRegistro(registro);
					
					if (isInserted){
				        JOptionPane.showMessageDialog(null, "Registro insertado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
				        

					}else{
				        JOptionPane.showMessageDialog(null, "No se pudo insertar el registro ", null, JOptionPane.ERROR_MESSAGE, null);
					}
					
					txtNropc.setText("");
					txtDetalle.setText("");
					txtObservacion.setText("");
					txtFecha.setDate(null);
					txtTecnico.setText("");
					txtCliente.setText("");
					
				} catch (SQLException e1) {
		 
					System.out.println(e1.getMessage());
		 
				}
			}
		});
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(543, 71, 91, 23);
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNropc.setText("");
				txtDetalle.setText("");
				txtObservacion.setText("");
				txtFecha.setDate(null);
				txtTecnico.setText("");
				txtCliente.setText("");
			}
		});
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(543, 122, 91, 23);
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registro registro = new Registro();
				String nropc = txtNropc.getText();
				registro.setNroPC(Integer.valueOf(nropc));
				registro.setDetalle(txtDetalle.getText());
				registro.setObservacion(txtObservacion.getText());
				registro.setFecha(txtFecha.getDate());
				registro.setTecnico(txtTecnico.getText());
				registro.setCliente(txtCliente.getText());
				
				RegistroDao registroDao = new RegistroDao();
				Boolean isUpdated = registroDao.actualizarRegistro(registro);
				
				if (isUpdated){
				    JOptionPane.showMessageDialog(null, "Registro insertado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
				    
				}else{
				    JOptionPane.showMessageDialog(null, "No se pudo insertar el registro del alumno", null, JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		
		
		contentPanel.setLayout(null);
		contentPanel.add(btnInsertar);
		contentPanel.add(lblNropc);
		contentPanel.add(lblDetalle);
		contentPanel.add(lblObeservacion);
		contentPanel.add(lblfecha);
		contentPanel.add(lblTecnico);
		contentPanel.add(lblCliente);
		contentPanel.add(txtFecha);
		contentPanel.add(txtTecnico);
		contentPanel.add(txtObservacion);
		contentPanel.add(txtCliente);
		contentPanel.add(txtNropc);
		contentPanel.add(txtDetalle);
		contentPanel.add(btnLimpiar);
		contentPanel.add(btnActualizar);
		
		
		JButton btnMostrar = new JButton("Mostrar");
		
				
					
	
		
		btnMostrar.setBounds(15, 205, 80, 23);
		contentPanel.add(btnMostrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(543, 161, 91, 23);
			
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
													
					Registro registro = new Registro();
				
					String nroPc = txtNropc.getText();
					registro.setNroPC(Integer.valueOf(nroPc));
					registro.setFecha(txtFecha.getDate());
				
					RegistroDao registroDao = new RegistroDao();
					Boolean isDeleted = registroDao.eliminarRegistro(registro);
			
					if (isDeleted){
						JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
					}else{
			        JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro de mantemiento", null, JOptionPane.ERROR_MESSAGE, null);
					}
					
				}
		});
		contentPanel.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 244, 619, 174);
		contentPanel.add(scrollPane);
			btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table = new JTable();
		
				DefaultTableModel modelo = new DefaultTableModel(){
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex, int columnIndex){
				       //all cells false
				       return false;
				}};
				modelo.addColumn("Nro Pc");
				modelo.addColumn("Detalle");
				modelo.addColumn("Observacion");
				modelo.addColumn("Fecha");
				modelo.addColumn("Tecnico");
				modelo.addColumn("Cliente");
				ArrayList<Object[]> datos= new ArrayList<Object[]>();
				datos = RegistroDao.llenarTabla();
				for(int i = 0; i<datos.size(); i++){
					modelo.addRow(datos.get(i));
					
				}
				table.setModel(modelo);
				scrollPane.setViewportView(table);
				
				table.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						int i = table.getSelectedRow();
						if(i>=0){
						txtNropc.setText (table.getValueAt(i, 0).toString());
						txtDetalle.setText(table.getValueAt(i, 1).toString());
						txtObservacion.setText(table.getValueAt(i, 2).toString());
						txtFecha.setDate((Date) (table.getValueAt(i, 3)));
						txtTecnico.setText(table.getValueAt(i, 4).toString());
						txtCliente.setText(table.getValueAt(i, 5).toString());
						}
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				}
		});
		
	}

	
	
}
 
