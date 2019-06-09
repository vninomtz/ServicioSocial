/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Vik-t
 */
public class ReporteMensual {

    private String estado;
    private int horasReportadas;
    private String link;
    private String mes;
    private String nombre;
    private int numeroReporte;
    private int idSeguimiento;
    private int idReporteMensual;

    public ReporteMensual() {
    }

    public ReporteMensual(String estado, int horasReportadas, String link, String mes, String nombre, int numeroReporte, int idSeguimiento, 
            int idReporteMensual) {
        this.estado = estado;
        this.horasReportadas = horasReportadas;
        this.link = link;
        this.mes = mes;
        this.nombre = nombre;
        this.numeroReporte = numeroReporte;
        this.idSeguimiento = idSeguimiento;
        this.idReporteMensual = idReporteMensual;
    }

    public int getIdReporteMensual() {
        return idReporteMensual;
    }

    public void setIdReporteMensual(int idReporteMensual) {
        this.idReporteMensual = idReporteMensual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getHorasReportadas() {
        return horasReportadas;
    }

    public void setHorasReportadas(int horasReportadas) {
        this.horasReportadas = horasReportadas;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroReporte() {
        return numeroReporte;
    }

    public void setNumeroReporte(int numeroReporte) {
        this.numeroReporte = numeroReporte;
    }

    public int getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

}
