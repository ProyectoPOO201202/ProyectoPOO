package dominio;

//import java.math.BigDecimal;

public class Rol {
	
	private String codigo;
	private String descripcion;
	private String creado_por;
	private String creado_el;
	private String actualizado_por;
	private String actualizado_el;
	
	
	public void crearRol(String codigo, String descripcion, String creado_por,
			String creado_el) {		
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.creado_por = creado_por;
		this.creado_el = creado_el;
	}
	
	public void modificarRol(String codigo, String descripcion, String actualizado_por,
			String actualizado_el) {
		
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.actualizado_por = actualizado_por;
		this.actualizado_el = actualizado_el;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCreado_por() {
		return creado_por;
	}

	public void setCreado_por(String creado_por) {
		this.creado_por = creado_por;
	}

	public String getCreado_el() {
		return creado_el;
	}

	public void setCreado_el(String creado_el) {
		this.creado_el = creado_el;
	}

	public String getActualizado_por() {
		return actualizado_por;
	}

	public void setActualizado_por(String actualizado_por) {
		this.actualizado_por = actualizado_por;
	}

	public String getActualizado_el() {
		return actualizado_el;
	}

	public void setActualizado_el(String actualizado_el) {
		this.actualizado_el = actualizado_el;
	}

	public String getCodigo1() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Object getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getnombrerol() {
		// TODO Auto-generated method stub
		return null;
	}	

}
