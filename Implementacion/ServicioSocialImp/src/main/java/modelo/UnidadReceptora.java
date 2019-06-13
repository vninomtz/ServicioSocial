package modelo;

public class UnidadReceptora {
    
    //Atributos
    private int idUnidadReceptora;
    private String ciudad;
    private String correoElectronico;
    private String direccion;
    private String estado;
    private String nombre;
    private String nombreDirectivo;
    private String telefono;

    //Metodos
    public UnidadReceptora() {
    }

    public UnidadReceptora(int idUnidadReceptora, String ciudad, String correoElectronico, String direccion, String estado, String nombre, String nombreDirectivo, String telefono) {
        this.idUnidadReceptora = idUnidadReceptora;
        this.ciudad = ciudad;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.estado = estado;
        this.nombre = nombre;
        this.nombreDirectivo = nombreDirectivo;
        this.telefono = telefono;
    }

    public int getIdUnidadReceptora() {
        return idUnidadReceptora;
    }

    public void setIdUnidadReceptora(int idUnidadReceptora) {
        this.idUnidadReceptora = idUnidadReceptora;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDirectivo() {
        return nombreDirectivo;
    }

    public void setNombreDirectivo(String nombreDirectivo) {
        this.nombreDirectivo = nombreDirectivo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
}
