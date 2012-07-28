package test;
import org.junit.Assert;
import org.junit.Test;

import dominio.Clientealta;


public class ClienteTest2 {
	
	@Test
	public void AltaDeClientes(){
		
		//String nombre = "joel";
		String nombre = null;
		//String ape_paterno= "Pacheco";
		String ape_paterno=null;
		String ape_materno= null;
		//String email = "joel@gmail.com";
		String email = null;
		String dni = null;
		String telefono = null;
		String celular = null;
		
		Clientealta alta = new Clientealta();
		
		
		boolean datoscorrectos = alta.ValidaDatos(nombre,ape_paterno,ape_materno,email,dni,telefono,celular); 
		
		System.out.print("No a ingresado datos relevantes");
		
		//Assert.assertFalse("No a ingresado datos relevantes",datoscorrectos);
		
	}

}
