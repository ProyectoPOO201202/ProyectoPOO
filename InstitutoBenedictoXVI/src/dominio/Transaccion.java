package dominio;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Filter;

import org.joda.time.LocalDate;


public class Transaccion {
	
public enum Tipo {COMPRA,VENTA}
public enum Estado {NUEVO,ANULADA,CANCELADA}	
public enum TFiltro{CONCEPTO,NUMERO,EMPRESA,FECHAEMISION,SUBTOTAL,IGV,TOTAL,MONEDA,FECHAVENCIMIENTO,FECHAPAGO,OBSERVACIONES,TIPO,ESTADO}

public Transaccion(String concepto, int numero, LocalDate fechaEmision,
			String empresa, double subtotal, double igv, double total,
			String moneda, LocalDate fechaVencimiento, LocalDate fechaPago,
			String observaciones, Tipo tipo, Estado estado) throws ParametroIncompleto {
	super();
	if (concepto.equals(""))
	{		
		throw new ParametroIncompleto("concepto");	
	}
	else if(String.valueOf(fechaEmision).equals(""))
	{
		throw new ParametroIncompleto("fecha de emision");
	}
	else if(String.valueOf(fechaVencimiento).equals(""))
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
		this.fechaEmision = fechaEmision;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
		this.moneda = moneda;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaPago = fechaPago;
		this.observaciones = observaciones;
		this.tipo = tipo;
		this.estado = estado;
		
	}
	
	private String concepto;	
	private int numero;
	private String empresa;
	private LocalDate fechaEmision;	
	private double subtotal;
	private double igv;
	private double total;
	private String moneda;
	private LocalDate fechaVencimiento;
	private LocalDate fechaPago;
	private String observaciones;
	private Tipo tipo;	
	private Estado estado;
	
	private List<Filtro> filtro = new ArrayList<Filter>();
	
	public boolean addFiltro(TFiltro tipoFiltro, String valor)
	{
		Filtro cargador = new File(tipoFiltro.toString(),valor);
		filtro.add(cargador);
		return true;		
	}
	
	public int listaFiltro()
	{
		Filtro contenedor;
		int contador = 0;
		Iterator<Filtro> iterador = filtro.iterator();
		while (iterador.hasNext())
		{	
			contenedor = iterador.next();
			System.out.println(contenedor.getCodigo() + " " + contenedor.getValor() );
			contador++;
		}
		return contador;
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








    