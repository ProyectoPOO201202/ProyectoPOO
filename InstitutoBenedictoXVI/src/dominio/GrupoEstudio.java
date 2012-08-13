package dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GrupoEstudio {
	

		
	  	 private String CodGrupo;
		 private String Nombregrupo;
		 private String Descripcion;
	  	 private String Academia;
	  	 private String Curso;
	  	 private String Fechainicio;
	  	 private String Fechafin;
	  	 private String Instructor;
	  	 private String Link;
		 private String Local;
		 private String Aula;
		 private String Coordenadas;
		 private String Estado;
		 
<<<<<<< HEAD
		
		public GrupoEstudio(String codGrupo, String nombregrupo,
				String descripcion, String academia, String curso,
				String fechainicio, String fechafin, String instructor,
				String link, String local, String aula, String coordenadas,
				String estado) throws ParametroIncompleto {
			super();
			
			if (codGrupo.equals("")){
				throw new ParametroIncompleto("codigo de grupo");
			}
			else if (nombregrupo.equals("")){
				throw new ParametroIncompleto("nombre de grupo");
			}	
			else if (fechainicio.equals("")){
				throw new ParametroIncompleto("fecha de inicio");
			}	
			else if (fechafin.equals("")){
					throw new ParametroIncompleto("fecha de fin");
			}
			
=======
		 
		   public GrupoEstudio(String string, String string2, String string3, String string4, String string5, String string6, dominio.GrupoEstudio.Estado enCurso) {    }
		   public enum Estado {EN_CURSO,FINALIZADO,ANULADO}
		   public enum TFiltro{NOMBREGRUPO,ACADEMIA,GRUPO,FECHAINICIO,FECHAFIN,ESTADO}

		 public GrupoEstudio(String codGrupo, String nombregrupo,
					String descripcion, String academia, String curso,
					String fechainicio, String fechafin, String instructor,
					String link, String local, String aula, String coordenadas,
					String estado) throws ParametroIncompleto {
				super();
				
				if (codGrupo.equals("")){
					throw new ParametroIncompleto("codigo de grupo");
				}
				else if (nombregrupo.equals("")){
					throw new ParametroIncompleto("nombre de grupo");
				}	
				else if (fechainicio.equals("")){
					throw new ParametroIncompleto("fecha de inicio");
				}	
				else if (fechafin.equals("")){
						throw new ParametroIncompleto("fecha de fin");
				} 		 
		 
>>>>>>> 2366bcbccde5adc67136a09fe77a3c649a14ba41
			CodGrupo = codGrupo;
			Nombregrupo = nombregrupo;
			Descripcion = descripcion;
			Academia = academia;
			Curso = curso;
			Fechainicio = fechainicio;
			Fechafin = fechafin;
			Instructor = instructor;
			Link = link;
			Local = local;
			Aula = aula;
			Coordenadas = coordenadas;
			Estado = estado;
			
		}
<<<<<<< HEAD
		
=======
		public GrupoEstudio() {
			// TODO Auto-generated constructor stub
		}
>>>>>>> 2366bcbccde5adc67136a09fe77a3c649a14ba41
		public String getCodGrupo() {
			return CodGrupo;
		}
		public void setCodGrupo(String codGrupo) {
			CodGrupo = codGrupo;
		}
		public String getNombregrupo() {
			return Nombregrupo;
		}
		public void setNombregrupo(String nombregrupo) {
			Nombregrupo = nombregrupo;
		}
		public String getDescripcion() {
			return Descripcion;
		}
		public void setDescripcion(String descripcion) {
			Descripcion = descripcion;
		}
		public String getAcademia() {
			return Academia;
		}
		public void setAcademia(String academia) {
			Academia = academia;
		}
		public String getCurso() {
			return Curso;
		}
		public void setCurso(String curso) {
			Curso = curso;
		}
		public String getFechainicio() {
			return Fechainicio;
		}
		public void setFechainicio(String fechainicio) {
			Fechainicio = fechainicio;
		}
		public String getFechafin() {
			return Fechafin;
		}
		public void setFechafin(String fechafin) {
			Fechafin = fechafin;
		}
		public String getInstructor() {
			return Instructor;
		}
		public void setInstructor(String instructor) {
			Instructor = instructor;
		}
		public String getLink() {
			return Link;
		}
		public void setLink(String link) {
			Link = link;
		}
		public String getLocal() {
			return Local;
		}
		public void setLocal(String local) {
			Local = local;
		}
		public String getAula() {
			return Aula;
		}
		public void setAula(String aula) {
			Aula = aula;
		}
		public String getCoordenadas() {
			return Coordenadas;
		}
		public void setCoordenadas(String coordenadas) {
			Coordenadas = coordenadas;
		}
		public String getEstado() {
			return Estado;
		}
		public void setEstado(String estado) {
			Estado = estado;
		}
		
		 @Override
		    public String toString() {
		    return "GrupoEstudio [CodGrupo=" + CodGrupo  + ", " +
		    " Nombregrupo=" + Nombregrupo + ", " + 
		    " Descripcion=" + Descripcion + ", " +
		    " Academia=" + Academia + ", " +
		    " Curso=" + Curso + ", " +
		    " Fechainicio=" + Fechainicio + ", " +
		    " Fechafin=" + Fechafin + ", " + 
		    " Instructor=" + Instructor + ", " +
		    " Link=" + Link + ", " +
		    " Local=" + Local + ", " +
		    " Aula=" + Aula + ", " +
		    " Coordenadas=" + Coordenadas + 
		    " Estado=" + Estado +
		    "]";
		    }
		private List<Filtro> filtro = new ArrayList<Filtro>();
			
			public boolean addFiltro(TFiltro tipoFiltro, String valor)
			{
				Filtro cargador = new Filtro(tipoFiltro.toString(),valor);
				filtro.add(cargador);
				return true;		
			}
			
		public int listaFiltro() {
				{
				Filtro contenedor;
				int contador = 0;
				Iterator<Filtro> iterador = filtro.iterator();
				while (iterador.hasNext())
				{	
					contenedor = iterador.next();
					System.out.println(contenedor.getCodigo() + " " + contenedor.getValor() );
					contador++;
				}
				return contador;
			}
	}
}
