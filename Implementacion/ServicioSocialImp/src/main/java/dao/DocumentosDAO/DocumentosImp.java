/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.DocumentosDAO;

import dao.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Documento;

/**
 *
 * @author Vik-t
 */
public class DocumentosImp implements IDocumento{

    @Override
    public List<Documento> getDocumentos(int idSeguimiento) {
        List<Documento> listaDocumentos = new ArrayList();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * FROM documento where idseguimiento ="
                +idSeguimiento +";";

        System.out.println(sQuery);
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                Documento documento = new Documento();
                documento.setIdDocumento(rs.getInt("iddocumento"));
                documento.setDescripcion(rs.getString("descripcion_documento"));
                documento.setEstado(rs.getString("estado_documento"));
                documento.setFecha(rs.getDate("fecha_documento"));
                documento.setLink(rs.getString("link_documento"));
                documento.setTipo(rs.getString("tipo_documento"));
                documento.setIdSeguimiento(rs.getInt("idseguimiento"));
                
                listaDocumentos.add(documento);
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());
            /*Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("Hubo un error con la conexión a la Base de Datos,"
                    + "por favor intente más tarde");
            alert.showAndWait();*/
            return null;
        } finally {
            /*try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }*/
        }
        return listaDocumentos;
    }
    
}
