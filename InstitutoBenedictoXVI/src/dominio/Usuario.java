package dominio;

import org.joda.time.LocalDate;

public class Usuario {

	private String correo;
	private String clave;
	private boolean flagTerminosLegales;
	private LocalDate fechaRegistro;
	private TipoCuenta tipoCuenta;
	private Academia academia;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo){
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isFlagTerminosLegales() {
		return flagTerminosLegales;
	}

	public void setFlagTerminosLegales(boolean flagTerminosLegales) {
		this.flagTerminosLegales = flagTerminosLegales;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Academia getAcademia() {
		return academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
}