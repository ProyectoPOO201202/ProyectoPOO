package testControlador;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.csvreader.CsvReader;

import controlador.EmpresaControlador;
import dominio.Empresa;
import dominio.DAO.DataBase;


public class testEmpresaControlador {

	private DataBase bdMock;
	private EmpresaControlador proveedorControlador;
	private List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	
	@Before
    public void setUp() throws Exception 
    {		
		proveedorControlador = new EmpresaControlador();
		bdMock  = mock(DataBase.class);
		proveedorControlador.setDataBase(bdMock);
	    doReturn(listaEmpresas).when(bdMock).tablaEmpresa();
		for(int i=10001; i<=10015; i++)
		{
			proveedorControlador.registrarEmpresa("205498" + i, "RZ " + i, "Pesquera", "Direccion " + i ,"contacto@rz" + i + ".com.pe" , "61" + i, "Lima", "Peru", "Activo", "");			
		}	
		
	}
	
	//@Test
	public void testListarEmpresasRegistradas(){
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		empresas = proveedorControlador.devolverListaEmpresas();
		for(Empresa empresa : empresas){
			System.out.println(empresa.getCodigo() + " " + empresa.getRazon_social());
		}
		System.out.println("Total Empresas registradas : " + proveedorControlador.devolverListaEmpresas());
		assertEquals(15, proveedorControlador.cantidadEmpresas());
	}
	
	//@Test
	public void testImportarEmpresa(){
		
		proveedorControlador.limpiaListaEmpresa();
		proveedorControlador.importarEmpresas("test/csv/empresa_import.csv");
		
		try {
					
			List<Empresa> proveedor = new ArrayList<Empresa>();
			proveedor = proveedorControlador.devolverListaEmpresas();
			
			int contador = 0;
			
			CsvReader proveedor2 = new CsvReader("test/csv/empresa_import.csv");	
			proveedor2.readHeaders();
			
			while (proveedor2.readRecord()){	
				
				assertEquals(proveedor.get(contador).getCodigo(), proveedor2.get(0));
				assertEquals(proveedor.get(contador).getRazon_social(), proveedor2.get(1));
				assertEquals(proveedor.get(contador).getRubro(), proveedor2.get(2));
				assertEquals(proveedor.get(contador).getDireccion(), proveedor2.get(3));				
				assertEquals(proveedor.get(contador).getCorreo(), proveedor2.get(4));
				assertEquals(proveedor.get(contador).getTelefono(), proveedor2.get(5));
				assertEquals(proveedor.get(contador).getCiudad(), proveedor2.get(6));				
				assertEquals(proveedor.get(contador).getPais(), proveedor2.get(7));
				assertEquals(proveedor.get(contador).getEstado(), proveedor2.get(8));		
				assertEquals(proveedor.get(contador).getObservaciones(), proveedor2.get(9));						
				contador++;
			}	
			proveedor2.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//@Test
	public void testModificarEmpresa(){
		
		try {
			Empresa retorno;
			proveedorControlador.limpiaListaEmpresa();
			proveedorControlador.importarEmpresas("test/csv/empresa_import.csv");					
			//Registro Original
			//20549810009	RZ20549810009	PESQUERA	Direccion Empresa 10007	contacto@RZ20549810009.com.pe	6188007	Lima	Peru
			retorno = proveedorControlador.modificarEmpresa("20549810006", "Inversiones America","PESQUERA","Direccion Empresa 10007","contacto@RZ20549810009.com.pe","6188007","Chiclayo","Peru","Inactivo","");
			Assert.assertEquals("Inversiones America", retorno.getRazon_social());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//@Test
	public void testEliminarEmpresaOk(){
		int cantidadInicial = 0;
		int cantidadFinal = 0;
		try {
			proveedorControlador.limpiaListaEmpresa();
			proveedorControlador.importarEmpresas("test/csv/empresa_import.csv");		
			cantidadInicial = proveedorControlador.cantidadEmpresas();
			proveedorControlador.eliminarEmpresa("20549810006");
			cantidadInicial = cantidadInicial - 1;
			cantidadFinal = proveedorControlador.cantidadEmpresas();
			Assert.assertEquals("Cantidad Correcta",cantidadInicial, cantidadFinal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//@Test
	public void testEliminarEmpresaKo(){
		int cantidadInicial = 0;
		int cantidadFinal = 0;
		try {
			proveedorControlador.limpiaListaEmpresa();
			proveedorControlador.importarEmpresas("test/csv/empresa_import.csv");		
			cantidadInicial = proveedorControlador.cantidadEmpresas();
			proveedorControlador.eliminarEmpresa("20549810006");
			cantidadInicial = cantidadInicial - 2;
			cantidadFinal = proveedorControlador.cantidadEmpresas();
			Assert.assertEquals("Cantidad Correcta",cantidadInicial, cantidadFinal);
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testBusquedaEmpresa(){
			Empresa prueba;
		try {
			proveedorControlador.limpiaListaEmpresa();
			proveedorControlador.importarEmpresas("test/csv/empresa_import.csv");		
			prueba = proveedorControlador.buscaEmpresaPorCodigo("20549810006");			
			Assert.assertEquals("contacto@RZ20549810006.com.pe", prueba.getCorreo());	
			Assert.assertEquals("20549810006",prueba.getCodigo());
			Assert.assertEquals("RZ20549810006",prueba.getRazon_social());
			Assert.assertEquals("RETAIL",prueba.getRubro());
			Assert.assertEquals("Direccion Empresa 10004",prueba.getDireccion());
			Assert.assertEquals("contacto@RZ20549810006.com.pe",prueba.getCorreo());
			Assert.assertEquals("6188004",prueba.getTelefono());
			Assert.assertEquals("Lima",prueba.getCiudad());
			Assert.assertEquals("Peru",prueba.getPais());
			Assert.assertEquals("Activo",prueba.getEstado());			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
}
