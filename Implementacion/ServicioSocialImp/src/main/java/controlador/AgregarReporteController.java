/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import modelo.Estudiante;
import modelo.Inscripcion;

/**
 * FXML Controller class
 *
 * @author alanglezh
 */
public class AgregarReporteController implements Initializable {

    private Inscripcion inscripcion;

    @FXML
    private JFXComboBox cbxNumeroReporte;
    @FXML
    private JFXComboBox cbxMes;
    @FXML
    private JFXButton btCargarReporte;
    @FXML
    private JFXButton btSalir;
    @FXML
    private JFXButton btGuardar;

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    private void llenarCbMes() {
        List<String> listaMes = new ArrayList();
        listaMes.add("Enero");
        listaMes.add("Febrero");
        listaMes.add("Marzo");
        listaMes.add("Abril");
        listaMes.add("Mayo");
        listaMes.add("Junio");
        listaMes.add("Julio");
        listaMes.add("Agosto");
        listaMes.add("Septiembre");
        listaMes.add("Octubre");
        listaMes.add("Noviembre");
        listaMes.add("Diciembre");

        ObservableList<String> obsevableListaTipoOpe
                = FXCollections.observableArrayList(listaMes);
        cbxMes.setItems(obsevableListaTipoOpe);
    }

    private void llenarCbxNumeroReporte() {
        List<String> listaNumeroReporte = new ArrayList();
        listaNumeroReporte.add("1");
        listaNumeroReporte.add("2");
        listaNumeroReporte.add("3");
        listaNumeroReporte.add("4");
        listaNumeroReporte.add("5");
        listaNumeroReporte.add("6");
        listaNumeroReporte.add("7");
        listaNumeroReporte.add("8");
        listaNumeroReporte.add("9");
        listaNumeroReporte.add("10");
        ObservableList<String> obsevableListaTipoOpe
                = FXCollections.observableArrayList(listaNumeroReporte);
        cbxNumeroReporte.setItems(obsevableListaTipoOpe);
    }

    @FXML
    private void clicBtCargar() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        fileChooser.showOpenDialog(stage);
    }

    @FXML
    private void clicBtGuardar() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Registro de Reporte Numero: " + (String) cbxNumeroReporte.getValue() + " del Estudiante: " +
                inscripcion.getEstudiante().getNombre() + " " + inscripcion.getEstudiante().getPaterno());
        alert.setContentText("Confirme la operación");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarCbxNumeroReporte();
        llenarCbMes();

    }

}
