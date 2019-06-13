/**
 * Autor: Juan Carlos Suarez Hernández
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 12/06/2019
 * Descripción: Clase DAO de Unidad Receptora que implementa la Interface   de la misma
 */
package dao.unidadReceptoraDAO;

import dao.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.UnidadReceptora;

public class UnidadReceptoraImp implements IUnidadReceptora {

    /**
     * @Descripció: El metodo retorna una lista de unidades receptoras como resulado de la consulta
     *              en la base de datos
     * @return listaUnidadesReceptoras
     */
    @Override
    public List<UnidadReceptora> getUnidadesReceptoras() {

        List<UnidadReceptora> listaUnidadesReceptoras = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();

        //Sentencia que se hara para obtener informacion de la base de datos
        String sQuery = "SELECT * FROM unidadreceptora;";

        System.out.println(sQuery);

        try {

            Statement statement = conexionBD.createStatement();

            //Se ejecuta la sentencia en la base de datos
            ResultSet rs = statement.executeQuery(sQuery);

            //Se contrullen todas las Unidades Receptoras obtenidas por la sentencia
            while (rs != null && rs.next()) {

                UnidadReceptora unidadReceptora = new UnidadReceptora();
                unidadReceptora.setIdUnidadReceptora(rs.getInt("idunidadReceptora"));
                unidadReceptora.setCiudad(rs.getString("ciudad"));
                unidadReceptora.setCorreoElectronico(rs.getString("correoElectronico"));
                unidadReceptora.setDireccion(rs.getString("direccion"));
                unidadReceptora.setEstado(rs.getString("estado"));
                unidadReceptora.setNombre(rs.getString("nombre"));
                unidadReceptora.setNombreDirectivo(rs.getString("nombreDirectivo"));
                unidadReceptora.setTelefono(rs.getString("telefono"));

                listaUnidadesReceptoras.add(unidadReceptora);

            }
        } catch (SQLException ex) {//Excepción en caso de un error con la base de datos

            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());

        }

        return listaUnidadesReceptoras;

    }

    /**
     * @Descripció: El metodo busca una UNidad Receptora por medio de una sonculta a la base de
     *              datos
     * @param idunidadReceptora es el parametro que ocupara pa hacer la consulta especifica
     * @return unidadReceptora
     */
    @Override
    public UnidadReceptora getUnidadesReceptoras(int idunidadReceptora) {

        Connection conexionBD = new ConexionBD().getConexionBD();
        
        //Sentencia que se hara para obtener informacion de la base de datos
        String sQuery = "SELECT * FROM unidadreceptora WHERE idunidadReceptora = "
                + idunidadReceptora + ";";

        System.out.println(sQuery);

        UnidadReceptora unidadReceptora = new UnidadReceptora();

        try {

            Statement statement = conexionBD.createStatement();
            
            //Se ejecuta la sentencia en la base de datos
            ResultSet rs = statement.executeQuery(sQuery);

            //Se contrullen la Unidad Receptora obtenida por la sentencia
            while (rs != null && rs.next()) {

                unidadReceptora.setIdUnidadReceptora(rs.getInt("idunidadReceptora"));
                unidadReceptora.setCiudad(rs.getString("ciudad"));
                unidadReceptora.setCorreoElectronico(rs.getString("correoElectronico"));
                unidadReceptora.setDireccion(rs.getString("direccion"));
                unidadReceptora.setEstado(rs.getString("estado"));
                unidadReceptora.setNombre(rs.getString("nombre"));
                unidadReceptora.setNombreDirectivo(rs.getString("nombreDirectivo"));
                unidadReceptora.setTelefono(rs.getString("telefono"));

            }

        } catch (SQLException ex) {//Excepción en caso de un error con la base de datos

            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());

        }

        return unidadReceptora;
    }

}
