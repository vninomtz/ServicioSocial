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
public class SolicitudProyecto {
    private int idSolicitudProyecto;
    private String actividad;
    private String horario;
    private String lugar;
    private int numeroEstudiantes;
    private String requisitos;
    private String tipo;

    public SolicitudProyecto() {
    }

    public SolicitudProyecto(int idSolicitudProyecto, String actividad, String horario, String lugar, int numeroEstudiantes, String requisitos, String tipo) {
        this.idSolicitudProyecto = idSolicitudProyecto;
        this.actividad = actividad;
        this.horario = horario;
        this.lugar = lugar;
        this.numeroEstudiantes = numeroEstudiantes;
        this.requisitos = requisitos;
        this.tipo = tipo;
    }

    public int getIdSolicitudProyecto() {
        return idSolicitudProyecto;
    }

    public void setIdSolicitudProyecto(int idSolicitudProyecto) {
        this.idSolicitudProyecto = idSolicitudProyecto;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getNumeroEstudiantes() {
        return numeroEstudiantes;
    }

    public void setNumeroEstudiantes(int numeroEstudiantes) {
        this.numeroEstudiantes = numeroEstudiantes;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
