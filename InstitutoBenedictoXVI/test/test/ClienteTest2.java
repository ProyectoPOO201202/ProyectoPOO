package test;
import org.junit.Assert;
import org.junit.Test;

import dominio.Cliente;
import dominio.Clientealta;
import dominio.ParametroIncompleto;


public class ClienteTest2 {
	
	@Test
	public void AltaDeClientes(){

		
		String nombre = "Joel";
		String ape_paterno= "Pacheco";
		String ape_materno= "Carbajal";
		String email = "joel@gmail.com";
		String dni = "89809898";
		String telefono = "4980989";
		String celular = "998987787";
		
		Cliente cliente = new Cliente();
		Clientealta alta = new Clientealta();
		try {
				alta.ValidaDatos(nombre,ape_paterno,ape_materno,email,dni,telefono,celular);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
			
	}

}
