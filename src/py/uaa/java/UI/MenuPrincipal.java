package py.uaa.java.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 577, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAbmRegistro = new JMenuItem("ABM Registro");
		mntmAbmRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroViews rv = new RegistroViews();
				rv.setVisible(true);
			}
		});
		mnArchivo.add(mntmAbmRegistro);
		
		JMenuItem mntmConsultaDeRegistro = new JMenuItem("Consulta de Registro");
		mntmConsultaDeRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarRegistro cr = new ConsultarRegistro();
				cr.setVisible(true);
			}
		});
		mnArchivo.add(mntmConsultaDeRegistro);
	}
}
