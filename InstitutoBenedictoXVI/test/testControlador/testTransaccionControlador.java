package testControlador;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import controlador.RolControlador;
import controlador.TransaccionControlador;
import controlador.TransaccionControlador.TFiltro;
import dominio.AutenticaUsuario;
import dominio.Empresa;
import dominio.Rol;
import dominio.Transaccion;
import dominio.DAO.DataBase;

public class testTransaccionControlador {
	
	private AutenticaUsuario testAutenticaUsuario = new AutenticaUsuario();
	private Empresa proveedor;
	private DataBase bdMock;
	private TransaccionControlador testTransaccionControlador = new TransaccionControlador();
	private List<Transaccion> listaTransaccion = new ArrayList<Transaccion>();
	String testUsuarioActual = ""; 
	Date fechaAhora;
	
	@Before
    public void setUp() throws Exception 
    {		
		 
		testUsuarioActual = testAutenticaUsuario.usuarioAutenticado();
		testTransaccionControlador = new TransaccionControlador();
		proveedor = new  Empresa("20549810009","RZ20549810009","PESQUERA","Direccion Empresa 10007","contacto@RZ20549810009.com.pe","6188007","Lima","Peru","Activo","");
		bdMock  = mock(DataBase.class);
		testTransaccionControlador.setDataBase(bdMock);
	    doReturn(listaTransaccion).when(bdMock).tablaTransaccion();
		for(int i=101; i<=115; i++)
		{			
			fechaAhora = new Date();			
			testTransaccionControlador.registrarTransaccion("CONCEPTO " + i, String.valueOf(i)  , fechaAhora.toString(), proveedor.getCodigo(), "100", "18", "118", "S/.", fechaAhora.toString(), fechaAhora.toString(), "ninguna", "VENTA", "NUEVO");					
		}	
		
	}
	
	
	@Test
	public void testBusquedaTransaccion()
	{
		int countRegistro = 0;
		TFiltro testFiltro = null;
		List<Transaccion> testTransaccion;
		countRegistro = testTransaccionControlador.cantidadTransaccion();
		testTransaccionControlador.addFiltro(testFiltro.CONCEPTO, "105");
		testTransaccion = testTransaccionControlador.devolverListaTransaccionFiltro();
		countRegistro = testTransaccion.size();
		Assert.assertEquals(1, countRegistro);
	}
	
	

}
