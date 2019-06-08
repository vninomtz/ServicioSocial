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
public class EleccionEstudiante {
    private Estudiante estudiante;
    private SolicitudProyecto solicitudProyecto;
    private LocalDate fecha;

    public EleccionEstudiante() {
    }
    
    
    public EleccionEstudiante(Estudiante estudiante, SolicitudProyecto solicitudProyecto, LocalDate fecha) {
        this.estudiante = estudiante;
        this.solicitudProyecto = solicitudProyecto;
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public SolicitudProyecto getSolicitudProyecto() {
        return solicitudProyecto;
    }

    public void setSolicitudProyecto(SolicitudProyecto solicitudProyecto) {
        this.solicitudProyecto = solicitudProyecto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
