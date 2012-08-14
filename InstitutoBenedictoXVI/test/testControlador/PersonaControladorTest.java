package testControlador;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.csvreader.CsvReader;
import controlador.PersonaControlador;


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
		 
		 
			// REGISTRA 15 PROSPECTOS
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
	
	/*
	@Test
	public void testMostrarDatosProspecto(){
				Prospecto prospecto = personaControlador.obtenerProspectoPorDni("dni10005");
		assertEquals("dni10005", prospecto.getDni());
		assertEquals("nombres10005",prospecto.getNombres());
		System.out.println(prospecto.getDni());
		System.out.println(prospecto.getApellido_Paterno());
	}	
	
	@Test
	public void testModificarDatosProspecto(){
		
		personaControlador.modificarProspecto("dni10001", "TITO10001", "apellido_paterno10001",
		"apellido_materno10001", "4984859", "100212", "correo@upc.com", "direccion10001",
		"distrito10001", "departamento10001");
		
		Prospecto prospecto= personaControlador.obtenerProspectoPorDni("dni10001");
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
		
	
	}

	@Test
	public void testEliminarProspecto(){
				
		personaControlador.eliminarProspecto("dni10001");		
		
		assertNull(personaControlador.obtenerProspectoPorDni("dni10001"));
	
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
				
				
				contador++;
			}
	
			prospectos2.close();	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
*/
	
}
