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
import dominio.Transaccion.Tipo;

public class VentaTest {


	@Before
	public void dataInicial()	{
		
		Empresa cliente = EmpresaControlador.registrarEmpresa("20100070970", "SPSA", Empresa.Rubro.CLIENTE, "Calle Tulipanes 468", "logistica@spsa.com.pe", "4356789", "Lima", "Peru", Empresa.Estado.ACTIVA, "");		
	}
	
	@Test
	public void testMetodosGenerales() throws ParametroIncompleto {	
	
		Moneda monedaSoles = new Moneda("S", "Soles");
		LocalDate fechaEmision = new DateTime(2012, 07, 21, 0, 0, 0, 0).toLocalDate();
		LocalDate fechaVencimiento = new DateTime(2012, 8, 21, 0, 0, 0, 0).toLocalDate();
		LocalDate fechaPago = new DateTime(2012, 07, 30, 0, 0, 0, 0).toLocalDate();
		Transaccion prueba = new Transaccion("Grupo de Estudio Alpha", 1, fechaEmision, "20176409076", 180, 28.8, 188.8, monedaSoles.getDescripcion(), fechaVencimiento, fechaPago, "Pedido Inicial", Tipo.VENTA);		
		Assert.assertEquals(1, prueba.getNumero());
		Assert.assertEquals("20176409076", prueba.getEmpresa());
			
	}
}
