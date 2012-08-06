package test;


import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import dominio.Instituto;
import dominio.TipoCuenta;
import dominio.Usuario;

public class UsuarioTest {

	@Test
	public void testUser() {
	//fail("Not yet implemented");
		LocalDate FechaActual = new DateTime().toLocalDate();
		TipoCuenta tipocuenta = new TipoCuenta(101, "admin", 2, 5, 15, 10, new BigDecimal("0.00"));
		Instituto instituto = new Instituto();
		instituto.setNombre("BenedictoXVI");
		Usuario usuario = new Usuario();
		
		usuario.setCorreo("user@upc.edu.pe");
		usuario.setClave("clave");
		usuario.setFlagTerminosLeg(true);
		usuario.setFechaRegistro(FechaActual);
		usuario.setTipoCuenta(tipocuenta);
		usuario.setInstituto(instituto);
		
		Assert.assertEquals("user@upc.edu.pe",usuario.getCorreo());
		Assert.assertEquals("clave", usuario.getClave());
		Assert.assertEquals(usuario.isflagTerminosLeg(), usuario);
		Assert.assertEquals(tipocuenta, usuario.getTipoCuenta());
		Assert.assertEquals(FechaActual, usuario.getFechaRegistro());
        Assert.assertEquals(instituto.getNombre(), usuario.getInstituto().getNombre());
		
		
	}

}
