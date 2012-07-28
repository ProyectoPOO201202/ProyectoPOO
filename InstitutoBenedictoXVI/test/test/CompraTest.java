package test;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import controlador.EmpresaControlador;

import dominio.Compra;
import dominio.Compra.Estado;
import dominio.Empresa;
import dominio.Moneda;

public class CompraTest {
	
	@Before
	public void dataInicial()
	{
		Empresa proveedor = EmpresaControlador.registrarEmpresa("20100070970", "Lau Chun", Empresa.Rubro.UTILES, "Calle Morelli # 181", "ventas@lauchun.com", "618000", "Lima", "Peru", Empresa.Estado.ACTIVA, "");		
	}
	
	@Test
	public void testMetodosGenerales() {	
	
		Moneda monedaSoles = new Moneda("S", "Soles");
		LocalDate fechaEmision = new DateTime(2012, 07, 21, 0, 0, 0, 0).toLocalDate();
		LocalDate fechaVencimiento = new DateTime(2012, 07, 21, 0, 0, 0, 0).toLocalDate();
		LocalDate fechaPago = new DateTime(2012, 07, 21, 0, 0, 0, 0).toLocalDate();
		Compra prueba = new Compra("Libreria", 1, fechaEmision, "20100070970", 80, 14.4, 94.4, monedaSoles.getDescripcion(), fechaVencimiento, fechaPago, Estado.NUEVO, "Orden Inicial");
		Assert.assertEquals(1, prueba.getNumero());
		Assert.assertEquals("20100070970", prueba.getEmpresa());
			
	}

}
