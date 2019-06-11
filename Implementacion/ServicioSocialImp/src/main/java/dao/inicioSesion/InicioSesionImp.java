/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.inicioSesion;

import dao.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import modelo.InicioSesion;

/**
 *
 * @author Vik-t
 */
public class InicioSesionImp implements IInicioSesion{

    @Override
    public boolean isUsuarioRegistrado(String usuario, String contrasenia) {
       InicioSesion inicioSesion = new InicioSesion();
        Connection conexionBD = new ConexionBD().getConexionBD();
        String sQuery = "SELECT * FROM iniciosesion where (usuario ='" + usuario + "')"
                + " AND (contrasenia ='" + contrasenia + "');";

        System.out.println(sQuery);
        try {
            Statement statement = conexionBD.createStatement();
            ResultSet rs = statement.executeQuery(sQuery);
            while (rs != null && rs.next()) {
                inicioSesion.setIdInicioSesion(rs.getInt("idinicioSesion"));
                inicioSesion.setUsuario(rs.getString("usuario"));
                inicioSesion.setContrasenia(rs.getString("contrasenia"));
            }
        } catch (SQLException ex) {
            System.out.println("Error en la creacion de el Statement: " + ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error con BD");
            alert.setHeaderText("Hubo un error con la conexión a la Base de Datos,"
                    + "por favor intente más tarde");
            alert.showAndWait();
            return false;
        } finally {
            /*try {
                conexionBD.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion" + ex.getMessage());
            }*/
        }
        if(inicioSesion.getUsuario() == null) {
             return false;
        }
        return true;
       
    }
    
}
