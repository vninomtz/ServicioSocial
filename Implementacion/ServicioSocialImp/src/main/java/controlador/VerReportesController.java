/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import dao.reportemensualDAO.ReporteMensualImp;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    
    private Inscripcion inscripcion;

    /**
     * Initializes the controller class.
     * @param inscripcion
     */
    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
        System.out.println(inscripcion.getEstudiante());
    }
    
    @FXML
    private void clicBtAgregarReporte() {
        try {
            if (inscripcion != null) {
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
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Advertencia");
                alert.setHeaderText("Seleccione un estudiante primero");
                
                alert.showAndWait();
            }
            
        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex);
        }
    }

    private void llenarTablaReportes() {
        ReporteMensualImp reporteMensualImp = new ReporteMensualImp();
        List<ReporteMensual> listaReportes
                = reporteMensualImp.getReportes(inscripcion.getSeguimiento().getIdSeguimiento());
        
        //colNumeroReporte.setCellValueFactory(new PropertyValueFactory("numeroReporte"));
        /*colMes.setCellValueFactory(new PropertyValueFactory("mes"));        
        colHoras.setCellValueFactory(new PropertyValueFactory("horasReportadas"));        
        colEstado.setCellValueFactory(new PropertyValueFactory("estado"));        
        
        ObservableList<ReporteMensual> observableList = FXCollections.observableArrayList(listaReportes);
        /*for (ReporteMensual reporte : listaReportes) {
            observableList.add(reporte);            
            
        }*/
        //tablaReportes.setItems(observableList);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //llenarTablaReportes();
    }    
    
}
