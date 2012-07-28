package controlador;

import dominio.Empresa;


public class EmpresaControlador {	
	
	public static Empresa registrarEmpresa(String codigo, String razon_social, Empresa.Rubro rubro, String direccion, String correo, String telefono, String ciudad, 
    		String pais, Empresa.Estado estado, String observaciones){
		Empresa proveedor = new Empresa(codigo, razon_social, rubro, direccion, correo, telefono, ciudad, pais, estado, observaciones);		
		return proveedor;
	}

}
