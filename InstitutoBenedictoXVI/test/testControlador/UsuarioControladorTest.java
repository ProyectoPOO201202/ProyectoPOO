package testControlador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import testControlador.UsuarioControladorTest;

import controlador.BusinessException;
import controlador.UsuarioControlador;
import dominio.Usuario;

public class UsuarioControladorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testValidarUsuario() {
        boolean resultado = true;
        try {
            UsuarioControlador controlador = new UsuarioControlador();
            String confirmarContrasena = "user";
            String correo = "rcmo@gmail.com";
            String clave = "user";
            boolean flag = true;
            resultado = controlador.validarDatosUsuario(correo, clave, confirmarContrasena, flag);
        } catch (controlador.BusinessException be) {
            Logger.getLogger(UsuarioControladorTest.class.getName()).log(Level.SEVERE, null, be);
        }
        assertTrue("Se valido satisfactoriamente", resultado);
    }

    @Test
    public void testBuscarUsuario() {
        boolean resultado = true;
        try {
            UsuarioControlador controlador = new UsuarioControlador();
            controlador.buscarUsuario("rcmo@gmail.com");
        } catch (controlador.BusinessException be) {
            Logger.getLogger(UsuarioControladorTest.class.getName()).log(Level.SEVERE, null, be);
        }
        assertTrue("No existe el usuario", resultado);
    }

    @Test
    public void testCrearUsuario() {
        boolean resultadoValidar = true;
        boolean resultadoCrear = true;
        Usuario usuario = null;
        UsuarioControlador controlador = null;
        try {
            controlador = new UsuarioControlador();
            String confirmarContrasena = "user";
            String correo = "rcmo@gmail.com";
            String clave = "user";
            boolean flag = true;
            resultadoValidar = controlador.validarDatosUsuario(correo, clave, confirmarContrasena, flag);
            resultadoCrear = controlador.crear(correo, clave, confirmarContrasena, flag);
            usuario = controlador.buscarUsuario(correo);
        } catch (controlador.BusinessException be) {
            Logger.getLogger(UsuarioControladorTest.class.getName()).log(Level.SEVERE, null, be);
        }
        assertTrue("Se valido satisfactoriamente", resultadoValidar);
        assertTrue("Se grabo satisfactoriamente", resultadoCrear);
        assertEquals("rcmo@gmail.com", usuario.getCorreo());
        assertEquals("user", usuario.getClave());
        assertEquals(true, usuario.isFlagTerminosLegales());
    }

 

  

    @Test
    public void testValidarCorreoVacio() throws BusinessException {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("Debe ingresar su cuenta de correo");

        UsuarioControlador controlador = new UsuarioControlador();
        String correo = "";
        String clave = "aa";
        String claveConfirmacion = "aa";
        boolean flag = true;

        controlador.validarDatosUsuario(correo, clave, claveConfirmacion, flag);
    }

    @Test
    public void testValidarClaveVacia() throws BusinessException {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("Debe ingresar su contraseña");

        UsuarioControlador controlador = new UsuarioControlador();
        String correo = "rcmo@gmail.com";
        String clave = "";
        String claveConfirmacion = "aa";
        boolean flag = true;

        controlador.validarDatosUsuario(correo, clave, claveConfirmacion, flag);
    }

    @Test
    public void testValidarClaveConfirmacionVacia() throws BusinessException {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("Debe confirmar su contraseña");

        UsuarioControlador controlador = new UsuarioControlador();
        String correo = "rcmo@gmail.com";
        String clave = "aa";
        String claveConfirmacion = "";
        boolean flag = true;

        controlador.validarDatosUsuario(correo, clave, claveConfirmacion, flag);
    }    
    
    @Test
    public void testValidarLaConfirmacionContrasena() throws BusinessException {
        thrown.expect(BusinessException.class);
        thrown.expectMessage("Las contraseñas no coinciden");

        UsuarioControlador controlador = new UsuarioControlador();
        String confirmarContrasena = "user";
        String correo = "rcmo@gmail.com";
        String clave = "aa";
        boolean flag = true;
        controlador.validarDatosUsuario(correo, clave, confirmarContrasena, flag);

    }
}
