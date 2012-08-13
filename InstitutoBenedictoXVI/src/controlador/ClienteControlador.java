package controlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Assert;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import dominio.Cliente;
import dominio.Empresa;
import dominio.Prospecto;
import dominio.Persona;
import dominio.DAO.*;

public class ClienteControlador {
	

    private ClienteDAO clienteDAO = new ClienteDAO();
    private ProspectoDAO prospectoDAO = new ProspectoDAO();
    
    
    
    /* METODOS REFERENTES a PROSPECTO */
    
    
    
    public Cliente registrarCliente(String codigocliente,String dni,String nombres, String apellido_paterno, String apellido_materno, String telefono,String celular, String fechacontacto, String correo, String direccion, String distrito, String departamento){
		
    	Assert.assertNotNull("Ingrese Nombre",nombres);
		Assert.assertNotNull("Ingrese apellido Paterno",apellido_paterno);
		Assert.assertNotNull("Ingrese Email",correo);
		
    	Cliente cliente	= new Cliente(codigocliente,dni,nombres, apellido_paterno, apellido_materno, telefono,celular, fechacontacto,correo, direccion, distrito,departamento);
		clienteDAO.crearCliente(cliente);
		return cliente;
	}
	
    public void modificarCliente(String codigocliente,String dni,String nombres, String apellido_paterno, String apellido_materno, String telefono, String fechacontacto, String correo, String direccion, String distrito, String departamento){
		clienteDAO.modificarCliente(codigocliente,dni, nombres, apellido_paterno, apellido_materno, telefono, fechacontacto, correo, direccion, distrito, departamento);
   
	}
    
    
    
public void exportarCliente(String nombreArchivo){
		
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
			
			List<Cliente> cliente = new ArrayList<Cliente>();
			cliente =	devolverListaCliente(); 
			for(Cliente clientes: cliente){
				// write out a few records
				csvOutput.write(clientes.getDni());
				csvOutput.write(clientes.getNombres());
				csvOutput.write(clientes.getApellido_Paterno());
				csvOutput.write(clientes.getApellido_Materno());
				csvOutput.write(clientes.getTelefono());
				csvOutput.write(clientes.getFechaPase());
				csvOutput.write(clientes.getCorreo());
				csvOutput.write(clientes.getDireccion());
				csvOutput.write(clientes.getDistrito());
				csvOutput.write(clientes.getDepartamento());
														
						
				csvOutput.endRecord();
			}
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    
public void importarCliente(String nombreArchivo){
	
	try {
		
		
		CsvReader cliente = new CsvReader(nombreArchivo);
	
		cliente.readHeaders();

		while (cliente.readRecord()){
		
			String codigocliente = cliente.get(0);
			String dni = cliente.get(1);				
			String nombres= cliente.get(2);
			String apellido_paterno= cliente.get(3);
			String apellido_materno= cliente.get(4);
			String telefono = cliente.get(5);
			String celular = cliente.get(6);
			String fechacontacto = cliente.get(7);
			String correo = cliente.get(8);
			String direccion = cliente.get(9);
			String distrito = cliente.get(10);
			String departamento = cliente.get(11);
						
			// perform program logic here
			registrarCliente(codigocliente, dni, nombres, apellido_paterno, apellido_materno, telefono,celular, fechacontacto, correo, direccion, distrito, departamento);
		
		}

		cliente.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

    public ArrayList<Cliente> devolverListaBusquedaClientePorApellidos(String apellidos){
    	Assert.assertEquals("No se encontraron registros para los filtros ingresados","1",String.valueOf(clienteDAO.devolverListaBusquedaClientePorApellidos(apellidos).size()));
    	return clienteDAO.devolverListaBusquedaClientePorApellidos(apellidos);
    }
    
    public void eliminarCliente(String codigo){
    	clienteDAO.eliminarCliente(codigo);
	}
	
    public Cliente obtenerClientePorCodigo(String codigocliente){

    	Assert.assertNotNull("No se encontraron registros para los filtros ingresados", clienteDAO.obtenerClientePorCodigo(codigocliente));
		return clienteDAO.obtenerClientePorCodigo(codigocliente);
	}
    
	public int devolverCantidadCliente(){
        return clienteDAO.devolverCantidadCliente();		
    }
    
	public List<Cliente> devolverListaCliente(){
        return clienteDAO.devolverCliente();
       }
    
    public void limpiaListaCliente() {
    	clienteDAO.limpiaListaCliente();
    	
    }
    
    public void setBaseDatosMock(BaseDatosMock bdMock) {
        // this.clienteDAO.setBaseDatosMock(bdMock);
        this.clienteDAO.setBaseDatosMock(bdMock);
        
    }
    
    
    	
}
