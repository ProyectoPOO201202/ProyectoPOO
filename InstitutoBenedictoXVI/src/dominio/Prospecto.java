package dominio;



public class Prospecto extends Persona {

	private String fechacontacto;
	
	
	public Prospecto(){
		super("","","","","","","","","");
		}
	
	public Prospecto(String dni,String nombres, String apellido_paterno, String apellido_materno, String telefono, String fechacontacto, String correo, String direccion, String distrito, String departamento){
		super(dni,nombres, apellido_paterno, apellido_materno,telefono, correo,direccion,distrito, departamento);
		
		setFechaContacto(fechacontacto);

	}

	public String getFechaContacto() {
		return fechacontacto;
	}
	public void setFechaContacto(String fechacontacto) {
		this.fechacontacto = fechacontacto;
	}

	public boolean ValidaDatos(String dni, String Nombres,
			String Apellido_Paterno, String Apellido_Materno, String Email,
			String Telefono) {
boolean validado = true;
if (dni==null) {
	 validado = false;
	
}
if (Nombres==null) {
	 validado = false;
	
}
if (Apellido_Paterno==null) {
	 validado = false;
	
}
if (Apellido_Materno==null) {
	 validado = false;
	
}
if (Email==null) {
	 validado = false;
	
}
if (Telefono==null) {
	 validado = false;
	
}
		return validado;
	}



}
