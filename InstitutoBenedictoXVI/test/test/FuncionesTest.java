package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import controlador.Funcion;

public class FuncionesTest {

	@Test
	public void ValidarCorreotest() {
		Funcion funcion = new Funcion();
		
		Assert.assertFalse(funcion.valCorreo("xxx"));
		Assert.assertFalse(funcion.valCorreo("xxx@"));
		Assert.assertFalse(funcion.valCorreo("@xxx.com"));
		Assert.assertFalse(funcion.valCorreo("!!!@!!!!.!!!"));
		
		Assert.assertTrue(funcion.valCorreo("xxx@xxx.com"));
		Assert.assertTrue(funcion.valCorreo("xxx@xxx.com.pe"));
		
		//fail("Not yet implemented");
	}

}
