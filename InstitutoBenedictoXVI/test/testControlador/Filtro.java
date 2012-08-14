package testControlador;

public class Filtro {
	
	private String codigo;
	private String valor;
	
	public Filtro(String codigo, String valor) {
		super();
		this.codigo = codigo;
		this.valor = valor;
	}	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}
