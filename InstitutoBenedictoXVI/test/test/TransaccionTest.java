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
import dominio.Transaccion.Tipo;

public class TransaccionTest {


	@Before
	public void dataInicial()	{	
		EmpresaControlador proveedor = new EmpresaControlador();	
		proveedor.registrarEmpresa("20100070970", "Lau Chun", "Libreria", "Calle Morelli # 181", "ventas@lauchun.com", "618000", "Lima", "Peru", "Activa", "");		
		EmpresaControlador cliente = new EmpresaControlador();
		cliente.registrarEmpresa("20100070970", "SPSA", "Retail", "Calle Tulipanes 468", "logistica@spsa.com.pe", "4356789", "Lima", "Peru", "Activa", "");		
	}
	
	@Test // Venta
	public void testMetodoGeneral() throws ParametroIncompleto {	
	
		Moneda monedaSoles = new Moneda("S", "Soles");
		DateTime fechaEmision = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		DateTime fechaVencimiento = new DateTime(2012, 8, 21, 0, 0, 0, 0);
		DateTime fechaPago = new DateTime(2012, 07, 30, 0, 0, 0); 
		Transaccion prueba = new Transaccion("Grupo de Estudio Alpha", 1, fechaEmision.toString(), "89674532121", 180, 28.8, 188.8, monedaSoles.getDescripcion(), fechaVencimiento.toString(), fechaPago.toString(), "Pedido Inicial", Tipo.VENTA, Estado.NUEVO);		
		Assert.assertEquals(1, prueba.getNumero());
		Assert.assertEquals("20176409076", prueba.getEmpresa());			
	}	
	
	@Test // Compra
	public void testMetodosGenerales() throws ParametroIncompleto {	
	
		Moneda monedaSoles = new Moneda("S", "Soles");
		DateTime fechaEmision = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		DateTime fechaVencimiento = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		DateTime fechaPago = new DateTime(2012, 07, 21, 0, 0, 0, 0);
		
		Transaccion prueba = new Transaccion("Libreria", 1, fechaEmision.toString(), "20100070970", 80, 14.4, 94.4, monedaSoles.getDescripcion(), fechaVencimiento.toString(), fechaPago.toString(), "Orden Inicial",Tipo.COMPRA,Estado.NUEVO);
		Assert.assertEquals("Libreria", prueba.getConcepto());
		Assert.assertEquals(1, prueba.getNumero());
		Assert.assertEquals(fechaEmision, prueba.getFechaEmision());
		Assert.assertEquals("20100070970", prueba.getEmpresa());
		Assert.assertEquals(80, prueba.getSubtotal());
			
	}
	
	
}
