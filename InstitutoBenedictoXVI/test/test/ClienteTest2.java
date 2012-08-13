package test;
import org.junit.Assert;
import org.junit.Test;

import dominio.Clientealta;
import dominio.ParametroIncompleto;


public class ClienteTest2 {
	
	@Test
	public void AltaDeClientes(){
		
		/*Los campos nombre,apellido paterno,email son obligatorios*/
		
		//String nombre = "joel";
		String nombre = null;
		//String ape_paterno= "Pacheco";
		String ape_paterno=null;
		String ape_materno= null;
		//String email = "joel@gmail.com";
		String email =null;
		String dni = null;
		String telefono = null;
		String celular = null;
		
		Clientealta alta = new Clientealta();

		boolean datoscorrectos;
		try {
			datoscorrectos = alta.ValidaDatos(nombre,ape_paterno,ape_materno,email,dni,telefono,celular);
			Assert.assertFalse("No a ingresado datos relevantes",datoscorrectos);
			
		} catch (ParametroIncompleto e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	} 
		
	}

}
