package controlador;

import java.net.BindException;
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

	public boolean validarDatosUsuario(String correo, String clave,
			String confirmarContrasena, boolean flag) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean crear(String correo, String clave,
			String confirmarContrasena, boolean flag) throws BindException {
		if (buscarUsuario(correo)== null){
			LocalDate fechaActual = new DateTime().toLocalDate();
			
			Usuario usuario = new Usuario();
			usuario.setCorreo(correo);
			usuario.setClave(clave);
			usuario.setFlagTerminosLeg(flag);
			usuario.setFechaRegistro(fechaActual);
			
			listaUsuario.add(usuario);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	public Usuario buscarUsuario(String codigo) throws BindException {
		// TODO Auto-generated method stub
		for (Usuario usuario : listaUsuario){
			if (usuario.getCorreo().equals(codigo)){
				return usuario;
			}
			
		}
		return null;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

}
