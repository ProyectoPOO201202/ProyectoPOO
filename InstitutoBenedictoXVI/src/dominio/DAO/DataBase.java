package dominio.DAO;

import java.util.List;

import dominio.*;

public interface DataBase {
	
	public List<Empresa> tablaEmpresa();
	public List<Modulo> tablaModulo();
	public List<Rol> tablaRol();
<<<<<<< HEAD
	public List<Usuario> tablaUsuario();
	public List<GrupoEstudio> tablaGrupoEstudio();
=======
//<<<<<<< HEAD
	public int tablaUsuario();
//=======
	public List<GrupoEstudio> tablaGrupoEstudio();
	public List<GrupoEstudio> devolverGrupoEstudio();
//>>>>>>> cb1229682c328efe6385376e6f065cd5f849683f
	public List<Usuario> devolverUsuario();
>>>>>>> 2366bcbccde5adc67136a09fe77a3c649a14ba41
}
