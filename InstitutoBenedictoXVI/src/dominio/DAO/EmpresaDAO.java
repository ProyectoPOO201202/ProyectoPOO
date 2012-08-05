package dominio.DAO;

import java.util.ArrayList;
import java.util.List;

import dominio.Empresa;
import dominio.Empresa.Estado;
import dominio.Empresa.Rubro;

public class EmpresaDAO {
    private DataBase bdMock;

    public void setBaseDatosMock(DataBase bdMock) {
        this.bdMock = bdMock;
    }

    public void crearEmpresa(Empresa empresa) {
        bdMock.tablaEmpresa().add(empresa);
    }
    
    public void modificarEmpresa(String codigo, String razon_social, Rubro rubro,
			String direccion, String correo, String telefono, String ciudad,
			String pais, Estado estado, String observaciones){
    	
    	Empresa empresa = obtenerEmpresaPorCodigo(codigo);
		empresa.setRazon_social(razon_social);
		empresa.setRubro(rubro);
		empresa.setDireccion(direccion);
		empresa.setCorreo(correo);
		empresa.setTelefono(telefono);
		empresa.setCiudad(ciudad);		
		empresa.setPais(pais);
		empresa.setEstado(estado);
		empresa.setObservaciones(observaciones);	
		
	}
    
	public ArrayList<Empresa> devolverListaBusquedaEmpresasPorRazonSocial(String razonSocial){
        
		ArrayList<Empresa> resultadoBusquedaEmpresas = new ArrayList<Empresa>();
		for(int i = 0; i < devolverCantidadEmpresas(); i++){            
			Empresa e = devolverEmpresas().get(i);          
            if(e.getRazon_social().indexOf(razonSocial) > -1){
            	resultadoBusquedaEmpresas.add(e);
            }
        }		
		return resultadoBusquedaEmpresas;
    }
    
	public void eliminarEmpresa(String codigo){
        for(int i = 0; i < devolverCantidadEmpresas(); i++){            
        	Empresa e = devolverEmpresas().get(i);          
            if(e.getCodigo().equals(codigo)){
                devolverEmpresas().remove(i);
            }
        }
	}
    
	public Empresa obtenerEmpresaPorCodigo(String codigo){
		Empresa empresa = null;
		for(int i = 0; i < devolverCantidadEmpresas(); i++){    
			Empresa e = devolverEmpresas().get(i);            
            if(e.getCodigo().equals(codigo)){
            	empresa = e;
                break;
            }
		}
		return empresa;
	}
	
	public int devolverCantidadEmpresas(){
        return devolverEmpresas().size();
    }

    public List<Empresa> devolverEmpresas() {
        return bdMock.tablaEmpresa();
    }
    
    public void limpiaListaEmpresa() {
        bdMock.tablaEmpresa().clear();
    }
}