package test;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import dominio.Academia;
import dominio.TipoCuenta;
import dominio.Usuario;

public class UsuarioTest {

    @Test
    public void testMetodosBasicos() {
        LocalDate fechaActual = new DateTime().toLocalDate();
        TipoCuenta tipoCuenta = new TipoCuenta(101, "Plan Gratuito", 2, 5, 15, 10, new BigDecimal("0.00"));
        Academia academia = new Academia();
        academia.setNombre("uni");

        Usuario usuario = new Usuario();

        usuario.setCorreo("user@user.com");
        usuario.setClave("clave");
        usuario.setFlagTerminosLegales(true);
        usuario.setFechaRegistro(fechaActual);
        usuario.setTipoCuenta(tipoCuenta);
        usuario.setAcademia(academia);
        
        Assert.assertEquals("user@user.com", usuario.getCorreo());
        Assert.assertEquals("clave", usuario.getClave());
        Assert.assertTrue(usuario.isFlagTerminosLegales());
        Assert.assertEquals(tipoCuenta, usuario.getTipoCuenta());
        Assert.assertEquals(fechaActual, usuario.getFechaRegistro());
        Assert.assertEquals(academia.getRazon_social(), usuario.getAcademia().getRazon_social());

    }
}
