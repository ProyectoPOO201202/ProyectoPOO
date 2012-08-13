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
import dominio.AutenticaUsuario;
import dominio.Rol;
import dominio.DAO.DataBase;

public class testRolControlador {
	
	private AutenticaUsuario testAutenticaUsuario = new AutenticaUsuario();
	private DataBase bdMock;
	private RolControlador testRolControlador = new RolControlador();
	private List<Rol> listaRol = new ArrayList<Rol>();
	String testUsuarioActual = ""; 
	Date fechaAhora;
	
	@Before
    public void setUp() throws Exception 
    {		
		 
		testUsuarioActual = testAutenticaUsuario.usuarioAutenticado();
		testRolControlador = new RolControlador();
		bdMock  = mock(DataBase.class);
		testRolControlador.setDataBase(bdMock);
	    doReturn(listaRol).when(bdMock).tablaRol();
		for(int i=101; i<=115; i++)
		{
			fechaAhora = new Date();
			testRolControlador.registrarRol("R" + i, "Rol " + i, testUsuarioActual, fechaAhora.toString() );			
		}	
		
	}
	
	//@Test
	public void testBusquedaCodigoOk()
	{
		Rol test1;
		test1 = testRolControlador.busquedaRolCodigo("R113");
		Assert.assertEquals("R113", test1.getCodigo());
	}
	
	//@Test
	public void testBusquedaCodigoKO()
	{
		Rol test1;
		test1 = testRolControlador.busquedaRolCodigo("R101");
		Assert.assertEquals("R180", test1.getCodigo());
	}
	
	//@Test
	public void testBusquedaDescripcionOk()
	{
		List<Rol> test2;
		String codigo;
		test2 = testRolControlador.busquedaRolDescripcion("105");
		codigo = test2.get(0).getCodigo().toString();
		Assert.assertEquals("R105", codigo);
	}
	
	//@Test
	public void testBusquedaDescripcionKo()
	{
		List<Rol> test2;
		String codigo;
		test2 = testRolControlador.busquedaRolDescripcion("103");
		codigo = test2.get(0).getCodigo().toString();
		Assert.assertEquals("R108", codigo);
	}
	
	//@Test
	public void testAgregarRol()
	{
		fechaAhora = new Date();
		Rol testRol;
		testRol = testRolControlador.registrarRol("R201", "Rol 201", testUsuarioActual , fechaAhora.toString());
		Assert.assertEquals("R201", testRol.getCodigo());
		Assert.assertEquals("Rol 201", testRol.getDescripcion());
		Assert.assertEquals(testUsuarioActual, testRol.getCreado_por());
		Assert.assertEquals(fechaAhora.toString(), testRol.getCreado_el());
	}
	
	@Test
	public void testModificarRol()
	{
		Rol testRol;
		testRol = testRolControlador.modificarRol("R104", "Cambio de Descripcion", true, true, false, false);				
		Assert.assertEquals("Cambio de Descripcion", testRol.getDescripcion());
		Assert.assertEquals(true, testRol.isAcceso());
		Assert.assertEquals(true, testRol.isAdicionar());
		Assert.assertEquals(false, testRol.isEditar());
		Assert.assertEquals(false, testRol.isEliminar());
	}
	
	
	//@Test
	public void testModificarRolAcceso()
	{
		Rol testRol;
		testRol = testRolControlador.modificaAccesoRol("R102", true, false, true, false);
		Assert.assertEquals("R102", testRol.getCodigo());
		Assert.assertEquals(true, testRol.isAcceso());
		Assert.assertEquals(false, testRol.isAdicionar());
		Assert.assertEquals(true, testRol.isEditar());
		Assert.assertEquals(false, testRol.isEliminar());
	}
	
	@Test
	public void testEliminarRol()
	{
		boolean resultado;
		resultado = testRolControlador.eliminarRol("R106");
		Assert.assertEquals("El rol fue eliminado", true, resultado);
	}
	

}
