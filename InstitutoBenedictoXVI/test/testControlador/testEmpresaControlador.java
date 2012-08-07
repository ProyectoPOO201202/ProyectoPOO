package testControlador;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	@Test
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
	
	
}
