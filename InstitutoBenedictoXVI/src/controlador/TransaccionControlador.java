package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.csvreader.CsvReader;

import dominio.Transaccion;
import dominio.DAO.DataBase;
import dominio.DAO.TransaccionDAO;
import dominio.ParametroIncompleto;
import dominio.Transaccion.Estado;
import dominio.Transaccion.Tipo;

public class TransaccionControlador {
	
private TransaccionDAO transaccionDAO = new TransaccionDAO();
	
	public Transaccion registrarTransaccion(String concepto, String numero, String fechaEmision,
			String empresa, String subtotal, String igv, String total,
			String moneda, String fechaVencimiento, String fechaPago,
			String observaciones, String tipo, String estado) throws ParametroIncompleto
		{
		int numero1 = Integer.parseInt(numero);		
		double subtotal1 = Double.parseDouble(subtotal);
		double igv1 = Double.parseDouble(igv);
		double total1 = Double.parseDouble(total);
		Tipo tipo1 = Tipo.valueOf(tipo); 
		Estado estado1 = Estado.valueOf(estado);
		
		Transaccion rol = new Transaccion(concepto, numero1, fechaEmision, empresa, subtotal1, igv1,  total1, moneda,  fechaVencimiento,  fechaPago, observaciones,  tipo1,  estado1);
		transaccionDAO.crearTransaccion(rol);
		return rol;
	}
	
	 public Transaccion modificarTransaccion(String concepto, int numero, String fechaEmision,
				String empresa, double subtotal, double igv, double total,
				String moneda, String fechaVencimiento, String fechaPago,
				String observaciones, Tipo tipo, Estado estado)
	 {
	    	Transaccion encontrado = busquedaTransaccionConcepto(concepto);
	    	encontrado.setNumero(numero);
	    	encontrado.setFechaEmision(fechaEmision);
	    	encontrado.setEmpresa(empresa);
	    	encontrado.setSubtotal(subtotal);
	    	encontrado.setIgv(igv);
	    	encontrado.setTotal(total);
	    	encontrado.setMoneda(moneda);
	    	encontrado.setFechaVencimiento(fechaVencimiento);
	    	encontrado.setFechaPago(fechaPago);
	    	encontrado.setObservaciones(observaciones);
	    	encontrado.setTipo(tipo);
	    	encontrado.setEstado(estado);
			return encontrado;
		}
	    
	
	public void importarTransaccion(String nombreArchivo) throws ParametroIncompleto{		
		try {			
			CsvReader transaccion = new CsvReader(nombreArchivo);		
			transaccion.readHeaders();
			while (transaccion.readRecord()){
				String concepto = transaccion.get(0);
				String numero = transaccion.get(1);				
				String fechaEmision = transaccion.get(2);		
				String empresa = transaccion.get(3);
				String subtotal  = transaccion.get(4);
				String igv  = transaccion.get(5);
				String total  = transaccion.get(6);
				String moneda  = transaccion.get(7);
				String fechaVencimiento  = transaccion.get(8);
				String fechaPago  = transaccion.get(9);
				String observaciones  = transaccion.get(10);
				String tipo  = transaccion.get(11);
				String estado  = transaccion.get(12);
				 
				registrarTransaccion(concepto, numero, fechaEmision, empresa, subtotal, igv,  total, moneda,  fechaVencimiento,  fechaPago, observaciones,  tipo,  estado);
			}
	
			transaccion.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public Transaccion busquedaTransaccionConcepto(String concepto)
	{
		Transaccion retorno;
		retorno = transaccionDAO.obtenerTransaccionPorConcepto(concepto);
		return retorno;		
	}
	
	public List<Transaccion> busquedaTransaccionDescripcion(String descripcion)
	{
		List<Transaccion> listaTransaccion;
		listaTransaccion = transaccionDAO.devolverListaBusquedaTransaccionDescripcion(descripcion);
		return listaTransaccion;		
	}

	public List<Transaccion> devolverListaTransaccion()
	{
	    return transaccionDAO.devolverTransaccion();
	}
	
	public int cantidadTransaccion(){
        return transaccionDAO.cantidadTransaccion();
    }
	
	public void setDataBase(DataBase bdMock) {
        this.transaccionDAO.setBaseDatosMock(bdMock);
    }
	
	public void limpiaListaTransaccion() {
		this.transaccionDAO.limpiaListaTransaccion();
    }	

	public boolean eliminarTransaccion(String codigo) {
		
		boolean resultado = false;
		try {		
			transaccionDAO.eliminarTransaccion(codigo);
			resultado = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
		return resultado;
	}
	
	public enum TFiltro{CONCEPTO,NUMERO,EMPRESA,FECHAEMISION,SUBTOTAL,IGV,TOTAL,MONEDA,FECHAVENCIMIENTO,FECHAPAGO,OBSERVACIONES,TIPO,ESTADO,NOMBREGRUPO}
	private List<Filtro> filtro = new ArrayList<Filtro>();

	public boolean addFiltro(TFiltro tipoFiltro, String valor)
	{
		Filtro cargador = new Filtro(tipoFiltro.toString(),valor);
		filtro.add(cargador);
		return true;		
	}

	public int listaFiltro()
	{
		Filtro contenedor;
		int contador = 0;
		Iterator<Filtro> iterador = filtro.iterator();
		while (iterador.hasNext())
		{	
			contenedor = iterador.next();
			System.out.println(contenedor.getCodigo() + " " + contenedor.getValor() );
			contador++;
		}
		return contador;
	}
	
	public List<Transaccion> devolverListaTransaccionFiltro()
	{
		Filtro contenedor;		
		String codigoFiltro;
		String valorFiltro;
		String valorColumna;
		
		List<Transaccion> retorno;
		List<Transaccion> filtrado = null;
		retorno = transaccionDAO.devolverTransaccion();
		
		Transaccion transaccion = null;
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


}
