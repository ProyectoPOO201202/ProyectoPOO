package controlador;

//import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import controlador.BusinessException;

import dominio.Usuario;

public class UsuarioControlador {
	
	List<Usuario> listaUsuario = null;
    private String mensajeError = "";
    
    public static Usuario usuarioAutenticado = new Usuario();

    public UsuarioControlador() {
        listaUsuario = new ArrayList<Usuario>();
    }
    
    public Usuario buscarUsuario(String dni) throws BusinessException {
		// TODO Auto-generated method stub
		for (Usuario usuario : listaUsuario){
			if (usuario.getCorreo().equals(dni)){
				return usuario;
			}
			
		}
		return null;
	}
    
	public boolean crear(String dni, String nombre, String apellidoPaterno, String ApellidoMaterno, String cargo, String correo, String clave,
			String confirmarcontrasena, boolean flag) throws BusinessException {
		if (buscarUsuario(correo) == null){
			LocalDate fechaActual = new DateTime().toLocalDate();
			
			
			Usuario usuario = new Usuario();
			usuario.setDni(dni);
			usuario.setNombre(nombre);
			usuario.setApellidoPaterno(apellidoPaterno);
			usuario.setApellidoMaterno(ApellidoMaterno);
			usuario.setCargo(cargo);
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

	public boolean validarUsuario(String correo, String clave,
			String confirmarcontrasena,boolean flag) throws BusinessException{
		mensajeError = "";
		boolean validarCorreo = true;
		
		Funcion funcion = new Funcion();
		if (correo == null || correo.isEmpty()){
			mensajeError = "ingrese su cuenta de correo";
			} else{
				validarCorreo = funcion.valCorreo(correo);
				if (validarCorreo == false) {
					mensajeError = "ingrese correo valido";
					} else {
						if (clave == null || clave.isEmpty()){
							mensajeError = "ingrese su contraseña";
						} else {
							if (confirmarcontrasena == null || confirmarcontrasena.isEmpty()){
							mensajeError = "confirme su contraseña";
						} else {
							if (!clave.equals(confirmarcontrasena)){
								mensajeError = "Contraseña no son iguales";
							}
						}
					}
					}
			}
		// TODO Auto-generated method stub
		if (!mensajeError.isEmpty()){
			throw new BusinessException(mensajeError);
		}
		return false;
	}



	//public String getMensajeError() {
		//return mensajeError;
	//}

	//public void setMensajeError(String mensajeError) {
		//this.mensajeError = mensajeError;
	//}

}
