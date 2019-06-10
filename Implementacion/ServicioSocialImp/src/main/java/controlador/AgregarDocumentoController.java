/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelo.Inscripcion;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class AgregarDocumentoController implements Initializable {

    @FXML
    private JFXTextArea txtDescripcion;
    @FXML
    private JFXDatePicker txtFecha;
    @FXML
    private JFXComboBox<String> cbTipoDoc;
    @FXML
    private JFXButton btnSubirDoc;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private Label lbArchivoAdjunto;

    private Inscripcion inscripcion;

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;  
    }
    @FXML
    private void clicBtnCancelar() {
        Stage ventana = (Stage)btnCancelar.getScene().getWindow();
        ventana.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
