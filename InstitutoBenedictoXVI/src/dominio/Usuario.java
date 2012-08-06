package dominio;

import java.util.Locale;

import org.joda.time.LocalDate;


@SuppressWarnings("unused")
public class Usuario {
	
	private String correo;
	private String clave;
	private boolean flagTerminosLeg;
	private LocalDate fechaRegistro;
	private TipoCuenta tipoCuenta;
	private Instituto instituto;

	public String getCorreo() {
		// TODO Auto-generated method stub
		return correo;
	}
	public String setCorreo(String correo) {
		return this.correo = correo;
		
	}

	public String getClave() {
		// TODO Auto-generated method stub
		return clave;
	}

	public void setClave(String clave) {
		// TODO Auto-generated method stub
		this.clave = clave;
		
	}

	public boolean isflagTerminosLeg() {
		return flagTerminosLeg;
	}
	
	public void setFlagTerminosLeg(boolean flagTerminosLeg) {
		this.flagTerminosLeg = flagTerminosLeg;
		// TODO Auto-generated method stub
		
	}

	public LocalDate getFechaRegistro(){
		return fechaRegistro;
		
	}

	public void setFechaRegistro(LocalDate fechaRegistro){
		this.fechaRegistro = fechaRegistro;
	}

	

	public TipoCuenta getTipoCuenta() {
		// TODO Auto-generated method stub
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipocuenta) {
		// TODO Auto-generated method stub
		this.tipoCuenta = tipocuenta;
		
	}

	
	public Instituto getInstituto() {
		// TODO Auto-generated method stub
		return instituto;
	}
	
	public void setInstituto(Instituto instituto){
		this.instituto = instituto;
	}

	


}
