package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import java.net.BindException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import controlador.BusinessException;
import controlador.UsuarioControlador;
import dominio.Usuario;


public class UsuarioControladorTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testValidarUsuario() {
		//fail("Not yet implemented");
		boolean result =true;
		
		try {
		UsuarioControlador controlador = new UsuarioControlador();
		//String dni = "45646253";
		//String nombre = "Carlos";
		//String apellidoPaterno = "Paredes";
		//String apellidoMaterno = "Diaz";
		//String cargo = "administrador";
		String confirmarcontrasena = "user";
		String correo = "user@upc.edu.pe";
		String clave = "user";
		boolean flag = true;
		result = controlador.validarUsuario(correo, clave, confirmarcontrasena, flag);
		} catch (BusinessException be) {
			Logger.getLogger(UsuarioControladorTest.class.getName()).log(Level.SEVERE, null, be);
		}
		assertTrue("bienvenido al sistema", result);
		
	}
	
	@Test
	public void testBuscarUsuario() {
		boolean result = true;
		try {
			UsuarioControlador controlador = new UsuarioControlador();
			controlador.buscarUsuario("user@upc.edu.pe");
			} catch (BusinessException be){
				Logger.getLogger(UsuarioControladorTest.class.getName()).log(Level.SEVERE, null, be);
				
			}
		assertTrue("No existe Usuario", result);
		
	}


@Test
public void testCrearUsuario() {
    boolean resultadoValidar = true;
    boolean resultadoCrear = true;
    Usuario usuario = null;
    UsuarioControlador controlador = null;
    try {
	    controlador = new UsuarioControlador();
		String confirmarcontrasena = "user";
		String dni = "45646253";
		String nombre = "Carlos";
		String apellidoPaterno = "Paredes";
		String apellidoMaterno = "Diaz";
		String cargo = "administrador";
		String correo = "user@user.com";
		String clave = "user";
		boolean flag = true;
	resultadoValidar = controlador.validarUsuario(correo, clave, confirmarcontrasena, flag);
	resultadoCrear = controlador.crear(dni, nombre, apellidoPaterno, apellidoMaterno, cargo, correo, clave, confirmarcontrasena, flag);
	usuario = controlador.buscarUsuario(correo);
	
    } catch (BusinessException be){
    	Logger.getLogger(UsuarioControladorTest.class.getName()).log(Level.SEVERE, null, be);
    }
    assertTrue("Usuario validado", resultadoValidar);
    assertTrue("Se creo nuevo usuario", resultadoCrear);
    assertEquals("45646253", usuario.getDni());
    assertEquals("carlos", usuario.getNombre());
    assertEquals("Paredes",usuario.getApellidoPaterno());
    assertEquals("Diaz",usuario.getApellidoMaterno());
    assertEquals("adminsitrador", usuario.getCargo());
    assertEquals("user2@user.com", usuario.getCorreo());
    assertEquals("user", usuario.getClave());
    assertEquals(true, usuario.isflagTerminosLeg());
	}

@Test
public void testCorreoVacio() throws BusinessException{
	thrown.expect(BusinessException.class);
	thrown.expectMessage("Ingrese su correo");
	
	UsuarioControlador controlador = new UsuarioControlador();
	String confirmarcontrasena = "user";

	String correo = "user@user.com";
	String clave = "user";
	boolean flag = true;
	
	controlador.validarUsuario(correo, clave, confirmarcontrasena, flag);
}

@Test
public void testClaveVacio() throws BusinessException{
	thrown.expect(BusinessException.class);
	thrown.expectMessage("Ingrese su contraseña");
	
	UsuarioControlador controlador = new UsuarioControlador();
	String correo = "user@upc.edu.pe";
	String clave = "";
	String confirmarcontrasena = "user2";
	boolean flag = true;
	
	controlador.validarUsuario(correo, clave, confirmarcontrasena, flag);
}

@Test
public void testConfirmacionClave() throws BusinessException{
	thrown.expect(BusinessException.class);
	thrown.expectMessage("Ingrese su contraseña");
	
	UsuarioControlador controlador = new UsuarioControlador();
	String correo = "user@upc.edu.pe";
	String clave = "user2";
	String confirmarcontrasena = "";
	boolean flag = true;
	
	controlador.validarUsuario(correo, clave, confirmarcontrasena, flag);
}

@Test
public void testValidacionClave() throws BusinessException{
	thrown.expect(BusinessException.class);
	thrown.expectMessage("Ingrese su contraseña");
	
	UsuarioControlador controlador = new UsuarioControlador();
	String correo = "user@upc.edu.pe";
	String clave = "user";
	String confirmarcontrasena = "user2";
	boolean flag = true;
	
	controlador.validarUsuario(correo, clave, confirmarcontrasena, flag);
}
}
