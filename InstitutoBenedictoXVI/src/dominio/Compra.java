

package dominio;

import org.joda.time.LocalDate;


public class Compra {
public enum Estado {NUEVO, ANULADA, CANCELADA}	
	
	private String concepto;	
	private int numero;
	private LocalDate fechaEmision;
	private String empresa;
	private double subtotal;
	private double igv;
	private double total;
	private String moneda;
	private LocalDate fechaVencimiento;
	private LocalDate fechaPago;
	private Estado estado;
	private String observaciones;
	
		
	public Compra(String concepto, int numero, LocalDate fechaEmision,
			String empresa, double subtotal, double igv, double total,
			String moneda, LocalDate fechaVencimiento, LocalDate fechaPago,
			Estado estado, String observaciones) {
		super();
		this.concepto = concepto;
		this.numero = numero;
		this.fechaEmision = fechaEmision;
		this.empresa = empresa;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
		this.moneda = moneda;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaPago = fechaPago;
		this.estado = estado;
		this.observaciones = observaciones;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public LocalDate getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getIgv() {
		return igv;
	}
	public void setIgv(double igv) {
		this.igv = igv;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}








    