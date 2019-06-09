/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.inscripcionDAO.InscripcionImp;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.Inscripcion;

/**
 * FXML Controller class
 *
 */
public class MenuPrincipalController implements Initializable {

    @FXML
    private TableView<Inscripcion> tablaEstudiantes;
    @FXML
    private TableColumn<Inscripcion, String> colMatricula;
    @FXML
    private TableColumn<Inscripcion, String> colNombre;
    @FXML
    private TableColumn<Inscripcion, String> colProgramaEducativo;
    @FXML
    private JFXButton btnVerDocumentos;
    @FXML
    private JFXButton btnVerReportesMensuales;
    @FXML
    private JFXButton btnRegistrarProyecto;
    @FXML
    private MenuItem mtAdministrarEstudiantes;
    @FXML
    private MenuItem mtAdministrarServicioSocial;
    @FXML
    private MenuItem mtSalirCuenta;
    @FXML
    private JFXTextField txtBuscarEstudiante;
    @FXML
    private JFXButton btnBuscar;

    private List<Inscripcion> listaInscripciones;

    private void llenarTablaEstudiantes() {
        InscripcionImp inscripcionImp = new InscripcionImp();
        listaInscripciones = inscripcionImp.getInscripciones();
        
        colMatricula.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Inscripcion, String>,
                ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Inscripcion, String> inscripcion) {
                if(inscripcion.getValue() != null) {
                    return new SimpleStringProperty(inscripcion.getValue().getEstudiante().getMatricula());
                } else {
                    return new SimpleStringProperty("<no name>");
                }
            }
                    
                });
        colNombre.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Inscripcion, String>,
                ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Inscripcion, String> inscripcion) {
                if(inscripcion.getValue() != null) {
                    return new SimpleStringProperty(inscripcion.getValue().getEstudiante().toString());
                } else {
                    return new SimpleStringProperty("<no name>");
                }
            }
                    
                });
        
        colProgramaEducativo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Inscripcion, String>,
                ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Inscripcion, String> inscripcion) {
                if(inscripcion.getValue() != null) {
                    return new SimpleStringProperty(inscripcion.getValue().getEstudiante().getProgramaEducativo());
                } else {
                    return new SimpleStringProperty("<no name>");
                }
            }
                    
                });
        
        ObservableList<Inscripcion> observableList = 
                FXCollections.observableArrayList(listaInscripciones);
        tablaEstudiantes.setItems(observableList);
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarTablaEstudiantes();
        
    }

}
