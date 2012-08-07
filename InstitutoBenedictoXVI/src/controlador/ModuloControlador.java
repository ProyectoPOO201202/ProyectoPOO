package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.csvreader.CsvReader;

import dominio.*;
import dominio.DAO.DataBase;
import dominio.DAO.ModuloDAO;

public class ModuloControlador {

	
private ModuloDAO moduloDAO = new ModuloDAO();
	
	public Modulo registrarModulo(String codigo, String descripcion){
		Modulo modulo = new Modulo(codigo, descripcion);		
		moduloDAO.crearModulo(modulo);
		return modulo;
	}
	
public void importarModulo(String nombreArchivo){
		
		try {
			
			CsvReader modulo = new CsvReader(nombreArchivo);
		
			modulo.readHeaders();

			while (modulo.readRecord()){
			
				String codigo = modulo.get(0);				
				String descripcion = modulo.get(1);				
								
			
				registrarModulo(codigo, descripcion);
			}
	
			modulo.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Modulo> devolverListaModulo()
	{
	    return moduloDAO.devolverModulo();
	}
	
	public int cantidadEmpresas(){
        return moduloDAO.cantidadModulo();
    }
	
	public void setDataBase(DataBase bdMock) {
        this.moduloDAO.setBaseDatosMock(bdMock);
    }
	
	public void limpiaListaEmpresa() {
		this.moduloDAO.limpiaListaEmpresa();
    }

}
