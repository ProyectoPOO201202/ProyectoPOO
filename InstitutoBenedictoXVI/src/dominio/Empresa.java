package dominio;

public class Empresa {	
	
public enum Estado {ACTIVA, INACTIVA, SUSPENDIDA}	
public enum Rubro {UTILES, SERVICIOS, COMPUTO, LIMPIEZA, CLIENTE}	
	
	private String codigo;	
	private String razon_social;
	private Rubro rubro;
	private String direccion;
	private String correo;
	private String telefono;	
	private String ciudad;
	private String pais;
	private Estado estado;
	private String observaciones;
	
		public Empresa(String codigo, String razon_social, Rubro rubro,
			String direccion, String correo, String telefono, String ciudad,
			String pais, Estado estado, String observaciones) {
		super();
		this.codigo = codigo;
		this.razon_social = razon_social;
		this.rubro = rubro;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.pais = pais;
		this.estado = estado;
		this.observaciones = observaciones;
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
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	

}
