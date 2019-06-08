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
public class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String paterno;
    private String materno;
    private String programaEducativo;
    private String email;
    private float promedio;
    private String telefono;
    private String nombreContacto;
    private String telefonoContacto;
    private InicioSesion inicioSesion;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, String nombre, String paterno, 
            String materno, String programaEducativo, String email, 
            float promedio, String telefono, String nombreContacto, 
            String telefonoContacto, InicioSesion inicioSesion) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.programaEducativo = programaEducativo;
        this.email = email;
        this.promedio = promedio;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.inicioSesion = inicioSesion;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public InicioSesion getInicioSesion() {
        return inicioSesion;
    }

    public void setInicioSesion(InicioSesion inicioSesion) {
        this.inicioSesion = inicioSesion;
    }
    
    
    
}
