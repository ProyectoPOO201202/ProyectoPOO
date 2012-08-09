package controlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import dominio.Empresa;
import dominio.Prospecto;
import dominio.Persona;
import dominio.DAO.BaseDatosMock;
import dominio.DAO.*;

public class PersonaControlador {
	

    private PersonaDAO personaDAO = new PersonaDAO();
    private ProspectoDAO prospectoDAO = new ProspectoDAO();
    
    
    
    /* METODOS REFERENTES a PROSPECTO */
    
    
    public Prospecto registrarProspecto(String dni,String nombres, String apellido_paterno, String apellido_materno, String telefono, String fechacontacto, String correo, String direccion, String distrito, String departamento){
		Prospecto prospecto= new Prospecto(dni,nombres, apellido_paterno, apellido_materno, telefono, fechacontacto,correo, direccion, distrito,departamento);
		prospectoDAO.crearProspecto(prospecto);
		return prospecto;
	}
	
    public void modificarProspecto(String dni,String nombres, String apellido_paterno, String apellido_materno, String telefono, String fechacontacto, String correo, String direccion, String distrito, String departamento){
		prospectoDAO.modificarProspecto(dni, nombres, apellido_paterno, apellido_materno, telefono, fechacontacto, correo, direccion, distrito, departamento);
   
	}
    
    
    
public void exportarProspecto(String nombreArchivo){
		
		String outputFile = nombreArchivo;
		
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists){
				csvOutput.write("Dni");
				csvOutput.write("Nombres");
				csvOutput.write("Apellido_Paterno");
				csvOutput.write("Apellido_Materno");
				csvOutput.write("Telefono");
				csvOutput.write("FechaContacto");
				csvOutput.write("Correo");
				csvOutput.write("Direccion");
				csvOutput.write("Distrito");
				csvOutput.write("Departamento");
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			
			List<Prospecto> prospecto = new ArrayList<Prospecto>();
			prospecto =devolverListaProspecto(); 
			for(Prospecto prospectos: prospecto){
				// write out a few records
				csvOutput.write(prospectos.getDni());
				csvOutput.write(prospectos.getNombres());
				csvOutput.write(prospectos.getApellido_Paterno());
				csvOutput.write(prospectos.getApellido_Materno());
				csvOutput.write(prospectos.getTelefono());
				csvOutput.write(prospectos.getFechaContacto());
				csvOutput.write(prospectos.getCorreo());
				csvOutput.write(prospectos.getDireccion());
				csvOutput.write(prospectos.getDistrito());
				csvOutput.write(prospectos.getDepartamento());
														
						
				csvOutput.endRecord();
			}
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    
public void importarProspecto(String nombreArchivo){
	
	try {
		
		CsvReader prospecto = new CsvReader(nombreArchivo);
	
		prospecto.readHeaders();

		while (prospecto.readRecord()){
		
			String dni = prospecto.get(0);				
			String nombres= prospecto.get(1);
			String apellido_paterno= prospecto.get(2);
			String apellido_materno= prospecto.get(3);
			String telefono = prospecto.get(4);
			String fechacontacto = prospecto.get(5);
			String correo = prospecto.get(6);
			String direccion = prospecto.get(7);
			String distrito = prospecto.get(7);
			String departamento = prospecto.get(8);
						
			// perform program logic here
			registrarProspecto(dni, nombres, apellido_paterno, apellido_materno, telefono, fechacontacto, correo, direccion, distrito, departamento);
		
		}

		prospecto.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

    public ArrayList<Prospecto> devolverListaBusquedaProspectoPorApellidos(String apellidos){
    	return prospectoDAO.devolverListaBusquedaProspectoPorApellidos(apellidos);
    }
    
    public void eliminarProspecto(String dni){
		prospectoDAO.eliminarProspecto(dni);
	}
	
    public Prospecto obtenerProspectoPorDni(String dni){
		return prospectoDAO.obtenerProspectoPorDni(dni);
	}
    
	public int devolverCantidadProspecto(){
        return prospectoDAO.devolverCantidadProspecto();		
    }
    
	public List<Prospecto> devolverListaProspecto(){
        return prospectoDAO.devolverProspecto();
       }
    
    public void limpiaListaProspecto() {
    	prospectoDAO.limpiaListaProspecto();
    	
    }
    
    public void setBaseDatosMock(BaseDatosMock bdMock) {
        // this.clienteDAO.setBaseDatosMock(bdMock);
        this.prospectoDAO.setBaseDatosMock(bdMock);
        
    }
    
    
    	
}
