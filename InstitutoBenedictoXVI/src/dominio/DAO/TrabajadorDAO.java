package dominio.DAO;


import java.util.ArrayList;
import java.util.List;


import org.joda.time.LocalDate;


import dominio.Usuario;


public class TrabajadorDAO {
	
 private DataBase bdMock;
 public void setBaseDatosMock(DataBase bdMock) {
     this.bdMock = bdMock;
 }
 public void crear(Usuario usuario) {
     bdMock.tablaUsuario().add(usuario);
 }
 public void modificarUsuario(String dni, String nombre, String apellidoPaterno,
			String apellidoMaterno, String cargo, String correo, String clave,
			String rol, String academia, LocalDate fecharegistro, boolean flag){
 	
 	Usuario usuario = obtenerUsuarioPorDni(dni);
		usuario.setDni(dni);
		usuario.setNombre(nombre);
		usuario.setApellidoPaterno(apellidoPaterno);
		usuario.setApellidoMaterno(apellidoMaterno);
		usuario.setCargo(cargo);
		usuario.setCorreo(correo);	
		usuario.setRol(rol);
		usuario.setFechaRegistro(fecharegistro);
		usuario.setFlagTerminosLeg(flag);
			
		
	}
 
 public List<Usuario> devolverListaBusquedaUsusarioPorApellido(String apellidoPaterno){
	 List<Usuario> resultadoBusquedaUsuario = new ArrayList<Usuario>();
	 
	 for (int i = 0; i < devolverCantidadUsuario(); i++){
	 	Usuario u = devolverUsuario().get(i);
	 	
	 	if(u.getApellidoPaterno().indexOf(apellidoPaterno) > -1){
	 		resultadoBusquedaUsuario.add(u);
	 	}
	 }
	 return resultadoBusquedaUsuario;
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
	return null;
}
public int devolverCantidadUsuario() {
	// TODO Auto-generated method stub
	return devolverUsuario().size();
}

public List<Usuario> devolverUsuario() {
	// TODO Auto-generated method stub
	return bdMock.tablaUsuario();
}
public void limpiarListaUsuario(){
	bdMock.tablaUsuario().clear();
}
}
