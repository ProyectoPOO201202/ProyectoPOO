package test;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import controlador.EmpresaControlador;

import dominio.Empresa;
import dominio.Moneda;
import dominio.ParametroIncompleto;
import dominio.Transaccion;
import dominio.Transaccion.Estado;
import dominio.Transaccion.Tipo;


public class CompraTest {
	
	@Before
	public void dataInicial()
	{
		Empresa proveedor = EmpresaControlador.registrarEmpresa("20100070970", "Lau Chun", Empresa.Rubro.UTILES, "Calle Morelli # 181", "ventas@lauchun.com", "618000", "Lima", "Peru", Empresa.Estado.ACTIVA, "");		
	}
	
	@Test
	public void testMetodosGenerales() throws ParametroIncompleto {	
	
		Moneda monedaSoles = new Moneda("S", "Soles");
		LocalDate fechaEmision = new DateTime(2012, 07, 21, 0, 0, 0, 0).toLocalDate();
		LocalDate fechaVencimiento = new DateTime(2012, 07, 21, 0, 0, 0, 0).toLocalDate();
		LocalDate fechaPago = new DateTime(2012, 07, 21, 0, 0, 0, 0).toLocalDate();
		Transaccion prueba = new Transaccion("Libreria", 1, fechaEmision, "20100070970", 80, 14.4, 94.4, monedaSoles.getDescripcion(), fechaVencimiento, fechaPago, "Orden Inicial",Tipo.COMPRA,Estado.NUEVO);
		Assert.assertEquals("Libreria", prueba.getConcepto());
		Assert.assertEquals(1, prueba.getNumero());
		Assert.assertEquals(fechaEmision, prueba.getFechaEmision());
		Assert.assertEquals("20100070970", prueba.getEmpresa());
		Assert.assertEquals(80, prueba.getSubtotal());
			
	}

}
