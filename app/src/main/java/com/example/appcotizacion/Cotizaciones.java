package com.example.appcotizacion;

import java.text.DecimalFormat;

public class Cotizaciones {
    private int idCotizacion;
    private String descripcionAuto;
    private float precio;
    private int porcentajePInicial;
    private int plazo;

    //Constructor Vacío
    public Cotizaciones(){

    }
    //Constructor de Parametros
    public Cotizaciones(int idCotizacion, String descripcionAuto, float precio, int porcentajePInicial, int plazo){
        this.idCotizacion = idCotizacion;
        this.descripcionAuto = descripcionAuto;
        this.precio = precio;
        this.porcentajePInicial = porcentajePInicial;
        this.plazo = plazo;
    }
    //Constructor de Copia
    public Cotizaciones(Cotizaciones cotizaciones){
        this.idCotizacion = cotizaciones.idCotizacion;
        this.descripcionAuto = cotizaciones.descripcionAuto;
        this.precio = cotizaciones.precio;
        this.porcentajePInicial = cotizaciones.porcentajePInicial;
        this.plazo = cotizaciones.plazo;
    }

    //Encapsulamiento
    public int getIdCotizacion() {
        return idCotizacion;
    }
    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }
    public String getDescripcionAuto() {
        return descripcionAuto;
    }
    public void setDescripcionAuto(String descripcionAuto) {
        this.descripcionAuto = descripcionAuto;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public int getPorcentajePInicial() {
        return porcentajePInicial;
    }
    public void setPorcentajePInicial(int porcentajePInicial) {
        this.porcentajePInicial = porcentajePInicial;
    }
    public int getPlazo() {
        return plazo;
    }
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    //Metodos de Accion
    public float calcularPagoInicial(){
        float pagoInicial = (precio*(porcentajePInicial/100.00f));
        return pagoInicial;
    }

    public double calcularTotalFin(){
        double totalFin = precio-calcularPagoInicial();
        return totalFin;
    }

    public double calcularPagoMensual(){
        double pagoMensual = calcularTotalFin()/this.plazo;
        return pagoMensual;
    }

    public String imprimirCotizacion(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "\t--Datos de la Cotización--\n\nNum Cotizacion: "+this.idCotizacion+"\nDescripcion: "+this.descripcionAuto+"\nPorcentaje pago Inicial: "+this.porcentajePInicial+"\nPlazo: "+this.plazo+"\nPrecio: "+df.format(this.precio)+"\n\n\tPago Inicial: "+df.format(calcularPagoInicial())+"\n\tTotal a Financiar: "+df.format(calcularTotalFin())+"\n\tPago Mensual: "+df.format(calcularPagoMensual());

    }
}