package test;


import org.junit.Test;

import dominio.GrupoEstudio;
import dominio.ParametroIncompleto;

public class GrupoEstudioTest {
	@Test
	public void TestGrupoEstudio(){
		try {
			GrupoEstudio  GrupoEstudio=new GrupoEstudio( "ff", "Modulo1", "Aduni", "Matematicas", "", "", "Juan Perez", "http:\\linkestudios", "La Marina", "322", "xxxx");
		} catch (ParametroIncompleto e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
