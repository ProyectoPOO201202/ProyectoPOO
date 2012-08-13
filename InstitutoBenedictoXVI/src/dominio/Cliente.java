package dominio;



public class Cliente extends Persona{

	private String fechapase;
	private String codigocliente;
	
		
public Cliente(){
	super("","","","","","","","","");
	}

public Cliente (String codigocliente,String dni,String nombres, String apellido_paterno, String apellido_materno, String telefono, String fechapase, String correo, String direccion, String distrito, String departamento){
	
super(dni,nombres, apellido_paterno, apellido_materno,telefono, correo,direccion,distrito, departamento);

setFechaPase(fechapase);
setCodigoCliente(codigocliente);
}
public String getFechaPase() {
	return fechapase;
}
public void setFechaPase(String fechapase) {
	this.fechapase = fechapase;
}

public String getCodigoCliente(){
	return codigocliente;
}

public void setCodigoCliente(String codigocliente){
	this.codigocliente = codigocliente;
}

}
