package dominio.DAO;


import java.util.ArrayList;
import java.util.List;


//import org.joda.time.LocalDate;
import dominio.Usuario;


public class TrabajadorDAO {
	
 private BaseDatosMock bdMock;
 
 public void setBaseDatosMock(BaseDatosMock bdMock) {
     this.bdMock = bdMock;
 }
 public void crearUsuario(Usuario usuario) {
     bdMock.devolverUsuario().add(usuario);
 }
 public void modificarUsuario(String dni, String correo, String nombres, String apellido_paterno,
			String apellido_materno, String cargo, String clave, String fecharegistro,
			String rol, String direccion, String telefono){
 	
 	Usuario usuario = obtenerUsuarioPorDni(dni);
		usuario.setDni(dni);
		usuario.setCorreo(correo);
		usuario.setNombres(nombres);
		usuario.setApellido_Paterno(apellido_paterno);
		usuario.setApellido_Paterno(apellido_paterno);
		usuario.setCargo(cargo);
		usuario.setFechaRegistro(fecharegistro);
		usuario.setRol(rol);
		usuario.setDireccion(direccion);
		usuario.setTelefono(telefono);
			
		
	}
 
 public ArrayList<Usuario> devolverListaBusquedaUsuarioPorApellido(String apellido_paterno){
	 List<Usuario> resultadoBusquedaUsuario = new ArrayList<Usuario>();
	 
	 for (int i = 0; i < devolverCantidadUsuario(); i++){
	 	Usuario u = devolverUsuario().get(i);
	 	
	 	if(u.getApellido_Paterno().indexOf(apellido_paterno) > -1){
	 		resultadoBusquedaUsuario.add(u);
	 	}
	 }
	 return (ArrayList<Usuario>) resultadoBusquedaUsuario;
 }

 public void eliminarUsuario(String dni){
	 for(int i = 0; i < devolverCantidadUsuario(); i++){
		 Usuario u = devolverUsuario().get(i);
		 if(u.getDni().equals(dni)){
			 devolverUsuario().remove(i);
		 }
	 }
 }

public Usuario obtenerUsuarioPorDni(String dni) {
	Usuario usuario = null;
	for(int i = 0; i < devolverCantidadUsuario(); i++){
		Usuario u = devolverUsuario().get(i);
		if(u.getDni().equals(dni)){
			usuario = u;
			break;
		}
	}
	// TODO Auto-generated method stub
	return usuario;
}
public int devolverCantidadUsuario() {
	// TODO Auto-generated method stub
	return devolverUsuario().size();
}

public List<Usuario> devolverUsuario() {
    return bdMock.devolverUsuario();
}
public void limpiarListaUsuario(){
	bdMock.devolverUsuario().clear();
}
}
