package dominio;

//import org.joda.time.LocalDate;

//import java.util.Locale;

//@SuppressWarnings("unused")
public class Usuario extends Trabajador{
	
	//private boolean flagTerminosLeg;
	private String cargo;
	private String clave;
	private String fechaRegistro;
	private String rol;
	//private Academia academia;

	
	public Usuario(){
		super("","","","","","","");
		}
	
	public Usuario(String dni,String correo, String nombres, String apellido_paterno, String apellido_materno, String cargo, String clave, String fechaRegistro, String rol, String direccion, String telefono){
		super(dni, correo, nombres, apellido_paterno, apellido_materno, direccion, telefono);
		
		setCargo(cargo);
		setClave(clave);
		setFechaRegistro(fechaRegistro);
		setRol(rol);

	}
	public String getCargo(){
		return cargo;
	}
	public void setCargo(String cargo){
		this.cargo = cargo;
	}
	public String getFechaRegistro(){
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro){
		this.fechaRegistro = fechaRegistro;
	}
	
	public String getClave(){
		return clave;
	}
	public void setClave(String clave){
		this.clave = clave;
	}
	
	public String getRol(){
		return rol;
	}
	public void setRol(String rol){
		this.rol = rol;
	}
	
	public boolean ValidaDatos(String dni, String correo, String Nombres,
			String Apellido_Paterno, String Apellido_Materno, String direccion, String telefono) {
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
if (correo==null) {
	 validado = false;
	
}

if (direccion==null) {
	 validado = false;
	
}
if (telefono==null) {
	 validado = false;
	
}


		return validado;
	}

	public String setCargo() {
		// TODO Auto-generated method stub
		return cargo;
	}




}
