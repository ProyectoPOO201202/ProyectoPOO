package dominio.DAO;

import java.util.ArrayList;
import java.util.List;

import dominio.Modulo;


public class ModuloDAO {
	private DataBase bdMock;

    public void setBaseDatosMock(DataBase bdMock) {
        this.bdMock = bdMock;
    }

    public void crearModulo(Modulo modulo) {
        bdMock.tablaModulo().add(modulo);
    }
    
    public void modificarModulo(String codigo, String descripcion){
    	
    	Modulo modulo = obtenerModuloPorCodigo(codigo);
    	modulo.setDescripcion(descripcion);			
		
	}
    
	public ArrayList<Modulo> devolverListaBusquedaModuloDescripcion(String descripcion){
        
		ArrayList<Modulo> resultadoBusquedaEmpresas = new ArrayList<Modulo>();
		for(int i = 0; i < cantidadModulo(); i++)
		{            
			Modulo m = devolverModulo().get(i);          
            if(m.getDescripcion().indexOf(descripcion) > -1)
            {
            	resultadoBusquedaEmpresas.add(m);
            }
        }		
		return resultadoBusquedaEmpresas;
    }
    
	public void eliminarModulo(String codigo){
        for(int i = 0; i < cantidadModulo(); i++)
        {            
        	Modulo m = devolverModulo().get(i);          
            if(m.getCodigo().equals(codigo))
            {
                devolverModulo().remove(i);
            }
        }
	}
    
	public Modulo obtenerModuloPorCodigo(String codigo){
		Modulo modulo = null;
		for(int i = 0; i < cantidadModulo(); i++)
		{    
			Modulo m = devolverModulo().get(i);            
            if(m.getCodigo().equals(codigo))
            {
            	modulo = m;
                break;
            }
		}
		return modulo;
	}
	
	public int cantidadModulo(){
        return devolverModulo().size();
    }

    public List<Modulo> devolverModulo() {
        return bdMock.tablaModulo();
    }
    
    public void limpiaListaEmpresa() {
        bdMock.tablaEmpresa().clear();
    }
}