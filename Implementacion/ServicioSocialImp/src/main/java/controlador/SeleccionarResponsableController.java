/**
 * Autor: Juan Carlos Suarez Hernández
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 12/06/2019
 * Descripción: Controlador de la interfaz Seleccionar Responsable
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import dao.responsableProyectoDAO.ResponsableProyectoImp;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.ResponsableProyecto;
import serviciosocial.main.MainApp;

public class SeleccionarResponsableController {
    
    //atributos de la interfaz y del controlador
    private RegistrarPlanRAController controller;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ResponsableProyecto> tablaResponsables;

    @FXML
    private TableColumn<ResponsableProyecto, String> columnaNombre;

    @FXML
    private TableColumn<ResponsableProyecto, String> columnaPaterno;

    @FXML
    private TableColumn<ResponsableProyecto, String> columnaMaterno;

    @FXML
    private TableColumn<ResponsableProyecto, String> columnaCorreo;

    @FXML
    private TableColumn<ResponsableProyecto, String> columnaCargo;

    @FXML
    private JFXButton botonCancelar;

    @FXML
    private JFXButton botonAsignar;

    @FXML
    private JFXButton botonAgregarResponsable;

    //Lista Observable de Responsable de Proyecto
    @FXML
    private ObservableList<ResponsableProyecto> listaResponsables;

    //Metodo set del atributo del controlador
    public void setController(RegistrarPlanRAController nuevoController) {
        this.controller = nuevoController;
    }

    /**
     * Descripcón: Metodo para cragar la tabla de responsables del proyecto
     */
    public void cargarTabla() {

        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaPaterno.setCellValueFactory(new PropertyValueFactory<>("paterno"));
        columnaMaterno.setCellValueFactory(new PropertyValueFactory<>("materno"));
        columnaCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));

        ResponsableProyectoImp responsableProyectoDAO = new ResponsableProyectoImp();
        List<ResponsableProyecto> listaAuxiliar;
        listaAuxiliar = responsableProyectoDAO.getResponsables();
        listaResponsables = FXCollections.observableArrayList();

        for (ResponsableProyecto responsableP : listaAuxiliar) {

            listaResponsables.add(responsableP);

        }
        tablaResponsables.setItems(listaResponsables);

    }

    
    /**
     * @Descripción: Metodod del botón cancelar para cerrar la pantalla
     * @param event 
     */
    @FXML
    public void cancelar(ActionEvent event) {
        Stage ventana = (Stage) botonCancelar.getScene().getWindow();
        ventana.close();
    }
    /**
     * @Descripción: Metodo del botón Resgistrar Responsable que abre la ventana correspondiente al 
     * botón
     * @param event 
     */
    @FXML
    private void mostrarVentanaRegistroRP(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/RegistrarResponsable.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Resgistro Responsable Del Proyecto");
            stage.setScene(scene);
            stage.setResizable(false);
            RegistrarResponsableController controller
                    = (RegistrarResponsableController) loader.getController();
            stage.showAndWait();
            cargarTabla();

        } catch (IOException ex) {
            
            System.out.println("Error al mostrar ventana Ventas: " + ex);
        }
    }

    /**
     * @Descripción: Metodo para asignar responsable al proyecto
     * @param event 
     */
    @FXML
    public void asignarResponsableR(ActionEvent event) {

        if (tablaResponsables.getSelectionModel().getSelectedItem() != null) {

            this.controller.setResponsable(tablaResponsables.getSelectionModel().getSelectedItem());

            Stage ventana = (Stage) botonAsignar.getScene().getWindow();
            ventana.close();

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Seleccione un Responsable De Proyecto");
            alert.showAndWait();

        }
    }

    @FXML
    void initialize() {
        cargarTabla();
    }
}
