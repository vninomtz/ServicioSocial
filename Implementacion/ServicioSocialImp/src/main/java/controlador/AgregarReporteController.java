/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import dao.reportemensualDAO.ReporteMensualImp;
import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.HostServices;
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
import modelo.ReporteMensual;

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
    
    ReporteMensual reporte = new ReporteMensual();

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
    private void clicBtCargar() throws FileNotFoundException, IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        File archivo = fileChooser.showOpenDialog(stage);
        if (archivo != null) {
            archivo.getName();
                
                

        }

    }

    @FXML
    private void clicBtGuardar() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Registro de Reporte Numero: " + (String) cbxNumeroReporte.getValue() + " del Estudiante: "
                + inscripcion.getEstudiante().getNombre() + " " + inscripcion.getEstudiante().getPaterno());
        alert.setContentText("Confirme la operación");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            //reporte.setHorasReportadas(cbxHora);
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
