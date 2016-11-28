package py.uaa.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import py.uaa.java.model.Registro;

public class RegistroDao {
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/registro";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "elpirata";
	
	
	public  boolean validarSiExisteREgistro(Registro registro) throws SQLException{
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select * from registro where NroPC = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
 			preparedStatement.setInt(1, registro.getNroPC());
			
			ResultSet rs = 	preparedStatement.executeQuery();
			if (rs.next()) {
				System.out.println("Registro Encontrado");
				return true;
			} else {
				System.out.println("El registro no existe");
				return false;
			}
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
			return false;
			
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
		
	}
 
	public boolean insertarRegistro(Registro registro) throws SQLException {
 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String insertTableSQL = "INSERT INTO registro"
				+ "(nroPC, detalle, observacion, fecha, Tecnico, Cliente) VALUES"
				+ "(?,?,?,?,?,?)";
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
 
			preparedStatement.setInt(1, registro.getNroPC());
			preparedStatement.setString(2, registro.getDetalle());
			preparedStatement.setString(3, registro.getObservacion());
			preparedStatement.setString(5, registro.getTecnico());
			preparedStatement.setString(6, registro.getCliente());
			
		    java.sql.Date fechaRegistroSqlDate = new java.sql.Date(registro.getFecha().getTime());
			preparedStatement.setDate(4, fechaRegistroSqlDate);
 
			preparedStatement.executeUpdate();
		
			System.out.println("Record is inserted into REGISRTO table!");
			return true;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
			return false;
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	}

		
	public boolean eliminarRegistro(Registro registro){
			Connection dbConnection = null;
			PreparedStatement preparedStatement = null;
			String deleteSQL = "DELETE from registro WHERE nropc = ? and fecha = ?";

			try {
				dbConnection = getDBConnection();
				preparedStatement = dbConnection.prepareStatement(deleteSQL);
				preparedStatement.setInt(1, registro.getNroPC());
				java.sql.Date fechaRegistroSqlDate = new java.sql.Date(registro.getFecha().getTime());
				preparedStatement.setDate(2, fechaRegistroSqlDate);
				

				// execute delete SQL stetement
				preparedStatement.executeUpdate();

				System.out.println("Record is deleted!");
				return true;
				
			} catch (SQLException e) {

				System.out.println(e.getMessage());

			} finally {
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}

					if (dbConnection != null) {
						dbConnection.close();
					}
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}

			}
			return false;

		}
	
	public  boolean actualizarRegistro(Registro registro){
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String updateSql = "UPDATE alumno set detalle = ?, obervacion = ?, tecnico = ? WHERE nropc = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(updateSql);
			preparedStatement.setString(1, registro.getDetalle());
			preparedStatement.setString(2, registro.getObservacion());
			java.sql.Date fechaRegistroSqlDate = new java.sql.Date(registro.getFecha().getTime());
			preparedStatement.setDate(4, fechaRegistroSqlDate);
			preparedStatement.setInt(3,registro.getNroPC());
			preparedStatement.setString(4, registro.getTecnico());
			
			// execute delete SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is updated!");
			return true;
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}

		}
		return false;

	}

		 
	private static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
			
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
			
			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 		
	}
	public static ArrayList<Registro> recuperarRegistros() {
		Connection dbConnection = null;
		Statement statement = null;
		
		ArrayList<Registro> miRegistro = new ArrayList<Registro>();
		String query = "SELECT * FROM registro";
				
		try {
			dbConnection = getDBConnection();
			ResultSet rs = dbConnection.createStatement().executeQuery(query);
			while (rs.next()) {
				Registro registro = new Registro();
				registro.setNroPC(rs.getInt(1));
				registro.setDetalle(rs.getString(2));
				registro.setObservacion(rs.getString(3));
				registro.setFecha(rs.getDate(4));
				registro.setTecnico(rs.getString(5));
				registro.setCliente(rs.getString(6));
								
				miRegistro.add(registro);
			}			
		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
	 
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return miRegistro;

	} 
	
	public static ArrayList<Object[]> llenarTabla(){
		Connection dbConnection = null;
		ArrayList<Object[]> datos = new ArrayList<Object[]>();  
		String query = "SELECT * FROM registro";
		try {
			dbConnection = getDBConnection();
			ResultSet rs = dbConnection.createStatement().executeQuery(query);
			while (rs.next()) {
				Object[] filas = new Object[6];
				for (int i = 0; i<6; i++){
					filas[i]= rs.getObject(i+1);
				}datos.add(filas);
			}		
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error", "", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		return datos;
	}
	
}

