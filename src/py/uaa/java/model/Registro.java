package py.uaa.java.model;



public class Registro {
	//Atributos
	
	private int idPC;
	private String Detalle;
	private String Observacion;
	private String Fecha;
	private String Tecnico;
	private String Cliente;
	
	
	
	
	//Constructor
	public Registro(int idPC, String Detalle,String Observacion, String Fecha,
			String Tecnico, String Cliente) {
		super();
		this.idPC = idPC;
		this.Detalle = Detalle;
		this.Observacion = Observacion;
		this.Fecha = Fecha;
		this.Tecnico = Tecnico;
		this.Cliente = Cliente;
		
	}

	
	public Registro() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getters y setter
	public int getidPC() {
		return idPC;
	}

	public void setidPC(int idPC) {
		this.idPC = idPC;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	
	public String getFecha() {
		return Fecha;
	}


	public void setFecha(String fecha) {
		Fecha = fecha;
	}


	public String getTecnico() {
		return Tecnico;
	}

	public void setTecnico(String tecnico) {
		Tecnico = tecnico;
	}
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	
	
}
