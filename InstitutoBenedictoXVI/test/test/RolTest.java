package test;

import junit.framework.Assert;
import org.junit.Test;

import dominio.Rol;

public class RolTest {
	
	Rol prueba = new Rol();	
	
	//@Test
	public void crearRolTest() {		
			
		prueba.crearRol("R001", "Rol de Login", "GMORIN", "2012/06/05");
		Assert.assertEquals("R001", prueba.getCodigo());
		Assert.assertEquals("Rol de Login", prueba.getDescripcion());		
	}
	
	@Test
	public void modificaRolTest() {	
		prueba.crearRol("R001", "Rol de Login", "GMORIN", "2012/06/05");
		Assert.assertEquals("R001", prueba.getCodigo());
		Assert.assertEquals("Rol de Login", prueba.getDescripcion());		
		prueba.modificarRol("R001", "Rol de Acceso","GMORIN", "2012/06/06");		
		Assert.assertEquals("R001", prueba.getCodigo());
		Assert.assertEquals("Rol de Acceso", prueba.getDescripcion());		
	}

}
