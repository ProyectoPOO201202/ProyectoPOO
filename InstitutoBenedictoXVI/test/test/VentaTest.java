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
import dominio.Transaccion.TFiltro;
import dominio.Transaccion.Tipo;

public class VentaTest {


	@Before
	public void dataInicial()	{		
		Empresa cliente = EmpresaControlador.registrarEmpresa("20100070970", "SPSA", Empresa.Rubro.CLIENTE, "Calle Tulipanes 468", "logistica@spsa.com.pe", "4356789", "Lima", "Peru", Empresa.Estado.ACTIVA, "");		
	}
	
	//@Test
	public void testMetodoGeneral() throws ParametroIncompleto {	
	
		Moneda monedaSoles = new Moneda("S", "Soles");
		DateTime fechaEmision = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		DateTime fechaVencimiento = new DateTime(2012, 8, 21, 0, 0, 0, 0);
		DateTime fechaPago = new DateTime(2012, 07, 30, 0, 0, 0); 
		Transaccion prueba = new Transaccion("Grupo de Estudio Alpha", 1, fechaEmision, "89674532121", 180, 28.8, 188.8, monedaSoles.getDescripcion(), fechaVencimiento, fechaPago, "Pedido Inicial", Tipo.VENTA, Estado.NUEVO);		
		Assert.assertEquals(1, prueba.getNumero());
		Assert.assertEquals("20176409076", prueba.getEmpresa());			
	}
	
	//@Test
	public void testMetodoFiltro() throws ParametroIncompleto {	
		boolean bool_resultado;
		Moneda monedaSoles = new Moneda("S", "Soles");
		DateTime fechaEmision = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		DateTime fechaVencimiento = new DateTime(2012, 8, 21, 0, 0, 0, 0);
		DateTime fechaPago = new DateTime(2012, 07, 30, 0, 0, 0, 0);
		Transaccion prueba = new Transaccion("Grupo de Estudio Alpha", 1, fechaEmision, "89674532121", 180, 28.8, 188.8, monedaSoles.getDescripcion(), fechaVencimiento, fechaPago, "Pedido Inicial", Tipo.VENTA, Estado.NUEVO);
		
		bool_resultado=prueba.addFiltro(TFiltro.CONCEPTO, "Prueba");
		Assert.assertTrue(bool_resultado);	
	}
	
	@Test
	public void testMetodoFiltroContador() throws ParametroIncompleto {		
		
		boolean bool_resultado;
		int contador;
		Moneda monedaSoles = new Moneda("S", "Soles");
		DateTime fechaEmision = new DateTime(1989, 04, 1, 0, 0, 0, 0);
		DateTime fechaVencimiento = new DateTime(2012, 8, 21, 0, 0, 0, 0);
		DateTime fechaPago = new DateTime(2012, 07, 30, 0, 0, 0, 0);
		Transaccion prueba = new Transaccion("Grupo de Estudio Alpha", 1, fechaEmision, "89674532121", 180, 28.8, 188.8, monedaSoles.getDescripcion(), fechaVencimiento, fechaPago, "Pedido Inicial", Tipo.VENTA, Estado.NUEVO);
		
		bool_resultado=prueba.addFiltro(TFiltro.CONCEPTO, "Prueba");
		contador=prueba.listaFiltro();
		//Assert.assertTrue(bool_resultado);	
		Assert.assertEquals(2, contador);
	}
}
