/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Inscripcion;
import serviciosocial.main.MainApp;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class VerDocumentosController implements Initializable {

    @FXML private TableView<Inscripcion> tablaEstudiantes; 
    @FXML private TableColumn<Inscripcion, String> colTipoDoc;
    @FXML private TableColumn<?, ?> colEstadoDoc;
    @FXML private TableColumn<?, ?> colFechaDoc;
    @FXML private JFXButton btnAgregarDocumento;
    @FXML private JFXButton btnValidarDocumento;
    @FXML private JFXButton btnRegresar;
    @FXML private MenuItem mtAdministrarEstudiantes;
    @FXML private MenuItem mtAdministrarServicioSocial;
    @FXML private MenuItem mtSalirCuenta;
    @FXML private JFXButton btnBuscar;
    @FXML private JFXComboBox<?> cbEstadoDoc;
    @FXML private JFXComboBox<?> cbTipoDoc;
    @FXML private Label lbMatricula;
    @FXML private Label lbEstudiante;
    private Inscripcion inscripcion;

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
        lbMatricula.setText(inscripcion.getEstudiante().getMatricula());
        lbEstudiante.setText(inscripcion.getEstudiante().toString());
        
    }
    
    @FXML 
    private void ventanaMenuPrincipal() {
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
            Stage principal = (Stage) btnRegresar.getScene().getWindow();
            principal.close();
        } catch (IOException ex) {
            Logger.getLogger(VerDocumentosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
