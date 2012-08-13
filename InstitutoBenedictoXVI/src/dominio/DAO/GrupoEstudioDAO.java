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

    public static void crearGrupoEstudio(GrupoEstudio grupoestudio) {
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
    
	public static dominio.GrupoEstudio obtenerGrupoEstudioPorCodigo(String codGrupo) {
		GrupoEstudio GrupoEstudio = null;
	        List<GrupoEstudio> GrupoEstudio1 = bdMock.devolverGrupoEstudio();

	        for (int i = 0; i < GrupoEstudio1.size(); i++) {

	        	GrupoEstudio hab = GrupoEstudio1.get(i);

	            if (codGrupo.equals(hab.getCodGrupo())) {
	                return hab;
	            }
	        }

	        return GrupoEstudio;
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
    
	public static void eliminarGrupoEstudio(String CodGrupo){
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

	public static void modificarGrupoEstudio(String nombre,
			GrupoEstudio grupoEstudio1) {
		
	}
	
}
