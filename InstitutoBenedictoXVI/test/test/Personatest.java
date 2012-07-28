package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Cliente;
import dominio.Persona;

public  class Personatest {

@Test
public void TestPersona(){

Persona persona1 = new Cliente("45538817","Eduardo","Rodriguez","Valladares","4984384", "10/12/1987", "tito.rodriguev@hotmail.com","Callao","Bellavista","Callao");

//Asserts
assertEquals("45538817",persona1.getDni());
assertEquals("Eduardo",persona1.getNombres());
assertEquals("Rodriguez",persona1.getApellido_Paterno());
assertEquals("Valladares",persona1.getApellido_Materno());
assertEquals("4984384",persona1.getTelefono());
assertEquals("tito.rodriguev@hotmail.com",persona1.getCorreo());
assertEquals("Callao",persona1.getDireccion());
assertEquals("Bellavista",persona1.getDistrito());
assertEquals("Callao",persona1.getDepartamento());

}
}

