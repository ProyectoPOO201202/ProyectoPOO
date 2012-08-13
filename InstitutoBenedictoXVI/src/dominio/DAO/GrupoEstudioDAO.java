package dominio.DAO;

import java.util.ArrayList;
import java.util.List;

import dominio.GrupoEstudio;

public class GrupoEstudioDAO {
	private static final GrupoEstudio GrupoEstudio = null;
	private static DataBase bdMock;

    public void setBaseDatosMock(DataBase bdMock) {
        GrupoEstudioDAO.bdMock = bdMock;
    }

    public void crearGrupoEstudio(GrupoEstudio grupoestudio) {
        bdMock.tablaGrupoEstudio().add(grupoestudio);
    }
    
    public void modificarGrupoEstudio(String CodGrupo, String Nombregrupo, String Descripcion,
    		String Academia, String Curso, String Fechainicio,
    		String Fechafin, String Instructor, String Link,
    		String Local, String Aula, String Coordenadas, String Estado){    	
    	
    	GrupoEstudio grupoestudio = obtenerGrupoEstudioPorCodigo(CodGrupo);
    	grupoestudio.setNombregrupo(Nombregrupo);	
    	grupoestudio.setDescripcion(Descripcion);
    	grupoestudio.setAcademia(Academia);
    	grupoestudio.setCurso(Curso);
    	grupoestudio.setFechainicio(Fechainicio);
    	grupoestudio.setFechafin(Fechafin);
    	grupoestudio.setInstructor(Instructor);
    	grupoestudio.setLink(Link);
    	grupoestudio.setLocal(Local);
    	grupoestudio.setAula(Aula);
    	grupoestudio.setCoordenadas(Coordenadas);
    	grupoestudio.setEstado(Estado);
 	}
    
	private dominio.GrupoEstudio obtenerGrupoEstudioPorCodigo(String codGrupo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GrupoEstudio> devolverListaBusquedaGrupoEstudioDescripcion(String descripcion){
        
		ArrayList<GrupoEstudio> resultadoBusquedaGrupoEstudio = new ArrayList<GrupoEstudio>();
		for(int i = 0; i < cantidadGrupoEstudio(); i++)
		{            
			GrupoEstudio m = devolverGrupoEstudio().get(i);          
            if(m.getDescripcion().indexOf(descripcion) > -1)
            {
            	resultadoBusquedaGrupoEstudio.add(m);
            }
        }		
		return resultadoBusquedaGrupoEstudio;
    }
    
	public void eliminarGrupoEstudio(String CodGrupo){
        for(int i = 0; i < cantidadGrupoEstudio(); i++)
        {            
        	GrupoEstudio m = devolverGrupoEstudio().get(i);          
            if(m.getCodGrupo().equals(CodGrupo))
            {
            	devolverGrupoEstudio().remove(i);
            }
        }
	}
    
	public GrupoEstudio obtenerModuloPorCodigo(String codigo){
		@SuppressWarnings("unused")
		GrupoEstudio grupoestudio = null;
		for(int i = 0; i < cantidadGrupoEstudio(); i++)
		{    
			GrupoEstudio m = devolverGrupoEstudio().get(i);            
            if(m.getCodGrupo().equals(codigo))
            {
            	grupoestudio = m;
                break;
            }
		}
		return GrupoEstudio;
	}
	
	public static int cantidadGrupoEstudio(){
        return devolverGrupoEstudio().size();
    }

    public static List<GrupoEstudio> devolverGrupoEstudio() {
        return bdMock.tablaGrupoEstudio();
    }
    
    public void limpiaListaGrupoEstudio() {
        bdMock.tablaEmpresa().clear();
    }
	
}
