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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import modelo.ReporteMensual;

/**
 *
 * @author alanglezh
 */
public class ReporteMensualImp implements IReporteMensual {

    @Override
    public List<ReporteMensual> getReportes(int idSeguimiento) {
        System.out.println("eeeeeeeee");
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
                reporte.setEstado(rs.getString("estado_reporteMensual"));
                reporte.setHorasReportadas(rs.getInt("horasReportadas"));
                reporte.setLink(rs.getString("link_reporteMensual"));
                reporte.setMes(rs.getString("mes_reporteMensual"));
                reporte.setNumeroReporte(rs.getInt("noReporte"));
                reporte.setIdSeguimiento(rs.getInt("idseguimiento"));
                listaReportes.add(reporte);
                System.out.println(reporte.getEstado());
                
                
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

    @Override
    public boolean cambiarEstado(String nuevoEstado,int idReporte) {
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "UPDATE reportemensual set estado_reporteMensual = '" + nuevoEstado +"' "+ "where idreporteMensual = "
                +idReporte +";";
        
        
        try {
            Statement statement = conexionBD.createStatement();
            int rs = statement.executeUpdate(sQuery);
            
            if (rs == 1 || rs == 2 || rs == 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return false;
       
       
     
    }

    @Override
    public boolean guardarReporte(ReporteMensual reporte) {
        String query = "INSERT INTO reportemensual(horasReportadas,link_reporteMensual,mes_reporteMensual,noReporte,idseguimiento) VALUES ('" + reporte.getHorasReportadas() + "','"
                + reporte.getLink()+ "','" + reporte.getMes() + "','" + reporte.getNumeroReporte()+ "','"+ reporte.getIdSeguimiento() + "');";
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
        } finally {
            try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }
        }
        return false;
    }

}
    

