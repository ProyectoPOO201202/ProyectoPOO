package test;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import controlador.EmpresaControlador;
import dominio.Moneda;
import dominio.ParametroIncompleto;
import dominio.Transaccion;
import dominio.Transaccion.Estado;
import dominio.Transaccion.TFiltro;
import dominio.Transaccion.Tipo;

public class TransaccionTest {


	@Before
	public void dataInicial()	{	
		EmpresaControlador proveedor = new EmpresaControlador();	
		proveedor.registrarEmpresa("20100070970", "Lau Chun", "Libreria", "Calle Morelli # 181", "ventas@lauchun.com", "618000", "Lima", "Peru", "Activa", "");		
		EmpresaControlador cliente = new EmpresaControlador();
		cliente.registrarEmpresa("20100070970", "SPSA", "Retail", "Calle Tulipanes 468", "logistica@spsa.com.pe", "4356789", "Lima", "Peru", "Activa", "");		
	}
	
	//@Test // Venta
	public void testMetodoGeneral() throws ParametroIncompleto {	
	
		Moneda monedaSoles = new Moneda("S", "Soles");
		DateTime fechaEmision = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		DateTime fechaVencimiento = new DateTime(2012, 8, 21, 0, 0, 0, 0);
		DateTime fechaPago = new DateTime(2012, 07, 30, 0, 0, 0); 
		Transaccion prueba = new Transaccion("Grupo de Estudio Alpha", 1, fechaEmision, "89674532121", 180, 28.8, 188.8, monedaSoles.getDescripcion(), fechaVencimiento, fechaPago, "Pedido Inicial", Tipo.VENTA, Estado.NUEVO);		
		Assert.assertEquals(1, prueba.getNumero());
		Assert.assertEquals("20176409076", prueba.getEmpresa());			
	}
	
	//@Test // Venta
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
	
	@Test // Venta
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
		Assert.assertTrue(bool_resultado);	
		Assert.assertEquals(2, contador);
	}
	
	@Test // Compra
	public void testMetodosGenerales() throws ParametroIncompleto {	
	
		Moneda monedaSoles = new Moneda("S", "Soles");
		DateTime fechaEmision = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		DateTime fechaVencimiento = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		DateTime fechaPago = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		
		Transaccion prueba = new Transaccion("Libreria", 1, fechaEmision, "20100070970", 80, 14.4, 94.4, monedaSoles.getDescripcion(), fechaVencimiento, fechaPago, "Orden Inicial",Tipo.COMPRA,Estado.NUEVO);
		Assert.assertEquals("Libreria", prueba.getConcepto());
		Assert.assertEquals(1, prueba.getNumero());
		Assert.assertEquals(fechaEmision, prueba.getFechaEmision());
		Assert.assertEquals("20100070970", prueba.getEmpresa());
		Assert.assertEquals(80, prueba.getSubtotal());
			
	}
	
	
}
