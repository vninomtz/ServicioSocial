/**
 * Autor: Juan Carlos Suarez Hernández
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 12/06/2019
 * Descripción: Interface del DAO del Responsable del Proyecto
 */
package dao.registroPlanActividadesDAO;

import modelo.RegistroPlanActividades;

public interface IRegistroPlanActividades {

    /**
     * @Descripció: El metodo retorna un Registro y Plan de Actividades como resulado de la 
     *              consulta en la base de datos
     * @param idseguimiento parametro necesario para poder buscar el Registro y plan de actividades
     *                      necesario
     * @return registroPlanActividades
     */
    public RegistroPlanActividades getResgistroPlanActividades(int idseguimiento);

    /**
     * @Descripció: El metodo guarda el plan y registro de actividades en la base de datos como 
     *              resultado de la sentencia
     * @param registroPlanA se pasa el objetos como parametro para evitar pasar demasiados 
     *                      parametros
     * @return true / false dependiendo sea el caso
     */
    public boolean guardarRegistroPlanActividades(RegistroPlanActividades registroPlanA);

}
