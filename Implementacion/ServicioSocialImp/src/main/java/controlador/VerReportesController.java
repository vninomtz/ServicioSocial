/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import dao.reportemensualDAO.ReporteMensualImp;
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static javax.swing.Spring.width;
import modelo.Estudiante;
import modelo.Inscripcion;
import modelo.ReporteMensual;
import serviciosocial.main.MainApp;

/**
 * FXML Controller class
 *
 * @author alanglezh
 */
public class VerReportesController implements Initializable {

    @FXML
    private JFXButton btnValidarReporte;
    @FXML
    private JFXButton btnAgregarReporte;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private TableView tablaReportes;
    @FXML
    private TableColumn<ReporteMensual, Integer> colNumeroReporte;
    @FXML
    private TableColumn<ReporteMensual, String> colMes;
    @FXML
    private TableColumn<ReporteMensual, Integer> colHoras;
    @FXML
    private TableColumn<ReporteMensual, String> colEstado;

    private Inscripcion inscripcion = new Inscripcion();

    /**
     * Initializes the controller class.
     *
     * @param inscripcion
     */
    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;

        llenarTablaReportes();

    }

    public ReporteMensual obtenerReporteSeleccionado() {
        if (tablaReportes != null) {
            ReporteMensual reporte = (ReporteMensual) tablaReportes.getSelectionModel().getSelectedItem();

            return reporte;
        } else {
            return null;
        }
    }

    private void mostrarVentanaValidar(ReporteMensual reporte) {
        try {

            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/ValidarReporte.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Validar Reporte");
            stage.setScene(scene);
            stage.alwaysOnTopProperty();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            ValidarReporteController controller = (ValidarReporteController) loader.getController();
            controller.setReporte(reporte);

            stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    llenarTablaReportes();
                }
            });
            stage.show();
            try {
                File path = new File(reporte.getLink());
                Desktop.getDesktop().open(path);
            } catch (IOException ex) {
                System.out.println("No se pudo abrir el Reporte:" + ex.getMessage());
            }

        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex);
        }
    }

    private boolean validarEstadoReporte(ReporteMensual reporte) {
        if (reporte.getEstado().equals("Pendiente")) {

            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Seleccione un Reporte Mensual con estado Pendiente");
            alert.showAndWait();
            return false;
        }

    }

    @FXML
    private void clicBtValidarReporte() {
        ReporteMensual reporte = obtenerReporteSeleccionado();
        if (reporte != null) {
            mostrarVentanaValidar(reporte);

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Seleccione un Reporte Mensual primero");
            alert.showAndWait();
        }
    }

    private int obtenerUltimoReporte() {
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        int numero = reporteImp.obtenerUltimoReporte(inscripcion.getSeguimiento().getIdSeguimiento());
        System.out.println("Numero: " + numero);
        return numero;
    }

    @FXML
    private void clicBtAgregarReporte() {
        try {

            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/AgregarReporte.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Registrar Ventas");
            stage.setScene(scene);
            stage.setResizable(false);
            AgregarReporteController controller = (AgregarReporteController) loader.getController();
            controller.setInscripcion(inscripcion);
            controller.setReporte(obtenerUltimoReporte());
            stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    llenarTablaReportes();
                }
            });                       
            stage.show();

        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex);
        }
    }

    private void llenarTablaReportes() {

        List<ReporteMensual> listaReporteMensual = new ArrayList();
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        listaReporteMensual = reporteImp.getReportes(inscripcion.getSeguimiento().getIdSeguimiento());
        colNumeroReporte.setCellValueFactory(new PropertyValueFactory("numeroReporte"));
        colMes.setCellValueFactory(new PropertyValueFactory("mes"));
        colHoras.setCellValueFactory(new PropertyValueFactory("horasReportadas"));
        colEstado.setCellValueFactory(new PropertyValueFactory("estado"));

        ObservableList<ReporteMensual> observableListReporte = FXCollections.observableArrayList(listaReporteMensual);
        tablaReportes.setItems(observableListReporte);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
