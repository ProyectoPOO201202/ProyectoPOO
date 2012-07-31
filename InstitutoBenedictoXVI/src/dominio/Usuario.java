package dominio;

import java.util.Locale;

import org.joda.time.LocalDate;


public class Usuario {
	
	private String correo;
	private String clave;
	private boolean flagTerminosLeg;
	private LocalDate fechaRegistro;
	private TipoCuenta tipoCuenta;
	private Instituto instituto;

	public void setCorreo(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setClave(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setFlagTerminosLeg(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setInstituto(Instituto instituto) {
		// TODO Auto-generated method stub
		
	}

	public Object getCorreo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getClave() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFlagTerminosLeg1(boolean flagTerminosLeg) {
	}

	public Object getTipoCuenta() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getFechaRegistro() {
		// TODO Auto-generated method stub
		return null;
	}

	public Instituto getInstituto() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTipoCuenta(TipoCuenta tipocuenta) {
		// TODO Auto-generated method stub
		
	}

	public Object isFlagterminoLeg() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFechaRegistro(Locale fechaRegistro) {
	}

	public void setFechaRegistro(LocalDate fechaActual) {
		// TODO Auto-generated method stub
		
	}

	public boolean isFlagTerminosLegales() {
		return flagTerminosLeg;
	}

	public void setFlagTerminosLeg11(boolean flagTerminosLeg) {
		this.flagTerminosLeg = flagTerminosLeg;
	}

	public Object isFlagTerminosLeg() {
		// TODO Auto-generated method stub
		return null;
	}

}
