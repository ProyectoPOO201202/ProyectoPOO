package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.AdmRol;
import dominio.Rol;

public class AdmRolTest {

	@Test
	public void RegistrarRoltest() {
		
		//fail("Not yet implemented");
		String codrol ="001";
		String nombrerol = "Administrador";
		AdmRol admrol = new AdmRol();
		
		admrol.registrarRol(codrol, nombrerol);
		
		Rol rol = admrol.buscarRol(codrol);
		assertNotNull(rol);
		assertEquals(codrol, rol.getCodigo());
		assertEquals(nombrerol, rol.getnombrerol());
		
	}
	
	@Test
	//vaqlidar duplicidad de codigo
	public void AdmRolValDuplicidad(){
		String codrol = "002";
		String nombrerol1 = "Vendedor";
		String nombrerol2 = "Comprador";
		
		AdmRol admrol = new AdmRol();
		admrol.registrarRol(codrol, nombrerol1);
		admrol.registrarRol(codrol, nombrerol2);
		
		int totalRolesRetornados = admrol.getTotalRol();
		int totalRolesEsperado = 1;
		assertEquals(totalRolesEsperado, totalRolesRetornados);
		
	}

}
