	package dominio.DAO;

	import java.util.ArrayList;
	import java.util.List;

	import dominio.Rol;


	public class RolDAO {
		private DataBase bdMock;

	    public void setBaseDatosMock(DataBase bdMock) {
	        this.bdMock = bdMock;
	    }

	    public void crearRol(Rol rol) {
	        bdMock.tablaRol().add(rol);
	    }
	    
	    public void modificarRol(String codigo, String descripcion){
	    	
	    	Rol rol = obtenerRolPorCodigo(codigo);
	    	rol.setDescripcion(descripcion);			
			
		}
	    
		public ArrayList<Rol> devolverListaBusquedaRolDescripcion(String descripcion){
	        
			ArrayList<Rol> resultadoBusquedaRol = new ArrayList<Rol>();
			for(int i = 0; i < cantidadRol(); i++)
			{            
				Rol m = devolverRol().get(i);          
	            if(m.getDescripcion().indexOf(descripcion) > -1)
	            {
	            	resultadoBusquedaRol.add(m);
	            }
	        }		
			return resultadoBusquedaRol;
	    }
	    
		public void eliminarRol(String codigo){
	        for(int i = 0; i < cantidadRol(); i++)
	        {            
	        	Rol m = devolverRol().get(i);          
	            if(m.getCodigo().equals(codigo))
	            {
	                devolverRol().remove(i);
	            }
	        }
		}
	    
		public Rol obtenerRolPorCodigo(String codigo){
			Rol rol = null;
			for(int i = 0; i < cantidadRol(); i++)
			{    
				Rol m = devolverRol().get(i);            
	            if(m.getCodigo().equals(codigo))
	            {
	            	rol = m;
	                break;
	            }
			}
			return rol;
		}
		
		public int cantidadRol(){
	        return devolverRol().size();
	    }

	    public List<Rol> devolverRol() {
	        return bdMock.tablaRol();
	    }
	    
	    public void limpiaListaRol() {
	        bdMock.tablaRol().clear();
	    }
	}


