package dominio;

public class Trabajador {
	
	protected String dni;
	protected String correo;
	protected String nombres;
	protected String apellido_paterno;
	protected String apellido_materno;
	protected String direccion;
	protected String telefono;
	


	public Trabajador(String dni,  String correo, String nombres, String apellido_paterno,
			String apellido_materno, String direccion, String telefono) {
		// TODO Auto-generated constructor stub
	
		  setDni(dni);
		  setCorreo(correo);
		  setNombres(nombres);
		  setApellido_Paterno(apellido_paterno);
		  setApellido_Materno(apellido_materno);
		  setDireccion(direccion);
	      setTelefono(telefono);
	    
	  
	   	
	}



	public String getDni(){
		return dni;
	}
	public void setDni(String dni) {
		this.dni=dni;
	}

	public String getNombres(){
		return nombres;
	}
	public void setNombres(String nombres){
		this.nombres=nombres;
	}

	public String getApellido_Paterno(){
		return apellido_paterno;
	}
	public void setApellido_Paterno(String apellido_paterno) {
		this.apellido_paterno=apellido_paterno;
	}


	public String getApellido_Materno(){
		return apellido_materno;
	}
	public void setApellido_Materno(String apellido_materno) {
		this.apellido_materno=apellido_materno;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


}
