package dominio;

//import java.util.Locale;

import org.joda.time.LocalDate;


//@SuppressWarnings("unused")
public class Usuario {
	
	private String dni;
	private String correo;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String cargo;
	private String clave;
	private boolean flagTerminosLeg;
	private LocalDate fechaRegistro;
	private String rol;
	private Academia academia;

	
	public String getDni(){
		return dni;
	}
	
	public String setDni(String dni){
		return this.dni;
	}
	public String getNombre(){
		return nombre;
	}
	
	public String setNombre(String nombre){
		return this.nombre;
	}
	
	public String getApellidoPaterno(){
		return apellidoPaterno;
	}
	
	public String setApellidoPaterno(String apellidoPaterno){
		return this.apellidoPaterno;
	}
	
	public String getCargo(){
		return cargo;
	}
	
	public String setCargo(String cargo){
		return this.cargo;
	}
	
	public String getCorreo() {
		// TODO Auto-generated method stub
		return correo;
	}
	public String setCorreo(String correo) {
		return this.correo = correo;
		
	}

	public String getClave() {
		// TODO Auto-generated method stub
		return clave;
	}

	public void setClave(String clave) {
		// TODO Auto-generated method stub
		this.clave = clave;
		
	}

	public boolean isflagTerminosLeg() {
		return flagTerminosLeg;
	}
	
	public void setFlagTerminosLeg(boolean flagTerminosLeg) {
		this.flagTerminosLeg = flagTerminosLeg;
		// TODO Auto-generated method stub
		
	}

	public LocalDate getFechaRegistro(){
		return fechaRegistro;
		
	}

	public void setFechaRegistro(LocalDate fechaRegistro){
		this.fechaRegistro = fechaRegistro;
	}

	

	public String getRol() {
		// TODO Auto-generated method stub
		return rol;
	}

	public void setRol(String rol) {
		// TODO Auto-generated method stub
		this.rol = rol;
		
	}

	
	public Academia getAcademia() {
		// TODO Auto-generated method stub
		return academia;
	}
	
	public void setAcademia(Academia academia){
		this.academia = academia;
	}

	
	public  String getApellidoMaterno() {
		return apellidoMaterno;
		// TODO Auto-generated method stub
		
	}
	public String setApellidoMaterno(String apellidoMaterno){
		return this.apellidoMaterno;
	}

	

	


}
