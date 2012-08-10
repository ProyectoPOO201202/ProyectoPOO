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



import controlador.EmpresaControlador;
import controlador.PersonaControlador;


import dominio.Empresa;
import dominio.Persona;
import dominio.Prospecto;
import dominio.DAO.BaseDatosMock;


public class PersonaControladorTest {
	
	private BaseDatosMock bdMock;
	private List<Persona> listaPersona= new ArrayList<Persona>();
	private List<Prospecto> listaProspecto = new ArrayList<Prospecto>();
	
		
	private PersonaControlador personaControlador;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		// Borrando los archivos si existieran
		File ficheroProspecto = new File("test/csv/Prospecto_export.csv");
		ficheroProspecto.delete();
	    }
	

	@Before
    public void setUp() throws Exception {
		//Inicialización de variables antes de cada Test		
		personaControlador = new PersonaControlador();
		
		
		 bdMock  = mock(BaseDatosMock.class);
		 personaControlador.setBaseDatosMock(bdMock);
		
		 
		 doReturn(listaPersona).when(bdMock).devolverPersona();
		 doReturn(listaProspecto).when(bdMock).devolverProspecto();		
		 
		 
			// REGISTRA 15 PROSPECTO
			for(int i=10001; i<=10015; i++){
				personaControlador.registrarProspecto("dni" +i, "nombres" + i, "apellido_paterno" + i, "apellido_materno" + i, "485" + i, "100212" + i, "correo@upc.com" + i, "direccion" +i, "distrito" + i, "departamento" + i) ;  
				
			}
		 
	}	    
		    

	@Test
	public void testListarProspectoRegistradas(){
		
		List<Prospecto> prospecto = new ArrayList<Prospecto>();
		prospecto = personaControlador.devolverListaProspecto();
		for(Prospecto prospectos : prospecto){
			System.out.println(prospectos.getDni() + " " + prospectos.getApellido_Paterno());
		}
		System.out.println("Total de Prospecto registradas : " + personaControlador.devolverCantidadProspecto());
		assertEquals(15, personaControlador.devolverCantidadProspecto());
	}
	
	
	@Test
	public void testMostrarDatosProspecto(){
				Prospecto prospecto = personaControlador.obtenerProspectoPorDni("dni10002");
		assertEquals("dni10002", prospecto.getDni());
		assertEquals("nombres10002",prospecto.getNombres());
			
	}	
	
	@Test
	public void testModificarDatosProspecto(){
		
		personaControlador.modificarProspecto("dni10001", "TITO10001", "apellido_paterno10001",
		"apellido_materno10001", "4984859", "100212", "correo@upc.com", "direccion10001",
		"distrito10001", "departamento10001");
		
		Prospecto prospecto= personaControlador.obtenerProspectoPorDni("dni10001");
		// ASSERTS
		assertEquals("dni10001", prospecto.getDni());
		assertEquals("TITO10001", prospecto.getNombres());
		assertEquals("apellido_paterno10001", prospecto.getApellido_Paterno());
		assertEquals("apellido_materno10001", prospecto.getApellido_Materno());
		assertEquals("4984859", prospecto.getTelefono());
		assertEquals("100212", prospecto.getFechaContacto());
		assertEquals("correo@upc.com", prospecto.getCorreo());
		assertEquals("direccion10001", prospecto.getDireccion());
		assertEquals("distrito10001", prospecto.getDistrito());
		assertEquals("departamento10001", prospecto.getDepartamento());
	
	}
	
	@Test
	public void testBuscarProspecto(){
		
		ArrayList<Prospecto> prospectos = new ArrayList<Prospecto>();
		prospectos = personaControlador.devolverListaBusquedaProspectoPorApellidos("apellido_paterno10001");
				
		for(Prospecto prospecto: prospectos){
			System.out.println(prospecto.getApellido_Paterno()+ " " + prospecto.getDni());
		}
		System.out.println("Resultado busqueda de prospectos : " + prospectos.size() + " coincidencias");		
		assertEquals("apellido_paterno10001", prospectos.get(0).getApellido_Paterno());
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
	public void testEliminarProspecto(){
				
		personaControlador.eliminarProspecto("dni10001");		
		//clienteControlador.eliminarEmpresa("E10005");
		//clienteControlador.eliminarEmpresa("E10015");
		assertNull(personaControlador.obtenerProspectoPorDni("dni10001"));
		//assertNull(clienteControlador.obtenerEmpresaPorCodigo("E10005"));		
		//assertNull(clienteControlador.obtenerEmpresaPorCodigo("E10015"));		
		assertEquals(14, personaControlador.devolverCantidadProspecto());
	}



	@Test
	public void testExportarProspecto(){
		
		personaControlador.exportarProspecto("test/csv/Prospecto_export.csv");
		
		try {

			List<Prospecto> prospectos1 = new ArrayList<Prospecto>();
			prospectos1 = personaControlador.devolverListaProspecto();
			int contador = 0;
			
			CsvReader prospectos2 = new CsvReader("test/csv/Prospecto_export.csv");	
			prospectos2.readHeaders();
			
			while (prospectos2.readRecord()){	
				
				assertEquals(prospectos1.get(contador).getDni(), prospectos2.get(0));
				assertEquals(prospectos1.get(contador).getNombres(), prospectos2.get(1));
				assertEquals(prospectos1.get(contador).getApellido_Paterno(), prospectos2.get(2));
				assertEquals(prospectos1.get(contador).getApellido_Materno(), prospectos2.get(3));
				assertEquals(prospectos1.get(contador).getTelefono(), prospectos2.get(4));
				assertEquals(prospectos1.get(contador).getCorreo(), prospectos2.get(5));
				assertEquals(prospectos1.get(contador).getDireccion(), prospectos2.get(6));
				assertEquals(prospectos1.get(contador).getDistrito(), prospectos2.get(7));
				assertEquals(prospectos1.get(contador).getDepartamento(), prospectos2.get(8));
				
				contador++;
			}
	
			prospectos2.close();	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

	@Test
	public void testImportarProspecto(){
		
		personaControlador.limpiaListaProspecto();
		personaControlador.importarProspecto("test/csv/Prospecto_import.csv");
		
		try {
					
			List<Prospecto> prospecto1 = new ArrayList<Prospecto>();
			prospecto1 = personaControlador.devolverListaProspecto();
			
			int contador = 0;
			
			CsvReader prospecto2 = new CsvReader("test/csv/Prospecto_import.csv");	
			prospecto2.readHeaders();
			
			while (prospecto2.readRecord()){	
				
				assertEquals(prospecto1.get(contador).getDni(), prospecto2.get(0));
				assertEquals(prospecto1.get(contador).getNombres(), prospecto2.get(1));
				assertEquals(prospecto1.get(contador).getApellido_Paterno(), prospecto2.get(2));
				assertEquals(prospecto1.get(contador).getApellido_Materno(), prospecto2.get(3));
				assertEquals(prospecto1.get(contador).getTelefono(), prospecto2.get(4));
				assertEquals(prospecto1.get(contador).getCorreo(), prospecto2.get(5));
				assertEquals(prospecto1.get(contador).getDireccion(), prospecto2.get(6));
				assertEquals(prospecto1.get(contador).getDistrito(), prospecto2.get(7));
				assertEquals(prospecto1.get(contador).getDepartamento(), prospecto2.get(8));
				
				
			
				contador++;
			}
	
			prospecto2.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
