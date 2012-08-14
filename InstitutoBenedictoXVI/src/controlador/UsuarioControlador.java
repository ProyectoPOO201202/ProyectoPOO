package controlador;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import dominio.Usuario;

public class UsuarioControlador {

    List<Usuario> listaUsuario = null;
    private String mensajeError = "";

    public static Usuario usuarioAutenticado = new Usuario();

    public UsuarioControlador() {
        listaUsuario = new ArrayList<Usuario>();
    }

    public Usuario buscarUsuario(String codigo) throws BusinessException {
        for (Usuario usuario : listaUsuario) {
            if (usuario.getCorreo().equals(codigo)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean crear(String correo, String clave, String validaContrasena, boolean flag) throws BusinessException {
        if (buscarUsuario(correo) == null) {

            LocalDate fechaActual = new DateTime().toLocalDate();

            Usuario usuario = new Usuario();
            usuario.setCorreo(correo);
            usuario.setClave(clave);
            usuario.setFlagTerminosLegales(flag);

            usuario.setFechaRegistro(fechaActual);

            listaUsuario.add(usuario);
            return true;

        }
        return false;
    }

    public boolean validarDatosUsuario(String correo, String clave, String claveConfirmacion, boolean flag) throws BusinessException {
        mensajeError = "";
        boolean validarCorreo = true;

        Funcion funciones = new Funcion();

        if (correo == null || correo.isEmpty()) {
            mensajeError = "Debe ingresar su cuenta de correo";
        } else {
            validarCorreo = funciones.valCorreo(correo);
            if (validarCorreo == false) {
                mensajeError = "Ingrese un correo válido";
            } else {
                if (clave == null || clave.isEmpty()) {
                    mensajeError = "Debe ingresar su contraseña";
                } else {
                    if (claveConfirmacion == null || claveConfirmacion.isEmpty()) {
                        mensajeError = "Debe confirmar su contraseña";
                    } else {

                        if (!clave.equals(claveConfirmacion)) {
                            mensajeError = "Las contraseñas no coinciden";
                        }
                    }
                }
            }
        }

        if (!mensajeError.isEmpty()) {
            throw new BusinessException(mensajeError);
        }

        return true;
    }
}
