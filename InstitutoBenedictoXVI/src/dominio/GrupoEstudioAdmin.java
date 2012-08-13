package dominio;

import java.util.ArrayList;

public class GrupoEstudioAdmin {
	    // Declaracion de la coleccion de GrupoEstudio
	    private ArrayList<GrupoEstudio> grupos;
	    

	    public GrupoEstudioAdmin() {
	    // Crear la coleccion de objetos GrupoEstudio
	    	grupos = new ArrayList<GrupoEstudio>();
	    }
	     
	    public boolean RegistrarGrupoEstudio(String codigo, String nombregrupo, String descripcion,
				String academia, String curso, String fechainicio, String fechafin,
				String instructor, String link, String local, String aula,
				String coordenadas,String estado) throws ParametroIncompleto {
	    	
	    	GrupoEstudio grupoEstudio = new GrupoEstudio(estado, estado, estado, estado, estado, estado, estado, estado, estado, estado, estado, estado, estado);
	    	
	         if  (buscar(nombregrupo) == null){
	             // Crear un nuevo GrupoEstudio y registrarlo en la coleccion
	        	
	        	 grupos.add(grupoEstudio);	        	 
	       	     return true;
	         }
	         return false;
	    }

	    public GrupoEstudio buscar(String nombregrupo) {
	        // Buscar el tipo de grupo por nombre
	        for(GrupoEstudio tipo : grupos)
	            if (tipo.getNombregrupo().equals(nombregrupo))
	               return tipo;
	        return null;
	    }
	        
	    @SuppressWarnings("unused")
		private void ValidaDuplicidad(final String nombregrupo) 
	    	// Valida registros duplicados por nombre
	            throws RegistroDuplicado {
	        if (buscar(nombregrupo) != null){
	            String mensaje = "Nombre Grupo "+ nombregrupo + " Ya esta registrado.";
	            throw new RegistroDuplicado(mensaje);
	        }
	    }
}
