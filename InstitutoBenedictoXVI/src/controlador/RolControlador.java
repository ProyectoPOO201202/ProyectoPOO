package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.csvreader.CsvReader;

import dominio.*;
import dominio.DAO.DataBase;
import dominio.DAO.RolDAO;

public class RolControlador {

	
private RolDAO rolDAO = new RolDAO();
	
	public Rol registrarRol(String codigo, String descripcion,String creado_por,String creado_el){
		Rol rol = new Rol();
		rol.crearRol(codigo, descripcion, creado_por, creado_el);
		rolDAO.crearRol(rol);
		return rol;
	}
	
	 public Rol modificarRol(String codigo, String descripcion, boolean acceso,boolean adicionar,boolean editar,boolean eliminar)
	 {
	    	Rol encontrado = busquedaRolCodigo(codigo);
	    	encontrado.setDescripcion(descripcion);
			encontrado = busquedaRolCodigo(codigo);
			encontrado.setAcceso(acceso);
			encontrado.setAdicionar(adicionar);
			encontrado.setEditar(editar);
			encontrado.setEliminar(eliminar);	
			return encontrado;
		}
	    
	
	public void importarRol(String nombreArchivo){		
		try {			
			CsvReader rol = new CsvReader(nombreArchivo);		
			rol.readHeaders();
			while (rol.readRecord()){			
				String codigo = rol.get(0);				
				String descripcion = rol.get(1);		
				String creado_por = rol.get(2);
				String creado_el = rol.get(3);
				registrarRol(codigo, descripcion, creado_por, creado_el);
			}
	
			rol.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public Rol busquedaRolCodigo(String codigo)
	{
		Rol retorno;
		retorno = rolDAO.obtenerRolPorCodigo(codigo);
		return retorno;		
	}
	
	public List<Rol> busquedaRolDescripcion(String descripcion)
	{
		List<Rol> listaRol;
		listaRol = rolDAO.devolverListaBusquedaRolDescripcion(descripcion);
		return listaRol;		
	}

	public List<Rol> devolverListaRol()
	{
	    return rolDAO.devolverRol();
	}
	
	public int cantidadRol(){
        return rolDAO.cantidadRol();
    }
	
	public void setDataBase(DataBase bdMock) {
        this.rolDAO.setBaseDatosMock(bdMock);
    }
	
	public void limpiaListaRol() {
		this.rolDAO.limpiaListaRol();
    }
	
	public Rol modificaAccesoRol(String codigo,boolean acceso,boolean adicionar,boolean editar,boolean eliminar)
	{
		Rol encontrado = new Rol();
		encontrado = busquedaRolCodigo(codigo);
		encontrado.setAcceso(acceso);
		encontrado.setAdicionar(adicionar);
		encontrado.setEditar(editar);
		encontrado.setEliminar(eliminar);	
		return encontrado;
	}

	public boolean eliminarRol(String codigo) {
		
		boolean resultado = false;
		try {		
			rolDAO.eliminarRol(codigo);
			resultado = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
		return resultado;
	}

}
