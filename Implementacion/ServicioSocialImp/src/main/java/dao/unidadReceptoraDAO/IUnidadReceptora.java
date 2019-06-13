/**
 * Autor: Juan Carlos Suarez Hernández
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 12/06/2019
 * Descripción: Interface del DAO de Unidad Receptora
 */
package dao.unidadReceptoraDAO;

import java.util.List;
import modelo.UnidadReceptora;

public interface IUnidadReceptora {
    
    /**
     * @Descripció: El metodo retorna una lista de unidades receptoras como resulado de la consulta
     *              en la base de datos
     * @return listaUnidadesReceptoras
     */
    public List<UnidadReceptora> getUnidadesReceptoras();
    
    /**
     * @Descripció: El metodo busca una UNidad Receptora por medio de una sonculta a la base de
     *              datos 
     * @param idunidadReceptora es el parametro que ocupara pa hacer la consulta especifica
     * @return unidadReceptora
     */
    public UnidadReceptora getUnidadesReceptoras(int idunidadReceptora);
    
}
