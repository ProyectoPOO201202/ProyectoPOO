package dominio;

public class Academia {
	
	private String codigo;
	private String razon_social;
	private String direccion;	
	
	public Academia(String codigo, String razon_social, String direccion) {
		super();
		this.codigo = codigo;
		this.razon_social = razon_social;
		this.direccion = direccion;
	}	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
