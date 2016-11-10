package py.uaa.java.dao;
import java.util.List;


import py.uaa.java.model.Registro;;
public class Main {
		
		public static void main(String[] args) {
			RegistroDao registroDao = new RegistroDao();
			List<Registro> registros = registroDao.recuperarRegistros();
			
			for (Registro registro : registros) {
				System.out.println(registro.toString());
			}
			
			
		}
}
