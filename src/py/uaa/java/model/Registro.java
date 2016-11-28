package py.uaa.java.model;
import java.util.Date;


public class Registro {
	//Atributos
	
	private int NroPC;
	private String Detalle;
	private String Observacion;
	private Date Fecha;
	private String Tecnico;
	private String Cliente;
	
	
	
	
	//Constructor
	public Registro(int NroPC, String Detalle,String Observacion, Date Fecha,
			String Tecnico, String Cliente) {
		super();
		this.NroPC = NroPC;
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
	public int getNroPC() {
		return NroPC;
	}

	public void setNroPC(int nroPc) {
		this.NroPC = nroPc;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	
	public Date getFecha() {
		return Fecha;
	}


	public void setFecha(Date fecha) {
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
