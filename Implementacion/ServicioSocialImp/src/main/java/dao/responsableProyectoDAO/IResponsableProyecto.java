/**
 * Autor: Juan Carlos Suarez Hernández
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 12/06/2019
 * Descripción: Interface del DAO del Responsable del Proyecto
 */
package dao.responsableProyectoDAO;

import java.util.List;
import modelo.ResponsableProyecto;

public interface IResponsableProyecto {
    
    /**
     * @Descripció: El metodo retorna una lista de Responsables de Proyecto como resulado de la 
     *              consulta en la base de datos
     * @return listaResponsablesProyecto
     */
    public List<ResponsableProyecto> getResponsables();
    
    /**
     * @Descripció: El metodo Restorna un balor boleano dependiendo sea el caso de si guardo o no 
     *              al Responsable de Proyecto
     * @param responsableProyecto se le manda el objeto ya creado para evitar pasar muchos 
     *        parametros
     * @return true / false
     */
    public boolean guardarResponsable(ResponsableProyecto responsableProyecto);
    
}
