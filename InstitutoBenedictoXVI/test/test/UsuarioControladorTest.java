package test;

import static org.junit.Assert.*;

import java.net.BindException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import controlador.Controlador;


public class UsuarioControladorTest {

	@Test
	public void testValidar() throws BindException {
		//fail("Not yet implemented");
		boolean result =true;
		Controlador controlador = new Controlador();
		
		String valorcontrasena = "user";
		String correo = "user@upc.edu.pe";
		String contrasena = "user";
		String ConfirmacionClave = "user";
		boolean estado = true;
		result = controlador.validarUsuario(contrasena, correo, valorcontrasena, ConfirmacionClave, estado);
		assertTrue("bienvenido al sistema", result);
	}

}
