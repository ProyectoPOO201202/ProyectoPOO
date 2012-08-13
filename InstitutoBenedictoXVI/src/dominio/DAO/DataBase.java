package dominio.DAO;

import java.util.List;

import dominio.*;

public interface DataBase {
	
	public List<Empresa> tablaEmpresa();
	public List<Modulo> tablaModulo();
	public List<Rol> tablaRol();
//<<<<<<< HEAD
	public int tablaUsuario();
//=======
	public List<GrupoEstudio> tablaGrupoEstudio();
	public List<GrupoEstudio> devolverGrupoEstudio();
//>>>>>>> cb1229682c328efe6385376e6f065cd5f849683f
	public List<Usuario> devolverUsuario();
}
