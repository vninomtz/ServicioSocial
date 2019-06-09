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
public class ServicioSocial {
    private int idServicioSocial;
    private int bloque;
    private int creditos;
    private String nombreProfesor;
    private int nrc;
    private int seccion;

    public ServicioSocial() {
    }

    public ServicioSocial(int idServicioSocial, int bloque, int creditos, 
            String nombreProfesor, int nrc, int seccion) {
        this.idServicioSocial = idServicioSocial;
        this.bloque = bloque;
        this.creditos = creditos;
        this.nombreProfesor = nombreProfesor;
        this.nrc = nrc;
        this.seccion = seccion;
    }

    public int getIdServicioSocial() {
        return idServicioSocial;
    }

    public void setIdServicioSocial(int idServicioSocial) {
        this.idServicioSocial = idServicioSocial;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }
    
    
    
}
