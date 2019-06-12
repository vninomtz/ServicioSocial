/**
 * Autor: Victor Manuel Niño Martínez
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 11/06/2019
 * Descripción: Controlador de la interfaz MenuPrincipal.fxml
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.inscripcionDAO.InscripcionImp;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.Inscripcion;
import serviciosocial.main.MainApp;

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

    /**
     * Método que regresa a la interfaz inicioSesion.fxml
     */
    @FXML
    private void clicBtSalirCuenta() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Salir del sistema");
        alert.setContentText("¿Estás seguro de que quieres salir?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/InicioSesion.fxml"));
            try {
                AnchorPane anchorpane = loader.load();
                Scene scene = new Scene(anchorpane);
                scene.getStylesheets().add("/styles/Styles.css");
                Stage stage = new Stage();
                stage.setTitle("Servicio Social - Inicio Sesion");
                stage.getIcons().add(new Image("/fxml/img/User1.png"));
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                Stage principal = (Stage) btnVerDocumentos.getScene().getWindow();
                principal.close();
            } catch (IOException ex) {
                System.out.println("Error al mostrar la ventana:" + ex.getMessage());
            }
        }

    }

    /**
     * Metodo que abre el stage VerReportes.fxml
     */
    @FXML
    private void clicBtVerReportes() {
        try {
            Inscripcion inscripcion = tablaEstudiantes.getSelectionModel().getSelectedItem();
            if (inscripcion != null) {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/VerReportes.fxml"));
                AnchorPane anchorpane = loader.load();
                Scene scene = new Scene(anchorpane);
                scene.getStylesheets().add("/styles/Styles.css");
                Stage stage = new Stage();
                stage.setTitle("Reportes Mensuales");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                VerReportesController controller = (VerReportesController) loader.getController();
                controller.setInscripcion(inscripcion);
                stage.show();
                Stage principal = (Stage) btnVerReportesMensuales.getScene().getWindow();
                principal.close();
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Advertencia");
                alert.setHeaderText("Seleccione un estudiante primero");
                alert.showAndWait();
            }

        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex);
        }
    }

    /**
     * Método que abre el stage VerDocumentos.fxml
     */
    @FXML
    private void clicBtVerDocumentos() {
        try {
            Inscripcion inscripcion = tablaEstudiantes.getSelectionModel().getSelectedItem();
            if (inscripcion != null) {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/VerDocumentos.fxml"));
                AnchorPane anchorpane = loader.load();
                Scene scene = new Scene(anchorpane);
                scene.getStylesheets().add("/styles/Styles.css");
                Stage stage = new Stage();
                stage.setTitle("Documentos");
                stage.getIcons().add(new Image("/fxml/img/documento.png"));
                stage.setScene(scene);
                stage.setResizable(false);
                VerDocumentosController controller = (VerDocumentosController) loader.getController();
                controller.setInscripcion(inscripcion);
                stage.show();
                Stage principal = (Stage) btnVerDocumentos.getScene().getWindow();
                principal.close();
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Advertencia");
                alert.setHeaderText("Seleccione un estudiante primero");
                alert.showAndWait();
            }

        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex);
        }
    }

    /**
     * Método que llena la tabla estudiantes con Objetos de tipo Inscripcion
     */
    private void llenarTablaEstudiantes() {
        InscripcionImp inscripcionImp = new InscripcionImp();
        listaInscripciones = inscripcionImp.getInscripciones();
        if (listaInscripciones != null) {
            colMatricula.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Inscripcion, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Inscripcion, String> inscripcion) {
                    if (inscripcion.getValue() != null) {
                        return new SimpleStringProperty(inscripcion.getValue().getEstudiante().getMatricula());
                    } else {
                        return new SimpleStringProperty("<no name>");
                    }
                }

            });
            colNombre.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Inscripcion, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Inscripcion, String> inscripcion) {
                    if (inscripcion.getValue() != null) {
                        return new SimpleStringProperty(inscripcion.getValue().getEstudiante().toString());
                    } else {
                        return new SimpleStringProperty("<no name>");
                    }
                }

            });

            colProgramaEducativo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Inscripcion, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Inscripcion, String> inscripcion) {
                    if (inscripcion.getValue() != null) {
                        return new SimpleStringProperty(inscripcion.getValue().getEstudiante().getProgramaEducativo());
                    } else {
                        return new SimpleStringProperty("<no name>");
                    }
                }
            });

            ObservableList<Inscripcion> observableList
                    = FXCollections.observableArrayList(listaInscripciones);
            tablaEstudiantes.setItems(observableList);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarTablaEstudiantes();

    }

}
