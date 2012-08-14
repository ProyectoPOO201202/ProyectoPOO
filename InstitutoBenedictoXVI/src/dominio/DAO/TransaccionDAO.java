package dominio.DAO;

import java.util.ArrayList;
import java.util.List;

import dominio.Transaccion;
import dominio.Transaccion.Estado;
import dominio.Transaccion.Tipo;

public class TransaccionDAO {
	
	private DataBase bdMock;

    public void setBaseDatosMock(DataBase bdMock) {
        this.bdMock = bdMock;
    }

    public void crearTransaccion(Transaccion transaccion) {
        bdMock.tablaTransaccion().add(transaccion);
    }
    
    public void modificarTransaccion(String concepto, int numero, String fechaEmision,
			String empresa, double subtotal, double igv, double total,
			String moneda, String fechaVencimiento, String fechaPago,
			String observaciones, Tipo tipo, Estado estado){
    	
    	Transaccion transaccion = obtenerTransaccionPorConcepto(concepto);
    	transaccion.setNumero(numero);
    	transaccion.setFechaEmision(fechaEmision);
    	transaccion.setEmpresa(empresa);
    	transaccion.setSubtotal(subtotal);
    	transaccion.setIgv(igv);
    	transaccion.setTotal(total);
    	transaccion.setMoneda(moneda);
    	transaccion.setFechaVencimiento(fechaVencimiento);
    	transaccion.setFechaPago(fechaPago);
    	transaccion.setObservaciones(observaciones);
    	transaccion.setTipo(tipo);
    	transaccion.setEstado(estado);
		
	}
    
	public ArrayList<Transaccion> devolverListaBusquedaTransaccionDescripcion(String descripcion){
        
		ArrayList<Transaccion> resultadoBusquedaTransaccion = new ArrayList<Transaccion>();
		for(int i = 0; i < cantidadTransaccion(); i++)
		{            
			Transaccion m = devolverTransaccion().get(i);          
            if(m.getEmpresa().indexOf(descripcion) > -1)
            {
            	resultadoBusquedaTransaccion.add(m);
            }
        }		
		return resultadoBusquedaTransaccion;
    }
    
	public void eliminarTransaccion(String concepto){
        for(int i = 0; i < cantidadTransaccion(); i++)
        {            
        	Transaccion m = devolverTransaccion().get(i);          
            if(m.getConcepto().equals(concepto))
            {
                devolverTransaccion().remove(i);
            }
        }
	}
    
	public Transaccion obtenerTransaccionPorConcepto(String concepto){
		Transaccion transaccion = null;
		for(int i = 0; i < cantidadTransaccion(); i++)
		{    
			Transaccion m = devolverTransaccion().get(i);            
            if(m.getConcepto().equals(concepto))
            {
            	transaccion = m;
                break;
            }
		}
		return transaccion;
	}
	
	public int cantidadTransaccion(){
        return devolverTransaccion().size();
    }

    public List<Transaccion> devolverTransaccion() {
        return bdMock.tablaTransaccion();
    }
    
    public void limpiaListaTransaccion() {
        bdMock.tablaTransaccion().clear();
    }

}
