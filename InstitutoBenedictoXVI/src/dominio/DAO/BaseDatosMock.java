package dominio.DAO;

import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;
import dominio.Persona;
import dominio.Prospecto;

public interface BaseDatosMock {
    public List<Prospecto> devolverProspecto();
    public List<Persona> devolverPersona();
    public List<Cliente> devolverCliente();
	
}