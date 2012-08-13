package test;

import static org.junit.Assert.*;

import org.junit.Test;


import dominio.Trabajador;
import dominio.Usuario;

public class TabajadorTest {

	@Test
	public void testTrabajador() {
		Trabajador trabajador1 = new Trabajador("56745321", "carlos@hotmail.com","Carlos","Morales","Ortiz", "av. brasil 1530", "6758899");

		//Asserts
		assertEquals("56745321",trabajador1.getDni());
		assertEquals("carlos@hotmail.com",trabajador1.getCorreo());
		assertEquals("Carlos",trabajador1.getNombres());
		assertEquals("Morales",trabajador1.getApellido_Paterno());
		assertEquals("Ortiz",trabajador1.getApellido_Materno());
		assertEquals("av. brasil 1530",trabajador1.getDireccion());
		assertEquals("6758899",trabajador1.getTelefono());
		

		}
	
	

}
