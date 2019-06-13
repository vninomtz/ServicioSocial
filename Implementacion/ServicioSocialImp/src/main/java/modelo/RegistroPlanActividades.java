package modelo;

public class RegistroPlanActividades {
    
    //Atrinutos
    private int idRegistroPlanDeActividades;
    private String descripcion;
    private String duracion;
    private String horario;
    private String nombre;
    private String responsabilidades;
    private ResponsableProyecto responsableProyecto = new ResponsableProyecto();
    private int idseguimiento;

    //Metodos
    public RegistroPlanActividades(int idRegistroPlanDeActividades, String descripcion, 
            String duracion, String horario, String nombre, String responsabilidades, 
            int idseguimiento) {
        this.idRegistroPlanDeActividades = idRegistroPlanDeActividades;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.horario = horario;
        this.nombre = nombre;
        this.responsabilidades = responsabilidades;
        this.idseguimiento = idseguimiento;
    }

    public RegistroPlanActividades() {
    }

    public void setIdRegistroPlanDeActividades(int idRegistroPlanDeActividades) {
        this.idRegistroPlanDeActividades = idRegistroPlanDeActividades;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResponsabilidades(String responsabilidades) {
        this.responsabilidades = responsabilidades;
    }

    public void setResponsableProyecto(ResponsableProyecto responsableProyecto) {
        this.responsableProyecto = responsableProyecto;
    }

    public void setIdseguimiento(int idseguimiento) {
        this.idseguimiento = idseguimiento;
    }

    public int getIdRegistroPlanDeActividades() {
        return idRegistroPlanDeActividades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getHorario() {
        return horario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getResponsabilidades() {
        return responsabilidades;
    }

    public ResponsableProyecto getResponsableProyecto() {
        return responsableProyecto;
    }

    public int getIdseguimiento() {
        return idseguimiento;
    }
        
}
