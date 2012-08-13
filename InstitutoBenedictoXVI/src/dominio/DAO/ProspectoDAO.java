package dominio.DAO;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
//import org.joda.time.LocalDate;

>>>>>>> 2366bcbccde5adc67136a09fe77a3c649a14ba41
import dominio.Persona;
import dominio.Prospecto;
import dominio.DAO.BaseDatosMock;

public class ProspectoDAO {
	private BaseDatosMock bdMock;
	
	
    public void setBaseDatosMock(BaseDatosMock bdMock) {
        this.bdMock = bdMock;
    }
    public void crearProspecto(Prospecto prospecto) {
        bdMock.devolverProspecto().add(prospecto);
    }
        
	public void modificarProspecto(String dni,String nombres, String apellido_paterno, String apellido_materno, String telefono, String fechacontacto, String correo, String direccion, String distrito, String departamento){
		
		Prospecto prospecto = obtenerProspectoPorDni(dni);
		prospecto.setNombres(nombres);
		prospecto.setApellido_Paterno(apellido_paterno);
		prospecto.setApellido_Materno(apellido_materno);
		prospecto.setTelefono(telefono);
		prospecto.setFechaContacto(fechacontacto);
		prospecto.setCorreo(correo);
		prospecto.setDireccion(direccion);
		prospecto.setDistrito(distrito);
		prospecto.setDepartamento(departamento);
		
	}
    
    	
	public ArrayList<Prospecto> devolverListaBusquedaProspectoPorApellidos(String apellidos){
        
		ArrayList<Prospecto> resultadoBusquedaProspectos= new ArrayList<Prospecto>();
		
		for(int i = 0; i < devolverCantidadProspecto(); i++){            
        	Prospecto p = devolverProspecto().get(i);          
        
        	if(p.getApellido_Paterno().indexOf(apellidos) > -1){
        		resultadoBusquedaProspectos.add(p);
            }
        }		
		return resultadoBusquedaProspectos;
    }
    
	public void eliminarProspecto(String dni){
        for(int i = 0; i < devolverCantidadProspecto(); i++){            
        	Persona p = devolverProspecto().get(i);          
            if(p.getDni().equals(dni)){
                devolverProspecto().remove(i);
            }
        }
	}
    
		
	public Prospecto obtenerProspectoPorDni(String dni){
		Prospecto prospecto= null;
		for(int i = 0; i < devolverCantidadProspecto(); i++){    
			Prospecto p = devolverProspecto().get(i);            
            if(p.getDni().equals(dni)){
            	prospecto = p;
                break;
            }
		}
		return prospecto;
	
	}
	  
    
	public int devolverCantidadProspecto(){
        return devolverProspecto().size();
    }
    
	 public List<Prospecto> devolverProspecto() {
	        return bdMock.devolverProspecto();
	    }
    
	 public void limpiaListaProspecto() {
	        bdMock.devolverProspecto().clear();
	    }
    
    }

