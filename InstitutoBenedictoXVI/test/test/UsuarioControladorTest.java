package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.BindException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import controlador.Controlador;
import controlador.UsuarioControlador;
import dominio.Usuario;


public class UsuarioControladorTest {

	@Test
	public void testValidar() throws BindException {
		//fail("Not yet implemented");
		boolean result =true;
		
		try {
		Controlador controlador = new Controlador();
		
		String valorcontrasena = "user";
		String correo = "user@upc.edu.pe";
		String contrasena = "user";
		String ConfirmacionClave = "user";
		boolean estado = true;
		result = controlador.validarUsuario(contrasena, correo, valorcontrasena, ConfirmacionClave, estado);
		} catch (BindException be) {
			Logger.getLogger(UsuarioControladorTest.class.getName()).log(Level.SEVERE, null, be);
		}
		assertTrue("bienvenido al sistema", result);
		
	}


@Test
public void testCrearUsuario() throws BindException {
    boolean resultadoValidar = true;
    boolean resultadoCrear = true;
    Usuario usuario = null;
    UsuarioControlador controlador = null;
    controlador = new UsuarioControlador();
	String confirmarContrasena = "desarrollo";
	String correo = "user2@user.com";
	String clave = "desarrollo";
	boolean flag = true;
	resultadoValidar = controlador.validarDatosUsuario(correo, clave, confirmarContrasena, flag);
	resultadoCrear = controlador.crear(correo, clave, confirmarContrasena, flag);
	usuario = controlador.buscarUsuario(correo);
    assertTrue("Usuario validado", resultadoValidar);
    assertTrue("Se creo nuevo usuario", resultadoCrear);
    assertEquals("user2@user.com", usuario.getCorreo());
    assertEquals("desarrollo", usuario.getClave());
    assertEquals(true, usuario.isFlagTerminosLeg());
	}
}
