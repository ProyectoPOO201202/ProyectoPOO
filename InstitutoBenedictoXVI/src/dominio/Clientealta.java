package dominio;

public class Clientealta {

	public boolean ValidaDatos(String nombre, String ape_paterno,
			String ape_materno, String email, String dni, String telefono,
			String celular)  throws ParametroIncompleto{
		
		boolean validado = true;
		
		if (nombre==null) {
			 validado = false;
			 throw new ParametroIncompleto("No ingreso nombre");
			
		}
		if (ape_paterno==null ) {
			 validado = false;
			 throw new ParametroIncompleto("No ingreso apellido paterno");
		}
		
		if(email == null){
			 validado = false;
			 throw new ParametroIncompleto("No ingreso email");
		}

		return validado;
	}

}
