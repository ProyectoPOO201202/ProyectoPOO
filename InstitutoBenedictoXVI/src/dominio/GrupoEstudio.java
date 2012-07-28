package dominio;




public class GrupoEstudio {
	
	  	public GrupoEstudio(String nombregrupo, String descripcion,
			String academia, String curso, String fechainicio, String fechafin,
			String instructor, String link, String local, String aula,
			String coordenadas) throws ParametroIncompleto {
		super();
		
		if (nombregrupo.equals("")){
			throw new ParametroIncompleto("nombre de grupo");
		}
		else if (fechainicio.equals("")){
			throw new ParametroIncompleto("fecha de inicio");
		}	
		else if (fechafin.equals("")){
				throw new ParametroIncompleto("fecha de fin");
		}
		
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
	}

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
}