package dominio;

public class Clientealta {

	public void ValidaDatos(String nombre, String ape_paterno,
			String ape_materno, String email, String dni, String telefono,
			String celular)  throws ParametroIncompleto{
	
		noNull(nombre, "No ingres— nombre");
		noNull(ape_paterno, "No ingres— apellido paterno");
		noNull(ape_materno, "No ingres— apellido materno");
		noNull(dni, "No ingres— dni");
	
		if(telefono==null && celular==null){
			noNull(telefono, "No ingres— nœmero telef—nico");	
		}
		
		noNull(email, "No ingres— email");
		System.out.print("Registro guardado correctamente");
		
	/*if (nombre==null || nombre =="") {
			
			 throw new ParametroIncompleto("No ingres— nombre");
			
		}
		if (ape_paterno==null ) {
			
			 throw new ParametroIncompleto("No ingres— apellido paterno");
		}
		
		if(ape_materno==null){
			throw new ParametroIncompleto("No ingres— apellido materno");
		}
		
		if(dni==null){
			throw new ParametroIncompleto("No ingres— dni");
		}
		
		if(telefono==null || celular==null){
			throw new ParametroIncompleto("No ingres— nœmero telef—nico");
		}
		
		
		if(email == null){
			
			 throw new ParametroIncompleto("No ingres— email");
		}*/

	}
	
	private void noNull (String dato,String mensaje)throws ParametroIncompleto{
		
		if(dato == null || dato==""){
			
			 throw new ParametroIncompleto(mensaje);		 
		}
			
		
		
	}

}
