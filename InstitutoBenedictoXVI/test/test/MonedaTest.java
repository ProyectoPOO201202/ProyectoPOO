package test;

import junit.framework.Assert;

import org.junit.Test;

import dominio.Moneda;


public class MonedaTest {

	@Test
	public void testPropiedades() {
	
	    Moneda moneda = new Moneda();
	    moneda.setSimbolo("S/.");
	    moneda.setDescripcion("Nuevos soles");
	    
	    Assert.assertEquals("S/.", moneda.getSimbolo());
	    Assert.assertEquals("Nuevos soles", moneda.getDescripcion());
	}

}
