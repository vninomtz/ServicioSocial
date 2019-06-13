/**
 * Autor: Juan Carlos Suarez Hernández
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 12/06/2019
 * Descripción: Clase DAO del Plan Y registro de actividades
 */
package dao.registroPlanActividadesDAO;

import dao.ConexionBD;
import dao.responsableProyectoDAO.ResponsableProyectoImp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import modelo.RegistroPlanActividades;
import modelo.ResponsableProyecto;

public class RegistroPlanActividadesImp implements IRegistroPlanActividades {

    /**
     * @Descripció: El metodo guarda el plan y registro de actividades en la base de datos como
     * resultado de la sentencia
     * @param registroPlanA se pasa el objetos como parametro para evitar pasar demasiados
     * parametros
     * @return true / false dependiendo sea el caso
     */
    @Override
    public boolean guardarRegistroPlanActividades(RegistroPlanActividades registroPlanA) {

        //Sentencia que se hara para obtener informacion de la base de datos
        String sentencia = "INSERT INTO registroplandeactividades (descripcion_planActividades, "
                + "duracion_planActividades, horario_planActividades, nombre_planActividades, "
                + "responsabilidades_planActividades, idseguimiento, idresponsableProyecto) VALUES ('"
                + registroPlanA.getDescripcion() + "','"
                + registroPlanA.getDuracion() + "','"
                + registroPlanA.getHorario() + "','"
                + registroPlanA.getNombre() + "','"
                + registroPlanA.getResponsabilidades() + "',"
                + registroPlanA.getIdseguimiento() + ","
                + registroPlanA.getResponsableProyecto().getIdResponsableProyecto() + ");";

        System.out.println(sentencia);

        Connection conexionBD = new ConexionBD().getConexionBD();

        if (conexionBD == null) {

            return false;

        }
        try {

            Statement statement = conexionBD.createStatement();
            
            //Se ejecuta la sentencia en la base de datos
            int rs = statement.executeUpdate(sentencia);

            if (rs == 1 || rs == 2 || rs == 0) {

                return true;

            }

        } catch (SQLException ex) {//Excepción en caso de un error con la base de datos

            System.out.println("Error en la creacion de el Statement" + ex.getMessage());

            return false;

        }

        return false;
    }

    /**
     * @Descripció: El metodo retorna un Registro y Plan de Actividades como resulado de la consulta
     * en la base de datos
     * @param idseguimiento parametro necesario para poder buscar el Registro y plan de actividades
     * necesario
     * @return registroPlanActividades
     */
    @Override
    public RegistroPlanActividades getResgistroPlanActividades(int idseguimiento) {

        RegistroPlanActividades registroPlanA = new RegistroPlanActividades();
        Connection conexionBD = new ConexionBD().getConexionBD();
        
        //Sentencia que se hara para obtener informacion de la base de datos
        String sQuery = "SELECT * FROM registroplandeactividades WHERE idseguimiento = "
                + idseguimiento + ";";

        System.out.println(sQuery);

        try {

            Statement statement = conexionBD.createStatement();
            
            //Se ejecuta la sentencia en la base de datos
            ResultSet rs = statement.executeQuery(sQuery);

            //Se contrulle el plan t registro de actividades obtenido por la sentencia
            while (rs != null && rs.next()) {

                registroPlanA.setIdRegistroPlanDeActividades(
                        rs.getInt("idregistroPlanDeActividades"));
                registroPlanA.setDescripcion(rs.getString("descripcion_planActividades"));
                registroPlanA.setDuracion(rs.getString("duracion_planActividades"));
                registroPlanA.setHorario(rs.getString("horario_planActividades"));
                registroPlanA.setNombre(rs.getString("nombre_planActividades"));
                registroPlanA.setResponsabilidades(rs.getString("responsabilidades_planActividades"));
                registroPlanA.setIdseguimiento(rs.getInt("idseguimiento"));

                List<ResponsableProyecto> listaResponsables;
                ResponsableProyectoImp responsablesProyectoDAO = new ResponsableProyectoImp();
                listaResponsables = responsablesProyectoDAO.getResponsables();

                for (ResponsableProyecto responsableProyecto : listaResponsables) {

                    if (responsableProyecto.getIdResponsableProyecto() == rs.getInt(
                            "idresponsableProyecto")) {
                        registroPlanA.setResponsableProyecto(responsableProyecto);
                    }

                }

            }

        } catch (SQLException ex) {//Excepción en caso de un error con la base de datos
            
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());

        }

        return registroPlanA;

    }

}
