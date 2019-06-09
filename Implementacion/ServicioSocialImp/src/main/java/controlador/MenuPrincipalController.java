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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Estudiante;
import modelo.Inscripcion;

/**
 * FXML Controller class
 *
 */
public class MenuPrincipalController implements Initializable {

    @FXML
    private TableView<Estudiante> tablaEstudiantes;
    @FXML
    private TableColumn<Estudiante, String> colMatricula;
    @FXML
    private TableColumn<Estudiante, String> colNombre;
    @FXML
    private TableColumn<Estudiante, String> colProgramaEducativo;
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
        colMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colProgramaEducativo.setCellValueFactory(new PropertyValueFactory("programaEducativo"));

        ObservableList<Estudiante> observableList = FXCollections.observableArrayList();
        listaInscripciones.forEach((lista) -> {
            observableList.add(lista.getEstudiante());
        });
        tablaEstudiantes.setItems(observableList);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarTablaEstudiantes();
    }

}
