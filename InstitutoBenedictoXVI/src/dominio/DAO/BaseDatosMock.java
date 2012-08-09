package dominio.DAO;

import java.util.List;

import dominio.Persona;
import dominio.Prospecto;

public interface BaseDatosMock {
    public List<Prospecto> devolverProspecto();
    public List<Persona> devolverPersona();
}