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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
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
        txtFecha.setValue(LocalDate.now());
        try {
            txtFecha.setOverLay(true);
        }catch(Exception ex) {
            System.out.println("Error en DatePicker");
        }
        
    }
    @FXML
    private void clicBtnCancelar() {
        Stage ventana = (Stage)btnCancelar.getScene().getWindow();
        ventana.close();
    }
    @FXML
    private void llenarCbTipoDocumento() {
         List<String> listaMes = new ArrayList();
        listaMes.add("Registro y plan de Actividades");
        listaMes.add("Reporte Mensual de Actividades");
        listaMes.add("Carta Aceptación");
        listaMes.add("Carta Liberación");
        listaMes.add("Horario");
        listaMes.add("Memoria");

        ObservableList<String> obsevableListaTipoOpe
                = FXCollections.observableArrayList(listaMes);
        cbTipoDoc.setItems(obsevableListaTipoOpe);
    }
    
    @FXML
    private void clicBtnSubirDocumento() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        fileChooser.showOpenDialog(stage);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        llenarCbTipoDocumento();
    }    
    
}
