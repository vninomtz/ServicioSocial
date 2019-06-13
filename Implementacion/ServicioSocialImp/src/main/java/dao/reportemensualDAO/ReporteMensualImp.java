/**
 * Autor: Alan González Heredia
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 11/06/2019
 * Descripción: Implementacion del DAO
 */
package dao.reportemensualDAO;

import dao.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import modelo.ReporteMensual;

/**
 *
 * @author alanglezh
 */
public class ReporteMensualImp implements IReporteMensual {

    /**
     * Obtiene todos los reporte con el idSeguimiento asociado
     *
     * @param idSeguimiento numero al cual pertenecen los reportes a buscar
     * @return Lista de ReportesMensuales con dicho idSeguimienti
     */
    @Override
    public List<ReporteMensual> getReportes(int idSeguimiento) {
        List<ReporteMensual> listaReportes = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * FROM reportemensual where idseguimiento ="
                + idSeguimiento + ";";
        if(conexionBD == null) {
            return null;
        }

        System.out.println(sQuery);
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                ReporteMensual reporte = new ReporteMensual();
                reporte.setIdReporteMensual(rs.getInt("idreporteMensual"));
                reporte.setEstado(rs.getString("estado_reporteMensual"));
                reporte.setHorasReportadas(rs.getInt("horasReportadas"));
                reporte.setLink(rs.getString("link_reporteMensual"));
                reporte.setMes(rs.getString("mes_reporteMensual"));
                reporte.setNumeroReporte(rs.getInt("noReporte"));
                reporte.setIdSeguimiento(rs.getInt("idseguimiento"));
                listaReportes.add(reporte);

            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("Hubo un error con la conexión a la Base de Datos,"
                    + "por favor intente más tarde");
            alert.showAndWait();
        }
        return listaReportes;
    }

    /**
     * Cambia el estado de un reporte
     *
     * @param nuevoEstado Estado al que se desea cambiar el reporte
     * @param idReporte numero unico del reporte
     * @return
     */
    @Override
    public boolean cambiarEstado(String nuevoEstado, int idReporte) {
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "UPDATE reportemensual set estado_reporteMensual = '"
                + nuevoEstado + "' " + "where idreporteMensual = "
                + idReporte + ";";

        try {
            Statement statement = conexionBD.createStatement();
            int rs = statement.executeUpdate(sQuery);

            if (rs == 1 || rs == 2 || rs == 0) {
                return true;
            }

        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("No se pudo actualizar el estado del reporte, inténtelo más tarde");
            alert.showAndWait();
        }
        return false;

    }

    /**
     * Guarda un ReporteMensual en la base de datos
     *
     * @param reporte ReporteMensual que se desea guardar
     * @return Verdadero si el reporte pudo guardarse
     */
    @Override
    public boolean guardarReporte(ReporteMensual reporte) {
        String rutaOriginal = reporte.getLink();
        String separador = Pattern.quote("\\");
        String[] rutaPartida = rutaOriginal.split(separador);
        String nuevaRuta = "";
        for(String ruta : rutaPartida) {
            nuevaRuta += ruta + "\\\\";
        }
        String rutaFinal = nuevaRuta.substring(0, nuevaRuta.length() - 2);
        
        String query = "INSERT INTO reportemensual(horasReportadas,link_reporteMensual,mes_reporteMensual,estado_reporteMensual,noReporte,idseguimiento) VALUES ('" + reporte.getHorasReportadas() + "','"
                + rutaFinal + "','" + reporte.getMes() + "','" + "Pendiente" + "','" + reporte.getNumeroReporte() + "','" + reporte.getIdSeguimiento() + "');";
        System.out.println(query);
        Connection conexionBD = new ConexionBD().getConexionBD();
        try {
            Statement statement = conexionBD.createStatement();
            int rs = statement.executeUpdate(query);
            if (rs == 1 || rs == 2 || rs == 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement" + ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("No se pudo guardar el reporte mensual intente mas tarde");
            alert.showAndWait();
        } finally {
            /*try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }*/
        }
        return false;
    }

    /**
     * Devuelve el numero del ultimo reporte ingresado
     *
     * @param idseguimiento numero unico del seguimiento
     * @return numero del ultimo reporte asociado al idSeguimiento
     */
    @Override
    public int obtenerUltimoReporte(int idseguimiento) {
        String query = "select noReporte from reportemensual "
                + "where idseguimiento =" + idseguimiento
                + " order by noReporte desc limit 1 ;";

        Connection conexionBD = new ConexionBD().getConexionBD();
        int numero = 0;
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs != null && rs.next()) {

                numero = rs.getInt("noReporte");

            }

        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("Hubo un error con la conexión a la Base de Datos,"
                    + "por favor intente más tarde");
            alert.showAndWait();
        }
        return numero;
    }

}
