package py.uaa.java.UI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import py.uaa.java.dao.RegistroDao;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class ConsultarRegistro extends JDialog {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultarRegistro dialog = new ConsultarRegistro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarRegistro() {
		setBounds(100, 100, 731, 278);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 695, 189);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
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
				
				}
		});
		btnConsultar.setBounds(10, 11, 89, 23);
		contentPanel.add(btnConsultar);
	}
}
