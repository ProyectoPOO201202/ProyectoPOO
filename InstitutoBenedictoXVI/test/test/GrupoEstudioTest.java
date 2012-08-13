package test;


import junit.framework.Assert;

import org.junit.Test;

import dominio.GrupoEstudio;
import dominio.ParametroIncompleto;

public class GrupoEstudioTest {
	
	@Test
	public void TestGrupoEstudioValidaDatos(){
		GrupoEstudio grupoestudio;
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
		}		
	}
	

}
