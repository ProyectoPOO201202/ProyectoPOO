package dominio.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controlador.Filtro;

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
    
    public List<Transaccion> devolverTransaccionFiltro(List<Filtro> filtro) {
    	
    	List<Transaccion> retorno;
    	List<Transaccion> filtrado;
    	Filtro contenedor;		
		String codigoFiltro;
		String valorFiltro;
		String valorColumna;
    	
    	retorno = bdMock.tablaTransaccion();
    	filtrado = bdMock.tablaFiltro();
                		
//		Transaccion transaccion = null;
		for(int i = 0; i < cantidadTransaccion(); i++)
		{    
			Transaccion m = retorno.get(i);			
			Iterator<Filtro> iterador = filtro.iterator();
			while (iterador.hasNext())
			{	
				contenedor = iterador.next();
				codigoFiltro = contenedor.getCodigo();
				valorFiltro = contenedor.getValor();
				if(codigoFiltro == "CONCEPTO")
				{
					valorColumna = m.getConcepto();
					if(valorColumna.indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}
				else if(codigoFiltro == "NUMERO")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}				
				else if(codigoFiltro == "EMPRESA")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}
				else if(codigoFiltro == "FECHAEMISION") 
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}else if(codigoFiltro == "SUBTOTAL")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}else if(codigoFiltro == "IGV")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}else if(codigoFiltro == "TOTAL")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}else if(codigoFiltro == "MONEDA")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}else if(codigoFiltro == "FECHAVENCIMIENTO")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}else if(codigoFiltro == "FECHAPAGO")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}else if(codigoFiltro == "OBSERVACIONES")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}else if(codigoFiltro == "TIPO")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}else if(codigoFiltro == "ESTADO")
				{					
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}
				else if(codigoFiltro == "NOMBREGRUPO")
				{
					if(m.getConcepto().indexOf(valorFiltro) > -1)
					{
						filtrado.add(m);
					}
				}				
			}            
		}	
		
		return filtrado; 
	}   
    
    public void limpiaListaTransaccion() {
        bdMock.tablaTransaccion().clear();
    }

}
