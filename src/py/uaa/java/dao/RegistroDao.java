package py.uaa.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import py.uaa.java.model.Registro;

public class RegistroDao {
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/registro";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "elpirata";
	
	
	public static boolean validarSiExisteREgistro(Registro registro) throws SQLException{
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select * from registro where idPC = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
 			preparedStatement.setInt(1, registro.getidPC());
			
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
				+ "(idPC, detalle, observacion, fecha, Tecnico, Cliente) VALUES"
				+ "(?,?,?,?,?,?)";
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
 
			
			preparedStatement.setInt(1, registro.getidPC());
			preparedStatement.setString(2, registro.getDetalle());
			preparedStatement.setString(3, registro.getObservacion());
			preparedStatement.setString(4, registro.getFecha());
			preparedStatement.setString(5, registro.getTecnico());
			preparedStatement.setString(6, registro.getCliente());
			
 
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
	public List<Registro> recuperarRegistros() {
		Connection dbConnection = null;
		Statement statement = null;

		String query = "SELECT * FROM registro";
		List<Registro> registros = new ArrayList<Registro>();
		
		try {
			dbConnection = getDBConnection();
			ResultSet rs = dbConnection.createStatement().executeQuery(query);
			while (rs.next()) {
				Registro registro = new Registro();
				registro.setidPC(rs.getInt(1));
				registro.setDetalle(rs.getString(2));
				registro.setObservacion(rs.getString(3));
				registro.setFecha(rs.getString(4));
				registro.setTecnico(rs.getString(5));
				registro.setCliente(rs.getString(6));
				
				registros.add(registro);
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
		
		return registros;

	}
}

