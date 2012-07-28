package dominio;

public class Moneda {

    private String simbolo;
    private String descripcion;
    
	public Moneda() {
    }
	
	public Moneda(String simbolo, String descripcion) {
        this.simbolo = simbolo;
        this.descripcion = descripcion;
    }
    
	public String getSimbolo() {
		return simbolo;
	}
	
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
