package test;

import junit.framework.Assert;

import org.junit.Test;

import dominio.Rol;

public class RolTest {
	
	@Before
	public 

	@Test
	public void CrearRoltest() {		
		Rol prueba = new Rol("R001", "Rol de Login", "", "", "", "");		
		Assert.assertEquals("R001", prueba.getCodigo());
		Assert.assertEquals("Rol de Login", prueba.getDescripcion());		
	}
	
	@Test
	public void CrearRoltest() {		
		Rol prueba = new Rol("R001", "Rol de Login", "", "", "", "");		
		Assert.assertEquals("R001", prueba.getCodigo());
		Assert.assertEquals("Rol de Login", prueba.getDescripcion());		
	}

}
