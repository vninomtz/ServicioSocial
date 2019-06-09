/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class VerDocumentosController implements Initializable {

    @FXML
    private TableView<?> tablaEstudiantes;
    @FXML
    private TableColumn<?, ?> colTipoDoc;
    @FXML
    private TableColumn<?, ?> colEstadoDoc;
    @FXML
    private TableColumn<?, ?> colFechaDoc;
    @FXML
    private JFXButton btnAgregarDocumento;
    @FXML
    private JFXButton btnValidarDocumento;
    @FXML
    private JFXButton btnRegresar;
    @FXML
    private MenuItem mtAdministrarEstudiantes;
    @FXML
    private MenuItem mtAdministrarServicioSocial;
    @FXML
    private MenuItem mtSalirCuenta;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXComboBox<?> cbEstadoDoc;
    @FXML
    private JFXComboBox<?> cbTipoDoc;
    @FXML
    private Label lbMatricula;
    @FXML
    private Label lbEstudiante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
