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
public class Documento {
    private String descripcion;
    private LocalDate fecha;
    private String link;
    private String tipo;
    private int idSeguimiento;

    public Documento() {
    }

    public Documento(String descripcion, LocalDate fecha, String link, String tipo, int idSeguimiento) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.link = link;
        this.tipo = tipo;
        this.idSeguimiento = idSeguimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }
    
    
    
}
