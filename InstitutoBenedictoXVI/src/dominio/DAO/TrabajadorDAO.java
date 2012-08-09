package dominio.DAO;


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
private Usuario obtenerUsuarioPorDni(String dni) {
	// TODO Auto-generated method stub
	return null;
}
}
