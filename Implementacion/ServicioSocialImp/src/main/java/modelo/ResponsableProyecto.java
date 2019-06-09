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
public class ResponsableProyecto {
    private int idResponsableProyecto;
    private String cargo;
    private String correoElectronico;
    private String nombre;
    private String paterno;
    private String materno;
    private UnidadReceptora unidadReceptora = new UnidadReceptora();

    public ResponsableProyecto() {
    }

    public ResponsableProyecto(int idResponsableProyecto, String cargo, String correoElectronico, String nombre, String paterno, String materno) {
        this.idResponsableProyecto = idResponsableProyecto;
        this.cargo = cargo;
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
    }

    public int getIdResponsableProyecto() {
        return idResponsableProyecto;
    }

    public void setIdResponsableProyecto(int idResponsableProyecto) {
        this.idResponsableProyecto = idResponsableProyecto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public UnidadReceptora getUnidadReceptora() {
        return unidadReceptora;
    }

    public void setUnidadReceptora(UnidadReceptora unidadReceptora) {
        this.unidadReceptora = unidadReceptora;
    }
    
    
}
