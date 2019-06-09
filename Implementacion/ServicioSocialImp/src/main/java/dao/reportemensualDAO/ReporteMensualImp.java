/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.reportemensualDAO;

import dao.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ReporteMensual;

/**
 *
 * @author alanglezh
 */
public class ReporteMensualImp implements IReporteMensual {

    @Override
    public List<ReporteMensual> getReportes(int idSeguimiento) {
        List<ReporteMensual> listaReportes = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * FROM reportemensual where idseguimiento ="
                +idSeguimiento +";";

        System.out.println(sQuery);
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                ReporteMensual reporte = new ReporteMensual();
                reporte.setIdReporteMensual(rs.getInt("idreporteMensual"));
                reporte.setEstado(rs.getString("esta_reporteMensual"));
                reporte.setHorasReportadas(rs.getInt("horasReportadas"));
                reporte.setLink(rs.getString("link_reporteMensual"));
                reporte.setMes(rs.getString("mes_reporteMensual"));
                reporte.setNumeroReporte(rs.getInt("noReporte"));
                reporte.setIdSeguimiento(rs.getInt("idseguimiento"));
                listaReportes.add(reporte);
                System.out.println(reporte.getEstado());
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());
            /*Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("Hubo un error con la conexión a la Base de Datos,"
                    + "por favor intente más tarde");
            alert.showAndWait();*/
        } finally {
            /*try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }*/
        }
        return listaReportes;
    }
    
}
