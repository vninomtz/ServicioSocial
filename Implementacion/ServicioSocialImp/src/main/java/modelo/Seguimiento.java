/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vik-t
 */
public class Seguimiento {
    private int idSeguimiento;
    private double calificacion;
    private int horasAcumuladas;
    private List<Documento> listaDocumentos = new ArrayList();
    private List<ReporteMensual> listaReportesMensuales = new ArrayList();
    private RegistroPlanActividades registroPlanAct = new RegistroPlanActividades();
    private SolicitudProyecto solicitudProyecto = new SolicitudProyecto();

    public Seguimiento() {
    }

    public Seguimiento(int idSeguimiento, double calificacion, int horasAcumuladas,
            List<Documento> listaDocumentos,List<ReporteMensual> listaReportesMensuales,
            RegistroPlanActividades registroPlanAct, SolicitudProyecto solicitudProyecto) {
        this.idSeguimiento = idSeguimiento;
        this.calificacion = calificacion;
        this.horasAcumuladas = horasAcumuladas;
        this.listaDocumentos = listaDocumentos;
        this.listaReportesMensuales = listaReportesMensuales;
        this.solicitudProyecto = solicitudProyecto;
    }
    

    public int getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getHorasAcumuladas() {
        return horasAcumuladas;
    }

    public void setHorasAcumuladas(int horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }

    public List<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public List<ReporteMensual> getListaReportesMensuales() {
        return listaReportesMensuales;
    }

    public void setListaReportesMensuales(List<ReporteMensual> listaReportesMensuales) {
        this.listaReportesMensuales = listaReportesMensuales;
    }

    public RegistroPlanActividades getRegistroPlanAct() {
        return registroPlanAct;
    }

    public void setRegistroPlanAct(RegistroPlanActividades registroPlanAct) {
        this.registroPlanAct = registroPlanAct;
    }

    public SolicitudProyecto getSolicitudProyecto() {
        return solicitudProyecto;
    }

    public void setSolicitudProyecto(SolicitudProyecto solicitudProyecto) {
        this.solicitudProyecto = solicitudProyecto;
    }

    
    
    
}
