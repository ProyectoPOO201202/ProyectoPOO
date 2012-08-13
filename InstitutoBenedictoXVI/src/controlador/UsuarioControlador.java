package controlador;

//import java.net.BindException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import controlador.BusinessException;
import dominio.Usuario;
import dominio.DAO.BaseDatosMock;
import dominio.DAO.TrabajadorDAO;

public class UsuarioControlador {
	
	// private TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
	
	
	private TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
	
	List<Usuario> listaUsuario = null;
    private String mensajeError = "";
    
    //public static Usuario usuarioAutenticado = new Usuario();

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

	public void setBaseDatosMock(BaseDatosMock bdMock) {
		// TODO Auto-generated method stub
		
	}

	public Usuario registrarUsuario(String dni, String correo, String nombre,
			String apellido_paterno, String apellido_materno, String cargo, String clave, String fechaRegistro, String rol, String direccion, String telefono) {
		Usuario usuario = new Usuario(dni, correo, nombre, apellido_paterno, apellido_materno, cargo, clave, fechaRegistro, rol, direccion, telefono);
		trabajadorDAO.crearUsuario(usuario);
		return usuario;
	}

	

	public void modificarUsuario(String dni, String correo, String nombre,
			String apellido_paterno, String apellido_materno, String cargo, String clave, String fechaRegistro, String rol, String direccion, String telefono) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Usuario> devolverListaBusquedaUsuarioPorApellidos(
			String apellido_paterno) {
		// TODO Auto-generated method stub
		return trabajadorDAO.devolverListaBusquedaUsuarioPorApellido(apellido_paterno);
	}

	public void eliminarUsuario(String dni) {
		trabajadorDAO.eliminarUsuario(dni);
		// TODO Auto-generated method stub
		
	}

	public void exportarUsuario(String nombreArchivo) {
		// TODO Auto-generated method stub
String outputFile = nombreArchivo;
		
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists){
				csvOutput.write("Dni");
				csvOutput.write("Correo");
				csvOutput.write("Nombres");
				csvOutput.write("ApellidoPaterno");
				csvOutput.write("Apellido_Materno");
				csvOutput.write("cargo");
				csvOutput.write("clave");
				csvOutput.write("FechaRegistro");
				csvOutput.write("Rolo");
				csvOutput.write("direccion");
				csvOutput.write("telefono");
				csvOutput.endRecord();
			}
			// else assume that the file already has the .correct header line
			
			List<Usuario> usuario = new ArrayList<Usuario>();
			usuario =devolverListaUsuario(); 
			for(Usuario usuarios: usuario){
				// write out a few records
				
				csvOutput.write(usuarios.getDni());
				csvOutput.write(usuarios.getNombres());
				csvOutput.write(usuarios.getApellido_Paterno());
				csvOutput.write(usuarios.getApellido_Materno());
				csvOutput.write(usuarios.getCorreo());
				csvOutput.write(usuarios.getClave());
				csvOutput.write(usuarios.getCargo());
				csvOutput.write(usuarios.getFechaRegistro());
				csvOutput.write(usuarios.getRol());
				csvOutput.write(usuarios.getDireccion());
				csvOutput.write(usuarios.getTelefono());
						
				csvOutput.endRecord();
			}
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void limpiaListaUsuario() {
		// TODO Auto-generated method stub
		trabajadorDAO.limpiarListaUsuario();
		
	}

	public void importarUsuario(String nombreArchivo) {
		// TODO Auto-generated method stub
		try {
			
			CsvReader usuario = new CsvReader(nombreArchivo);
		
			usuario.readHeaders();

			while (usuario.readRecord()){
			
				String dni = usuario.get(0);	
				String correo = usuario.get(1);
				String nombres= usuario.get(2);
				String apellido_paterno= usuario.get(2);
				String apellido_materno= usuario.get(3);
				String cargo = usuario.get(4);
				String clave = usuario.get(5);
				String fechaRegistro = usuario.get(7);
				String rol = usuario.get(8);
				String direccion = usuario.get(9);
				String telefono = usuario.get(10);
				
				
				// perform program logic here
				registrarUsuario(dni, correo, nombres, apellido_paterno, apellido_materno, cargo, clave, fechaRegistro, rol, direccion, telefono);
			
			}

			usuario.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public List<Usuario> devolverListaUsuario() {
		// TODO Auto-generated method stub
		return trabajadorDAO.devolverUsuario();
	}

    
	public int devolverCantidadUsuario(){
        return trabajadorDAO.devolverCantidadUsuario();		
    }

	public Usuario obtenerUsuarioPorDni(String dni) {
		// TODO Auto-generated method stub
		return trabajadorDAO.obtenerUsuarioPorDni(dni);
	}




	//public String getMensajeError() {
		//return mensajeError;
	//}

	//public void setMensajeError(String mensajeError) {
		//this.mensajeError = mensajeError;
	//}

}
