package dominio;

public class Clientealta {

	public boolean ValidaDatos(String nombre, String ape_paterno,
			String ape_materno, String email, String dni, String telefono,
			String celular) {
		
		boolean validado = true;
		
		if (nombre==null) {
			 validado = false;
			
		}
		if (ape_paterno==null ) {
			 validado = false;
		}
		
		if(email == null){
			 validado = false;
		}

		return validado;
	}

}
