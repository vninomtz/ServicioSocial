/**
 * Autor: Victor Manuel Niño Martínez
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 11/06/2019
 * Descripción: Controlador de la interfaz IniciarSesion.fxml
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.ConexionBD;
import dao.inicioSesion.InicioSesionImp;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import serviciosocial.main.MainApp;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class InicioSesionController implements Initializable {

    @FXML private JFXPasswordField txtContrasenia;
    @FXML private JFXTextField txtUsuario;
    @FXML private JFXButton btnIniciarSesion;
    
    /**
     * Método que evalua si es usuario y abre el menu principal
     */
    @FXML
    private void clicBtInciarSesion() {
        if(validarCampos()) {
           InicioSesionImp sesion = new InicioSesionImp();
            if(sesion.isUsuarioRegistrado(txtUsuario.getText(), txtContrasenia.getText())) {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/MenuPrincipal.fxml"));
                try {
                    AnchorPane anchorpane = loader.load();
                    Scene scene = new Scene(anchorpane);
                    scene.getStylesheets().add("/styles/Styles.css");
                    Stage stage = new Stage();
                    stage.setTitle("Servicio Social");
                    stage.getIcons().add(new Image("/fxml/img/User1.png"));
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    Stage principal = (Stage) btnIniciarSesion.getScene().getWindow();
                    principal.close();
                } catch (IOException ex) {
                    System.out.println("Error al mostrar la ventana:" + ex.getMessage());
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Datos incorrectos");
                alert.setHeaderText("El usuario o contraseña son incorrectos "
                        + ", Intentelo de nuevo");
                alert.showAndWait();
            }
        }
        
    }
    
    /**
     * Método que valida que todo los campos estén llenos
     * @return true si todos los campos están llenos y false si no
     */
    public boolean validarCampos() {
        if(txtUsuario.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos Vacios");
            alert.setHeaderText("Ingresar el usuario");
            alert.showAndWait();
            return false;
        }
        if(txtContrasenia.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos Vacios");
            alert.setHeaderText("Ingresar la contrasenia");
            alert.showAndWait();
            return false;
        }
        return true;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection conexionBD = new ConexionBD().getConexionBD();
        if(conexionBD != null){
            System.out.println("Conexion exitosa");
        }
    }    
    
}
