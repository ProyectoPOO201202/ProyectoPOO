package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Rol;

public class RolTest {

	@Test
	public void CrearRoltest() {
		//fail("Not yet implemented");
		String codrol = "0001";
		String nombrerol = "Administrador";
		
		Rol rol = new Rol(codrol, nombrerol);
		
		assertNotNull (rol);
		assertNotNull (codrol, rol.getcodrol());
		assertNotNull (nombrerol, rol.getcodrol());
		
		
	}

}
