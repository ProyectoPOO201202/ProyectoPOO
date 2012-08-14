package dominio.DAO;

import java.util.List;

import dominio.*;

public interface DataBase {
	
	public List<Empresa> tablaEmpresa();
	public List<Modulo> tablaModulo();
	public List<Rol> tablaRol();
	public List<Transaccion> tablaTransaccion();
	public List<Transaccion> tablaFiltro();
	
	public List<Usuario> tablaUsuario();
	public List<GrupoEstudio> tablaGrupoEstudio();
	public List<GrupoEstudio> devolverGrupoEstudio();
	public List<Usuario> devolverUsuario();
}
