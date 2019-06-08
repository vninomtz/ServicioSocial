/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.ConexionBD;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class InicioSesionController implements Initializable {

    @FXML
    private JFXPasswordField txtContrasenia;
    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXButton btnIniciarSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection conexionBD = new ConexionBD().getConexionBD();
        if(conexionBD != null){
            System.out.println("Conexion exitosa");
        }
    }    
    
}
