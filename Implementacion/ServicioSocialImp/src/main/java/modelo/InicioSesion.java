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
public class InicioSesion {
    private int idInicioSesion;
    private String usuario;
    private String contrasenia;

    public InicioSesion() {
    }

    public InicioSesion(int idInicioSesion, String usuario, String contrasenia) {
        this.idInicioSesion = idInicioSesion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public int getIdInicioSesion() {
        return idInicioSesion;
    }

    public void setIdInicioSesion(int idInicioSesion) {
        this.idInicioSesion = idInicioSesion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}
