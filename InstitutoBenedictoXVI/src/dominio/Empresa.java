package dominio;

public class Empresa {	
	
	private String codigo;	
	private String razon_social;
	private String rubro;
	private String direccion;
	private String correo;
	private String telefono;	
	private String ciudad;
	private String pais;
	private String estado;
	private String observaciones;
	
		public Empresa(String codigo, String razon_social, String rubro,
			String direccion, String correo, String telefono, String ciudad,
			String pais, String estado, String observaciones) {
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
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	

}
