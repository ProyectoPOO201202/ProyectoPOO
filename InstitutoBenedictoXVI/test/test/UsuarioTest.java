package test;


//import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dominio.Usuario;

public class UsuarioTest {
	
	@Test
	public void TestUsuario(){

	Usuario usuario1 = new Usuario();
	

	usuario1.setDni("41734347");
	usuario1.setCorreo("carlos@hotmail.com");
	usuario1.setNombres("Carlos");
	usuario1.setApellido_Paterno("Morales");
	usuario1.setApellido_Materno("Ortiz");
	usuario1.setCargo("administrador");
	usuario1.setClave("user");
	usuario1.setFechaRegistro("05/02/2012");
	usuario1.setRol("rol");
	usuario1.setDireccion("av. brasil 520");
	usuario1.setTelefono("4523322");
	
	
	
	assertEquals("41734347", usuario1.getDni());
	assertEquals("carlos@hotmail.com", usuario1.getCorreo());
	assertEquals("Carlos", usuario1.getNombres());
	assertEquals("Morales", usuario1.getApellido_Paterno());
	assertEquals("Ortiz", usuario1.getApellido_Materno());
	assertEquals("administrador", usuario1.setCargo());
	assertEquals("user", usuario1.getClave());
	assertEquals("05/02/2012", usuario1.getFechaRegistro());
	assertEquals("rol", usuario1.getRol());
	assertEquals("av. brasil 520", usuario1.getDireccion());
	assertEquals("4523322", usuario1.getTelefono());
	
	
	
	
}

@Test
public void ValidarDatosUsuario(){
	Usuario usuario1 = new Usuario();
String Dni = null;
String correo = null;
String Nombres = null;
String Apellido_Paterno=null;
String Apellido_Materno= null;
String Direccion = null;
String Telefono = null;
//String cargo = null;
//String clave = null;

boolean datoscorrectos = usuario1.ValidaDatos(Dni,correo,Nombres,Apellido_Paterno,Apellido_Materno, Direccion, Telefono); 
	if (datoscorrectos==false) {
		System.out.print("Faltan llenar Datos importantes");
	}
//Assert.assertFalse("No a ingresado datos relevantes",datoscorrectos);

}

//prueba

	}


