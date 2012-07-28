package controlador;

import java.net.BindException;

public class Controlador {

	private String mensajeError;

	public boolean validarUsuario(String contrasena, String correo,
			String valorcontrasena,String ConfirmacionClave,boolean estado) throws BindException {
		mensajeError = "";
		boolean valCorreo = true;
		Funcion funcion = new Funcion();
		
		if (correo == null || correo.isEmpty()) {
            mensajeError = "Ingresar correo";
        } else {
            valCorreo = funcion.valCorreo(correo);
            if (valCorreo == false) {
                mensajeError = "El correo no es válido";
            } else {
                if (contrasena == null || contrasena.isEmpty()) {
                    mensajeError = "Ingrese su contraseña";
                } else {
                    if (ConfirmacionClave == null || ConfirmacionClave.isEmpty()) {
                        mensajeError = "Confirme Contraseña";
                    } else {

                        if (!contrasena.equals(ConfirmacionClave)) {
                            mensajeError = "No es valida su contraseña";
                        }
                    }
                }
            }
		
        }// TODO Auto-generated method stub
		if (!mensajeError.isEmpty()){
			throw new BindException(mensajeError);
			//return true;
		}
		return true;
	}

}
