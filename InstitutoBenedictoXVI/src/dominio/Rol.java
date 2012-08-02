package dominio;

public class Rol {
	
	private String codrol;
	private String nombrerol;

	public Rol(String codrol, String nombrerol) {
		// TODO Auto-generated constructor stub
		this.codrol = codrol;
		this.nombrerol = nombrerol;
		
	}
	
	public String getcodrol(){
		return codrol;
	}
	
	public void Setcodrol(){
		this.codrol = codrol;
	}
	
	public String getnombrerol(){
		return nombrerol;
	}
	
	public void Setnombrerol(){
		this.nombrerol = nombrerol;
	}

}
