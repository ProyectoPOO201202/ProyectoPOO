package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

//import java.net.BindException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.csvreader.CsvReader;

import controlador.UsuarioControlador;
import dominio.Trabajador;
import dominio.Usuario;
import dominio.DAO.BaseDatosMock;


public class UsuarioControladorTest {
	
		private BaseDatosMock bdMock;
		
		private List<Trabajador> listaTrabajador = new ArrayList<Trabajador>();
		private List<Usuario> listaUsuario= new ArrayList<Usuario>();
	
			
		private UsuarioControlador usuarioControlador;
		
		@BeforeClass
		public static void setUpClass() throws Exception {
			File ficheroUsuario = new File("test/csv/Usuario_export.csv");
			ficheroUsuario.delete();
		    }
		

		@Before
	    public void setUp() throws Exception {
			//Inicialización de variables antes de cada Test		
			usuarioControlador = new UsuarioControlador();
			
			
			 bdMock  = mock(BaseDatosMock.class);
			 usuarioControlador.setBaseDatosMock(bdMock);
			
			 doReturn(listaTrabajador).when(bdMock).devolverTrabajador();
			 doReturn(listaUsuario).when(bdMock).devolverUsuario();
			 
				
				for(int i=1001; i<=1015; i++){
					usuarioControlador.registrarUsuario("dni" + i, "correo" + i, "nombre" + i, "apellidoPaterno" + i, "apellidoMaterno" + i, "cargo" + 1, "clave" + 1, "fechaRegistro" + i, "rol" + i, "direccion" + i, "telefono" + i) ;  
					
				}	
			 
		}	 
		
		@Test
		public void testListarUsuarioRegistradas(){
			
			List<Usuario> usuario = new ArrayList<Usuario>();
			usuario = usuarioControlador.devolverListaUsuario();
			for(Usuario usuarios : usuario){
				System.out.println(usuarios.getDni() + " " + usuarios.getApellido_Paterno());
			}
			System.out.println("Total de Usuario registradas : " + usuarioControlador.devolverCantidadUsuario());
			assertEquals(15, usuarioControlador.devolverCantidadUsuario());
		}	
		
		@Test
		public void testMostrarDatosUsuario(){
					Usuario usuario = usuarioControlador.obtenerUsuarioPorDni("dni1002");
			assertEquals("dni1002", usuario.getDni());
			assertEquals("nombres1002",usuario.getNombres());
				
		}	
		
		@Test
		public void testModificarDatosUsuario(){
			
			usuarioControlador.modificarUsuario("dni10001", "carlos@hotmail.com", "Carlos", "Morales",
			"Ortiz", "adminstrador", "user", 
			"05/02/2012", "admin1", "av. brasil 520", "4523322");
			
			Usuario usuario= usuarioControlador.obtenerUsuarioPorDni("dni10001");
			// ASSERTS
			assertEquals("dni10001", usuario.getDni());
			assertEquals("correo@upc.edu.pe", usuario.getCorreo());
			assertEquals("Carlos", usuario.getNombres());
			assertEquals("Morales", usuario.getApellido_Paterno());
			assertEquals("Ortiz", usuario.getApellido_Materno());
			assertEquals("administrador", usuario.getCargo());
			assertEquals("user", usuario.getClave());
			assertEquals("05/02/2012" , usuario.getFechaRegistro());
			assertEquals("admin" , usuario.getRol());
			assertEquals("av. brasil 520" , usuario.getDireccion());
			assertEquals("4523322", usuario.getTelefono());
		
		}
		
		@Test
		public void testBuscarUsuario(){
			
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios =usuarioControlador.devolverListaBusquedaUsuarioPorApellidos("Morales");
					
			for(Usuario usuario : usuarios){
				System.out.println(usuario.getApellido_Paterno()+ " " + usuario.getDni());
			}
			System.out.println("Resultado busqueda de usuario : " + usuarios.size() + " coincidencias");		
			assertEquals("Morales", usuarios.get(0).getApellido_Paterno());
			
		}


		@Test
		public void testEliminarUsuario(){
					
			usuarioControlador.eliminarUsuario("dni1001");		
			//clienteControlador.eliminarEmpresa("E10005");
			//clienteControlador.eliminarEmpresa("E10015");
			assertNull(usuarioControlador.obtenerUsuarioPorDni("dni1001"));
			//assertNull(clienteControlador.obtenerEmpresaPorCodigo("E10005"));		
			//assertNull(clienteControlador.obtenerEmpresaPorCodigo("E10015"));		
			assertEquals(14, usuarioControlador.devolverCantidadUsuario());
		}



		@Test
		public void testExportarUsuario(){
			
			usuarioControlador.exportarUsuario("test/csv/Usuario_export.csv");
			
			try {

				List<Usuario> usuario1 = new ArrayList<Usuario>();
				usuario1 = usuarioControlador.devolverListaUsuario();
				int contador = 0;
				
				CsvReader usuario2 = new CsvReader("test/csv/Usuario_export.csv");	
				usuario2.readHeaders();
				
				while (usuario2.readRecord()){	
					
					assertEquals(usuario1.get(contador).getDni(), usuario2.get(0));
					assertEquals(usuario1.get(contador).getCorreo(), usuario2.get(1));
					assertEquals(usuario1.get(contador).getNombres(), usuario2.get(2));
					assertEquals(usuario1.get(contador).getApellido_Paterno(), usuario2.get(3));
					assertEquals(usuario1.get(contador).getApellido_Materno(), usuario2.get(4));
					assertEquals(usuario1.get(contador).getCargo(), usuario2.get(5));
					assertEquals(usuario1.get(contador).getClave(), usuario2.get(6));
					assertEquals(usuario1.get(contador).getFechaRegistro(), usuario2.get(7));
					assertEquals(usuario1.get(contador).getRol(), usuario2.get(8));
					assertEquals(usuario1.get(contador).getDireccion(), usuario2.get(9));
					assertEquals(usuario1.get(contador).getTelefono(), usuario2.get(10));
					
					contador++;
				}
		
				usuario2.close();	
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			

		@Test
		public void testImportarUsuario(){
			
			usuarioControlador.limpiaListaUsuario();
			usuarioControlador.importarUsuario("test/csv/Usuario_import.csv");
			
			try {
						
				List<Usuario> usuario1 = new ArrayList<Usuario>();
				usuario1 = usuarioControlador.devolverListaUsuario();
				
				int contador = 0;
				
				CsvReader usuario2 = new CsvReader("test/csv/Usuario_import.csv");	
				usuario2.readHeaders();
				
				while (usuario2.readRecord()){	
					
					assertEquals(usuario1.get(contador).getDni(), usuario2.get(0));
					assertEquals(usuario1.get(contador).getCorreo(), usuario2.get(1));
					assertEquals(usuario1.get(contador).getNombres(), usuario2.get(2));
					assertEquals(usuario1.get(contador).getApellido_Paterno(), usuario2.get(3));
					assertEquals(usuario1.get(contador).getApellido_Materno(), usuario2.get(4));
					assertEquals(usuario1.get(contador).getCargo(), usuario2.get(5));
					assertEquals(usuario1.get(contador).getClave(), usuario2.get(6));
					assertEquals(usuario1.get(contador).getFechaRegistro(), usuario2.get(7));
					assertEquals(usuario1.get(contador).getRol(), usuario2.get(8));
					assertEquals(usuario1.get(contador).getDireccion(), usuario2.get(9));
					assertEquals(usuario1.get(contador).getTelefono(), usuario2.get(10));
				
				
					contador++;
				}
		
				usuario2.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		
		
}
