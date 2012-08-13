package dominio.DAO;

import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;
import dominio.Persona;
import dominio.Prospecto;
import dominio.Trabajador;
import dominio.Usuario;

public interface BaseDatosMock {
    public List<Prospecto> devolverProspecto();
    public List<Persona> devolverPersona();
<<<<<<< HEAD
	public List<Usuario> devolverUsuario();
	public List<Trabajador> devolverTrabajador();
=======
    public List<Cliente> devolverCliente();
	
>>>>>>> b417a707086ea37f101e134d471dd7a36933809f
}