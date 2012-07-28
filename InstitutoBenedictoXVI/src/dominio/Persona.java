package dominio;

public abstract class Persona {

protected String dni;
protected String nombres;
protected String apellido_paterno;
protected String apellido_materno;
protected String telefono;
protected String correo;
protected String direccion;
protected String distrito;
protected String departamento;


public Persona (String dni,String nombres, String apellido_paterno, String apellido_materno, String telefono, String correo, String direccion, String distrito, String departamento)
{
	  setDni(dni);
	  setNombres(nombres);
	  setApellido_Paterno(apellido_paterno);
	  setApellido_Materno(apellido_materno);
      setTelefono(telefono);
      setCorreo(correo);
      setDireccion(direccion);
      setDistrito(distrito);
      setDepartamento(departamento);
   	
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
public String getDistrito() {
	return distrito;
}
public void setDistrito(String distrito) {
	this.distrito = distrito;
}
public String getDepartamento() {
	return departamento;
}
public void setDepartamento(String departamento) {
	this.departamento = departamento;
}









}
