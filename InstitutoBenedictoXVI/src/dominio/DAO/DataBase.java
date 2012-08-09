package dominio.DAO;

import java.util.List;

import dominio.*;

public interface DataBase {
	
	public List<Empresa> tablaEmpresa();
	public List<Modulo> tablaModulo();
	public List<Rol> tablaRol();
	public List<GrupoEstudio> tablaGrupoEstudio();
}
