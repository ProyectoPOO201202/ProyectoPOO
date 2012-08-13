package testControlador;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.csvreader.CsvReader;



import controlador.ClienteControlador;
import controlador.EmpresaControlador;
import controlador.PersonaControlador;


import dominio.Cliente;
import dominio.Empresa;
import dominio.Persona;
import dominio.Prospecto;
import dominio.DAO.BaseDatosMock;


public class ClienteControladorTest {
	
	private BaseDatosMock bdMock;
	private List<Persona> listaPersona= new ArrayList<Persona>();
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
		
	private ClienteControlador clientecontrolador;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		// Borrando los archivos si existieran
		File ficheroCliente = new File("test/csv/Cliente_export.csv");
		ficheroCliente.delete();
	    }
	

	@Before
    public void setUp() throws Exception {
		//Inicialización de variables antes de cada Test		
		clientecontrolador = new ClienteControlador();
		
		
		 bdMock  = mock(BaseDatosMock.class);
		 clientecontrolador.setBaseDatosMock(bdMock);
		
		 
		 doReturn(listaPersona).when(bdMock).devolverPersona();
		 doReturn(listaCliente).when(bdMock).devolverCliente();		
		 
		 
			// REGISTRA 15 CLIENTES
			for(int i=10001; i<=10015; i++){
				clientecontrolador.registrarCliente("cod"+i,"dni" +i, "nombres" + i, "apellido_paterno" + i, "apellido_materno" + i, "485" + i, "100212" + i, "correo@upc.com" + i, "direccion" +i, "distrito" + i, "departamento" + i) ;  
				
			}
		 
	}	    
		    

	@Test
	public void testListarClienteRegistradas(){
		
		List<Cliente> cliente = new ArrayList<Cliente>();
		cliente = clientecontrolador.devolverListaCliente();
		for(Cliente clientes : cliente){
			System.out.println(clientes.getCodigoCliente() + " " + clientes.getApellido_Paterno());
		}
		System.out.println("Total de Prospecto registradas : " + clientecontrolador.devolverCantidadCliente());
		assertEquals(15, clientecontrolador.devolverCantidadCliente());
	}
	
	
	@Test
	public void testMostrarDatosProspecto(){
				Cliente cliente = clientecontrolador.obtenerClientePorCodigo("dni10002");
		assertEquals("dni10002", cliente.getDni());
		assertEquals("nombres10002",cliente.getNombres());
			
	}	
	
	@Test
	public void testModificarDatosCliente(){
		
		clientecontrolador.modificarCliente("cod10001","dni10001", "TITO10001", "apellido_paterno10001",
		"apellido_materno10001", "4984859", "100212", "correo@upc.com", "direccion10001",
		"distrito10001", "departamento10001");
		
		Cliente cliente = clientecontrolador.obtenerClientePorCodigo("dni10001");
		// ASSERTS
		assertEquals("cod10001",cliente.getCodigoCliente());
		assertEquals("dni10001", cliente.getDni());
		assertEquals("TITO10001", cliente.getNombres());
		assertEquals("apellido_paterno10001", cliente.getApellido_Paterno());
		assertEquals("apellido_materno10001", cliente.getApellido_Materno());
		assertEquals("4984859", cliente.getTelefono());
		assertEquals("100212", cliente.getFechaPase());
		assertEquals("correo@upc.com", cliente.getCorreo());
		assertEquals("direccion10001", cliente.getDireccion());
		assertEquals("distrito10001", cliente.getDistrito());
		assertEquals("departamento10001", cliente.getDepartamento());
	
	}
	
	@Test
	public void testBuscarProspecto(){
		
		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
		cliente = clientecontrolador.devolverListaBusquedaClientePorApellidos("apellido_paterno10001");
				
		for(Cliente clientes: cliente){
			System.out.println(clientes.getApellido_Paterno()+ " " + clientes.getDni());
		}
		System.out.println("Resultado busqueda de clientes : " + cliente.size() + " coincidencias");		
		assertEquals("apellido_paterno10001", cliente.get(0).getApellido_Paterno());
		//assertEquals("apellido_paterno10002", prospectos.get(1).getApellido_Paterno());
		/*assertEquals("E10003", empresas.get(2).getCodigo());
		assertEquals("E10004", empresas.get(3).getCodigo());
		assertEquals("E10005", empresas.get(4).getCodigo());
		assertEquals("E10006", empresas.get(5).getCodigo());
		assertEquals("E10007", empresas.get(6).getCodigo());
		assertEquals("E10008", empresas.get(7).getCodigo());
		assertEquals("E10009", empresas.get(8).getCodigo());	*/
	}


	@Test
	public void testEliminarCliente(){
				
		clientecontrolador.eliminarCliente("dni10001");		
		//clienteControlador.eliminarEmpresa("E10005");
		//clienteControlador.eliminarEmpresa("E10015");
		assertNull(clientecontrolador.obtenerClientePorCodigo("cod10001"));
		//assertNull(clienteControlador.obtenerEmpresaPorCodigo("E10005"));		
		//assertNull(clienteControlador.obtenerEmpresaPorCodigo("E10015"));		
		assertEquals(14, clientecontrolador.devolverCantidadCliente());
	}



	@Test
	public void testExportarCliente(){
		
		clientecontrolador.exportarCliente("test/csv/Cliente_export.csv");
		
		try {

			List<Cliente> cliente1 = new ArrayList<Cliente>();
			cliente1 = clientecontrolador.devolverListaCliente();
			int contador = 0;
			
			CsvReader cliente2 = new CsvReader("test/csv/Cliente_export.csv");	
			cliente2.readHeaders();
			
			while (cliente2.readRecord()){	
				
				assertEquals(cliente1.get(contador).getCodigoCliente(), cliente2.get(0));
				assertEquals(cliente1.get(contador).getDni(), cliente2.get(1));
				assertEquals(cliente1.get(contador).getNombres(), cliente2.get(2));
				assertEquals(cliente1.get(contador).getApellido_Paterno(), cliente2.get(3));
				assertEquals(cliente1.get(contador).getApellido_Materno(), cliente2.get(4));
				assertEquals(cliente1.get(contador).getTelefono(), cliente2.get(5));
				assertEquals(cliente1.get(contador).getCorreo(), cliente2.get(6));
				assertEquals(cliente1.get(contador).getDireccion(), cliente2.get(7));
				assertEquals(cliente1.get(contador).getDistrito(), cliente2.get(8));
				assertEquals(cliente1.get(contador).getDepartamento(), cliente2.get(9));
				
				contador++;
			}
	
				cliente2.close();	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

	@Test
	public void testImportarCliente(){
		
		clientecontrolador.limpiaListaCliente();
		clientecontrolador.importarCliente("test/csv/Cliente_import.csv");
		
		try {
					
			List<Cliente> cliente1 = new ArrayList<Cliente>();
			cliente1 = clientecontrolador.devolverListaCliente();
			
			int contador = 0;
			
			CsvReader cliente2 = new CsvReader("test/csv/Cliente_import.csv");	
			cliente2.readHeaders();
			
			while (cliente2.readRecord()){	
				
				assertEquals(cliente1.get(contador).getCodigoCliente(), cliente2.get(0));
				assertEquals(cliente1.get(contador).getDni(), cliente2.get(1));
				assertEquals(cliente1.get(contador).getNombres(), cliente2.get(2));
				assertEquals(cliente1.get(contador).getApellido_Paterno(), cliente2.get(3));
				assertEquals(cliente1.get(contador).getApellido_Materno(), cliente2.get(4));
				assertEquals(cliente1.get(contador).getTelefono(), cliente2.get(5));
				assertEquals(cliente1.get(contador).getCorreo(), cliente2.get(6));
				assertEquals(cliente1.get(contador).getDireccion(), cliente2.get(7));
				assertEquals(cliente1.get(contador).getDistrito(), cliente2.get(8));
				assertEquals(cliente1.get(contador).getDepartamento(), cliente2.get(9));

				contador++;
			}
	
			cliente2.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
