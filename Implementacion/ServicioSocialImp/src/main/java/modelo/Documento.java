/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;



/**
 *
 * @author Vik-t
 */
public class Documento {
    private int idDocumento;
    private String descripcion;
    private Date fecha;
    private String estado;
    private String link;
    private String tipo;
    private int idSeguimiento;

    public Documento() {
    }

    public Documento(int idDocumento,String descripcion, Date fecha, String estado,
            String link, String tipo, int idSeguimiento) {
        this.idDocumento = idDocumento;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.link = link;
        this.tipo = tipo;
        this.idSeguimiento = idSeguimiento;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
