package dominio;


public class Transaccion {
	
public enum Tipo {COMPRA,VENTA}
public enum Estado {NUEVO,ANULADA,CANCELADA}

public Transaccion(String concepto, int numero, String fechaEmision2,
			String empresa, double subtotal, double igv, double total,
			String moneda, String fechaVencimiento2, String fechaPago2,
			String observaciones, Tipo tipo, Estado estado) throws ParametroIncompleto {
	super();
	if (concepto.equals(""))
	{		
		throw new ParametroIncompleto("concepto");	
	}
	else if(String.valueOf(fechaEmision2).equals(""))
	{
		throw new ParametroIncompleto("fecha de emision");
	}
	else if(String.valueOf(fechaVencimiento2).equals(""))
	{
		throw new ParametroIncompleto("empresa");
	}	
	else if(String.valueOf(subtotal).equals(""))
	{
		throw new ParametroIncompleto("sub total");
	}
	else if(String.valueOf(igv).equals(""))
	{
		throw new ParametroIncompleto("igv");
	}
	else if(String.valueOf(total).equals(""))
	{
		throw new ParametroIncompleto("total");
	}
	else if(moneda.equals(""))
	{
		throw new ParametroIncompleto("moneda");
	}
	
		this.concepto = concepto;
		this.numero = numero;
		this.empresa = empresa;
		this.fechaEmision = fechaEmision2;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
		this.moneda = moneda;
		this.fechaVencimiento = fechaVencimiento2;
		this.fechaPago = fechaPago2;
		this.observaciones = observaciones;
		this.tipo = tipo;
		this.estado = estado;
		
	}
	
	private String concepto;	
	private int numero;
	private String empresa;
	private String fechaEmision;	
	private double subtotal;
	private double igv;
	private double total;
	private String moneda;
	private String fechaVencimiento;
	private String fechaPago;
	private String observaciones;
	private Tipo tipo;	
	private Estado estado;	
	
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
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
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
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}








    