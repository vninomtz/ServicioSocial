/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Vik-t
 */
public class Inscripcion {
    private int folioInscripcion;
    private String tipoInscripcion;
    private LocalDate fechaInscripcion;
    private Estudiante estudiante = new Estudiante();
    private ServicioSocial servicioSocial = new ServicioSocial();
    private Seguimiento seguimiento = new Seguimiento();

    public Inscripcion() {
    }

    public Inscripcion(int folioInscripcion, String tipoInscripcion, LocalDate fechaInscripcion, Estudiante estudiante, ServicioSocial servicioSocial, Seguimiento seguimiento) {
        this.folioInscripcion = folioInscripcion;
        this.tipoInscripcion = tipoInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.estudiante = estudiante;
        this.servicioSocial = servicioSocial;
        this.seguimiento = seguimiento;
    }

    public int getFolioInscripcion() {
        return folioInscripcion;
    }

    public void setFolioInscripcion(int folioInscripcion) {
        this.folioInscripcion = folioInscripcion;
    }

    public String getTipoInscripcion() {
        return tipoInscripcion;
    }

    public void setTipoInscripcion(String tipoInscripcion) {
        this.tipoInscripcion = tipoInscripcion;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ServicioSocial getServicioSocial() {
        return servicioSocial;
    }

    public void setServicioSocial(ServicioSocial servicioSocial) {
        this.servicioSocial = servicioSocial;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }
    
    
}
