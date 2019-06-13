/**
 * Autor: Juan Carlos Suarez Hernández
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 12/06/2019
 * Descripción: Clase DAO de Responsable de Proyecto que implementa la Interface de la misma
 */
package dao.responsableProyectoDAO;

import dao.ConexionBD;
import dao.unidadReceptoraDAO.UnidadReceptoraImp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ResponsableProyecto;
import modelo.UnidadReceptora;

public class ResponsableProyectoImp implements IResponsableProyecto {

    /**
     * @Descripció: El metodo retorna una lista de Responsables de Proyecto como resulado de la
     * consulta en la base de datos
     * @return listaResponsablesProyecto
     */
    @Override

    public List<ResponsableProyecto> getResponsables() {

        List<ResponsableProyecto> listaResponsablesProyecto = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();

        //Sentencia que se hara para obtener informacion de la base de datos
        String sQuery = "SELECT * FROM responsableproyecto;";

        System.out.println(sQuery);

        try {
            Statement statement = conexionBD.createStatement();

            //Se ejecuta la sentencia en la base de datos
            ResultSet rs = statement.executeQuery(sQuery);

            //Se contrullen todas los Responsables de Proyecto obtenidos por la sentencia
            while (rs != null && rs.next()) {

                ResponsableProyecto responsable = new ResponsableProyecto();
                responsable.setIdResponsableProyecto(rs.getInt("idresponsableProyecto"));
                responsable.setNombre(rs.getString("nombre"));
                responsable.setPaterno(rs.getString("paterno"));
                responsable.setMaterno(rs.getString("materno"));
                responsable.setCargo(rs.getString("cargo"));
                responsable.setCorreoElectronico(rs.getString("correoElectronico"));

                UnidadReceptoraImp unidadReceptoraDAO = new UnidadReceptoraImp();
                UnidadReceptora unidadR
                        = unidadReceptoraDAO.getUnidadesReceptoras(rs.getInt("idunidadReceptora"));
                responsable.setUnidadReceptora(unidadR);

                listaResponsablesProyecto.add(responsable);

            }

        } catch (SQLException ex) {//Excepción en caso de un error con la base de datos

            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());

        }

        return listaResponsablesProyecto;
    }

    /**
     * @Descripció: El metodo Restorna un balor boleano dependiendo sea el caso de si guardo o no al
     *              Responsable de Proyecto
     * @param responsableProyecto se le manda el objeto ya creado para evitar pasar muchos
     * parametros
     * @return true / false
     */
    @Override
    public boolean guardarResponsable(ResponsableProyecto responsableProyecto) {
        
        //Sentencia que se hara para obtener informacion de la base de datos
        String sentencia = "INSERT INTO responsableproyecto (cargo, correoElectronico,"
                + "materno, paterno, nombre, idunidadReceptora) VALUES ('"
                + responsableProyecto.getCargo() + "','"
                + responsableProyecto.getCorreoElectronico() + "','"
                + responsableProyecto.getMaterno() + "','"
                + responsableProyecto.getPaterno() + "','"
                + responsableProyecto.getNombre() + "','"
                + responsableProyecto.getUnidadReceptora().getIdUnidadReceptora() + "');";
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

}
