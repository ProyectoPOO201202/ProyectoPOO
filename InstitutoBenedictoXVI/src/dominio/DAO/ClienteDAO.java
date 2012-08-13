package dominio.DAO;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import dominio.Cliente;
import dominio.Persona;
import dominio.Prospecto;
import dominio.DAO.BaseDatosMock;

public class ClienteDAO {
	private BaseDatosMock bdMock;
	
	
    public void setBaseDatosMock(BaseDatosMock bdMock) {
        this.bdMock = bdMock;
    }
    public void crearCliente(Cliente cliente) {
        bdMock.devolverCliente().add(cliente);
    }
        
	public void modificarCliente(String codigo,String dni,String nombres, String apellido_paterno, String apellido_materno, String telefono, String fechapase, String correo, String direccion, String distrito, String departamento){
		
		Cliente cliente = obtenerClientePorCodigo(codigo);
		cliente.setNombres(nombres);
		cliente.setApellido_Paterno(apellido_paterno);
		cliente.setApellido_Materno(apellido_materno);
		cliente.setTelefono(telefono);
		cliente.setFechaPase(fechapase);
		cliente.setCorreo(correo);
		cliente.setDireccion(direccion);
		cliente.setDistrito(distrito);
		cliente.setDepartamento(departamento);
		
	}
    
    	
	public ArrayList<Cliente> devolverListaBusquedaClientePorApellidos(String apellidos){
        
		ArrayList<Cliente> resultadoBusquedaCliente	= new ArrayList<Cliente>();
	
		for(int i = 0; i < devolverCantidadCliente(); i++){            
        	Cliente c = devolverCliente().get(i);          
        
        	if(c.getApellido_Paterno().indexOf(apellidos) > -1){
        		resultadoBusquedaCliente.add(c);
            }
        }		
		
		return resultadoBusquedaCliente;
    }
    
	public void eliminarCliente(String codigocliente){
        for(int i = 0; i < devolverCantidadCliente(); i++){            
        	Cliente c = devolverCliente().get(i);          
            if(c.getCodigoCliente().equals(codigocliente)){
                devolverCliente().remove(i);
            }
        }
	}
    
		
	public Cliente obtenerClientePorCodigo(String codigocliente){
		Cliente cliente = null;
		for(int i = 0; i < devolverCantidadCliente(); i++){    
			Cliente c = devolverCliente().get(i);            
            if(c.getCodigoCliente().equals(codigocliente)){
            	cliente = c;
                break;
            }
		}
		return cliente;
	
	}
	  
    
	public int devolverCantidadCliente(){
        return devolverCliente().size();
    }
    
	 public List<Cliente> devolverCliente() {
	        return bdMock.devolverCliente();
	    }
    
	 public void limpiaListaCliente() {
	        bdMock.devolverCliente().clear();
	    }
    
    }

