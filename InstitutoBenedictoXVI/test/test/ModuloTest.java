package test;

import junit.framework.Assert;
import org.junit.Test;

import dominio.Modulo;

public class ModuloTest {
	
	@Test
	public void testModuloCrea()
	{
		Modulo test = new Modulo("M001","Modulo de Acceso");
		Assert.assertEquals("M001", test.getCodigo());
		Assert.assertEquals("Modulo de Acceso", test.getDescripcion());		
	}
	
	@Test
	public void testModuloModifica()
	{
		Modulo test = new Modulo("M001","Modulo de Acceso");
		Assert.assertEquals("M001", test.getCodigo());
		Assert.assertEquals("Modulo de Acceso", test.getDescripcion());
		test.setDescripcion("Modulo Accesos");
		Assert.assertEquals("Modulo Accesos", test.getDescripcion());
	}

}
