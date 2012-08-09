package test;


import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import dominio.Academia;
import dominio.Rol;
import dominio.Usuario;

public class UsuarioTest {

	@Test
	public void testUser() {
	//fail("Not yet implemented");
		LocalDate FechaActual = new DateTime().toLocalDate();
		Rol rol = new Rol(101, "admin", 2, 5, 15, 10, new BigDecimal("0.00"));
		Academia academia = new Academia();
		academia.setNombre("BenedictoXVI");
		Usuario usuario = new Usuario();
		
		usuario.setDni("45646253");
		usuario.setNombre("carlos");
		usuario.setApellidoPaterno("Paredes");
		usuario.setApellidoMaterno("Diaz");
		usuario.setCargo("administrador");
		usuario.setCorreo("user@upc.edu.pe");
		usuario.setClave("user");
		usuario.setFlagTerminosLeg(true);
		usuario.setFechaRegistro(FechaActual);
		usuario.setRol("adm");
		usuario.setAcademia(academia);
		
		Assert.assertEquals("45646253",usuario.getDni());
		Assert.assertEquals("carlos",usuario.getNombre());
		Assert.assertEquals("Paredes",usuario.getApellidoPaterno());
		Assert.assertEquals("Diaz",usuario.getApellidoMaterno());
		Assert.assertEquals("administrador",usuario.getCargo());
		Assert.assertEquals("user@upc.edu.pe",usuario.getCorreo());
		Assert.assertEquals("user", usuario.getClave());
		Assert.assertEquals(usuario.isflagTerminosLeg(), usuario);
		Assert.assertEquals(rol, usuario.getRol());
		Assert.assertEquals(FechaActual, usuario.getFechaRegistro());
        Assert.assertEquals(academia.getCodigo(), usuario.getAcademia().getCodigo());
		
		
	}

}
