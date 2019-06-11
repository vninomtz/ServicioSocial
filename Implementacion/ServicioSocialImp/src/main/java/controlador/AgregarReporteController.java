/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import javafx.scene.control.Label;
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
    private JFXTextField txtNumeroReporte;
    @FXML
    private JFXComboBox cbxMes;
    @FXML
    private JFXButton btCargarReporte;
    @FXML
    private JFXButton btSalir;
    @FXML
    private JFXButton btGuardar;
    @FXML
    private Label lbArchivoAdjunto;
    @FXML
    private JFXTextField txtHoras;

    File archivo = null;
    int numeroUltimoReporte;

    public void setReporte(int numeroReporte) {
        this.numeroUltimoReporte = numeroReporte;
        llenarCbxNumeroReporte();

    }

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
        listaMes.add("Ocutbre");
        listaMes.add("Noviembre");
        listaMes.add("Diciembre");

        ObservableList<String> obsevableListaTipoOpe
                = FXCollections.observableArrayList(listaMes);
        cbxMes.setItems(obsevableListaTipoOpe);
    }

    private void llenarCbxNumeroReporte() {
        txtNumeroReporte.setText(Integer.toString(numeroUltimoReporte + 1));
        txtNumeroReporte.setEditable(false);

    }

    public File guardarDocumento() {
        Path origen = Paths.get(archivo.getAbsolutePath());
        Path destino = Paths.get("src\\main\\resources\\fxml\\documentos\\" + archivo.getName());
        try {
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return null;
        }
        return destino.toFile();
    }

    @FXML
    private void clicBtCargar() throws FileNotFoundException, IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        archivo = fileChooser.showOpenDialog(stage);
        if (archivo != null) {
            lbArchivoAdjunto.setText(archivo.getName());

        }

    }

    public void guardarReporte() {
        int horas = Integer.parseInt(txtHoras.getText());
        String numeroReporte = txtNumeroReporte.getText();
        String mes = (String) cbxMes.getValue();

        ReporteMensual reporte = new ReporteMensual();
        reporte.setNumeroReporte(Integer.parseInt(numeroReporte));
        reporte.setIdSeguimiento(inscripcion.getSeguimiento().getIdSeguimiento());
        reporte.setHorasReportadas(horas);
        reporte.setLink(archivo.getAbsolutePath());
        reporte.setMes(mes);
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        reporteImp.guardarReporte(reporte);

    }
    
    @FXML 
    private void clicBtSalir(){
        Stage principal = (Stage) btSalir.getScene().getWindow();
        principal.close();
    }

    @FXML
    private void clicBtGuardar() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Registro de Reporte Numero: " + (String) Integer.toString(numeroUltimoReporte + 1) + " del Estudiante: "
                + inscripcion.getEstudiante().getNombre() + " " + inscripcion.getEstudiante().getPaterno());
        alert.setContentText("Confirme la operación");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            guardarReporte();
            Stage ventana = (Stage) btSalir.getScene().getWindow();
            ventana.close();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        llenarCbMes();

    }

}
