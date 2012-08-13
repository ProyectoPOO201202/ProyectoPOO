package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.csvreader.CsvReader;

import dominio.GrupoEstudio;
import dominio.ParametroIncompleto;
import dominio.DAO.DataBase;
import dominio.DAO.GrupoEstudioDAO;

public class GrupoEstudioControlador {

private GrupoEstudioDAO grupoestudioDAO = new GrupoEstudioDAO();
	
	public GrupoEstudio registrarGrupoEstudio(String CodGrupo, String Nombregrupo, String Descripcion,
    		String Academia, String Curso, String Fechainicio,
    		String Fechafin, String Instructor, String Link,
    		String Local, String Aula, String Coordenadas, String Estado) throws ParametroIncompleto{
		GrupoEstudio grupoestudio = new GrupoEstudio(CodGrupo, Nombregrupo, Descripcion,
	    		Academia, Curso, Fechainicio,
	    		Fechafin, Instructor, Link,
	    		Local, Aula, Coordenadas, Estado);		
		grupoestudioDAO.crearGrupoEstudio(grupoestudio);
		return grupoestudio;
	}
	
public void importarGrupoEstudio(String nombreArchivo) throws ParametroIncompleto{
		
		try {
			
			CsvReader grupoestudio = new CsvReader(nombreArchivo);
		
			grupoestudio.readHeaders();

			while (grupoestudio.readRecord()){
			
				String CodGrupo = grupoestudio.get(0);				
				String Nombregrupo = grupoestudio.get(1);				
				String Descripcion = grupoestudio.get(2);				
				String Academia = grupoestudio.get(3);	
				String Curso = grupoestudio.get(4);				
				String Fechainicio = grupoestudio.get(5);								
				String Fechafin = grupoestudio.get(6);	
				String Instructor = grupoestudio.get(7);	
				String Link = grupoestudio.get(8);				
				String Local = grupoestudio.get(9);								
				String Aula = grupoestudio.get(10);	
				String Coordenadas = grupoestudio.get(11);								
				String Estado = grupoestudio.get(12);	
			
				registrarGrupoEstudio(CodGrupo, Nombregrupo, Descripcion,
			    		Academia, Curso, Fechainicio,
			    		Fechafin, Instructor, Link,
			    		Local, Aula, Coordenadas, Estado);
			}
	
			grupoestudio.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void crearGrupoEstudio(GrupoEstudio GrupoEstudio1) throws BusinessException {
		GrupoEstudioDAO.crearGrupoEstudio(GrupoEstudio1);
	}

	public GrupoEstudio obtenerGrupoEstudio(String CodGrupo) {
		return GrupoEstudioDAO.obtenerGrupoEstudioPorCodigo(CodGrupo);
	}

	public void modificarGrupoEstudio(String nombre, GrupoEstudio GrupoEstudio1) {
		GrupoEstudioDAO.modificarGrupoEstudio(nombre, GrupoEstudio1);
	}

	public void eliminarGrupoEstudio(String nombre) {
		GrupoEstudioDAO.eliminarGrupoEstudio(nombre);
	}

	public List<GrupoEstudio> devolverListaGrupoEstudio()
	{
	    return GrupoEstudioDAO.devolverGrupoEstudio();
	}
	
	public int cantidadGrupoEstudio(){
        return GrupoEstudioDAO.cantidadGrupoEstudio();
    }
	
	public void setDataBase(DataBase bdMock) {
        this.grupoestudioDAO.setBaseDatosMock(bdMock);
    }
	
	public void limpiaListaGrupoEstudio() {
		this.grupoestudioDAO.limpiaListaGrupoEstudio();
    }
	
}
