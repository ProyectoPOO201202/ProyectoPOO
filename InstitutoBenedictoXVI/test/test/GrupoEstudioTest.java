package test;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Test;

import dominio.GrupoEstudio;
import dominio.GrupoEstudio.TFiltro;
import dominio.ParametroIncompleto;

public class GrupoEstudioTest {
	
	private String nombregrupo;
	private String academia;
	private String curso;
	private String fechainicio;
	private String fechafin;
	private String estado;


	@Test
	public void TestGrupoEstudioValidaDatos(){
<<<<<<< HEAD
		GrupoEstudio grupoestudio;
=======
		//Validacion no dar de alta un grupo si faltan datos 
>>>>>>> 2366bcbccde5adc67136a09fe77a3c649a14ba41
		try {
			grupoestudio = new GrupoEstudio( "01","ff", "Modulo1", 
					"Aduni", "Matematicas", "01-01-2012", 
					"30-02-2012", "Juan Perez", "http:\\linkestudios", 
					"La Marina", "322", "xxxx","EN_CURSO");
			String codGrupo = grupoestudio.getCodGrupo();
		Assert.assertEquals("01", codGrupo);	
			
		} catch (ParametroIncompleto e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
<<<<<<< HEAD
		}		
=======
		}
	}
	
	@Test
	public void TestGrupoNuevo(){
	//Dar de alta a un grupo		
	GrupoEstudio gruponuevo1 = new GrupoEstudio();
	
	gruponuevo1.setCodGrupo("01");
	gruponuevo1.setNombregrupo("Programacion");
	gruponuevo1.setDescripcion("Programacion Orientada a Objetos");
	gruponuevo1.setAcademia("El Buen Pastor");
	gruponuevo1.setCurso("Java");
	gruponuevo1.setFechainicio("01-08-2012");
	gruponuevo1.setFechafin("30-09-2012");
	gruponuevo1.setInstructor("Miguel Fernandez");
	gruponuevo1.setLink("http://www.lawebdelprogramador.com/");
	gruponuevo1.setLocal("Miraflores");
	gruponuevo1.setAula("201");
	gruponuevo1.setCoordenadas("lon:110-lat:100");
	gruponuevo1.setEstado("EN_CURSO");
	
	assertEquals("01", gruponuevo1.getCodGrupo());
	assertEquals("Programacion", gruponuevo1.getNombregrupo());
	assertEquals("Programacion Orientada a Objetos", gruponuevo1.getDescripcion());
	assertEquals("El Buen Pastor", gruponuevo1.getAcademia());
	assertEquals("Java", gruponuevo1.getCurso());
	assertEquals("01-08-2012", gruponuevo1.getFechainicio());
	assertEquals("30-09-2012", gruponuevo1.getFechafin());
	assertEquals("Miguel Fernandez", gruponuevo1.getInstructor());
	assertEquals("http://www.lawebdelprogramador.com/", gruponuevo1.getLink());
	assertEquals("Miraflores", gruponuevo1.getLocal());
	assertEquals("201", gruponuevo1.getAula());
	assertEquals("lon:110-lat:100", gruponuevo1.getCoordenadas());
	assertEquals("EN_CURSO", gruponuevo1.getEstado());
>>>>>>> 2366bcbccde5adc67136a09fe77a3c649a14ba41
	}
	
	@Test 
	public void testMetodoFiltro() throws ParametroIncompleto {		
		//busqueda de grupo
		boolean bool_resultado;
		int contador;
		
		setNombregrupo(new String ());
		setAcademia(new String ());
		setCurso(new String ());
		setFechainicio(new String ());
		setFechafin(new String ());
		setEstado(new String ());
		
		GrupoEstudio prueba = new GrupoEstudio
				("01", "Programacion","El Buen Pastor","Java", 
						"01-08-2012", "30-09-2012",dominio.GrupoEstudio.Estado.EN_CURSO);
		
		bool_resultado=prueba.addFiltro(TFiltro.NOMBREGRUPO, "Prueba");
		contador=prueba.listaFiltro();
		Assert.assertTrue(bool_resultado);	
		Assert.assertEquals(2, contador);
	}

	public String getNombregrupo() {
		return nombregrupo;
	}

	public void setNombregrupo(String nombregrupo) {
		this.nombregrupo = nombregrupo;
	}

	public String getAcademia() {
		return academia;
	}

	public void setAcademia(String academia) {
		this.academia = academia;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
