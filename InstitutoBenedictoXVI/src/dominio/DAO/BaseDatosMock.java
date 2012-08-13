package dominio.DAO;

import java.util.List;

import dominio.Cliente;
import dominio.Persona;
import dominio.Prospecto;
import dominio.Trabajador;
import dominio.Usuario;

public interface BaseDatosMock {
    public List<Prospecto> devolverProspecto();
    public List<Persona> devolverPersona();
	public List<Usuario> devolverUsuario();
	public List<Trabajador> devolverTrabajador();
    public List<Cliente> devolverCliente();

}