/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import dao.DocumentosDAO.DocumentosImp;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.Documento;
import modelo.Inscripcion;
import serviciosocial.main.MainApp;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class VerDocumentosController implements Initializable {

    @FXML
    private TableView<Documento> tablaDocumentos;
    @FXML
    private TableColumn<Documento, String> colTipoDoc;
    @FXML
    private TableColumn<Documento, String> colEstadoDoc;
    @FXML
    private TableColumn<Documento, String> colFechaDoc;
    @FXML
    private JFXButton btnAgregarDocumento;
    @FXML
    private JFXButton btnValidarDocumento;
    @FXML
    private JFXButton btnRegresar;
    @FXML
    private MenuItem mtAdministrarEstudiantes;
    @FXML
    private MenuItem mtAdministrarServicioSocial;
    @FXML
    private MenuItem mtSalirCuenta;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXComboBox<?> cbEstadoDoc;
    @FXML
    private JFXComboBox<?> cbTipoDoc;
    @FXML
    private Label lbMatricula;
    @FXML
    private Label lbEstudiante;
    private Inscripcion inscripcionEstudiante;

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcionEstudiante = inscripcion;
        lbMatricula.setText(inscripcionEstudiante.getEstudiante().getMatricula());
        lbEstudiante.setText(inscripcionEstudiante.getEstudiante().toString());
        llenarTablaDocumentos();

    }
    
    @FXML
    private void clicBtSalirCuenta() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Salir del sistema");
        alert.setContentText("¿Estás seguro de que quieres salir?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
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
                Stage principal = (Stage) btnRegresar.getScene().getWindow();
                principal.close();
            } catch (IOException ex) {
                 System.out.println("Error al mostrar la ventana:" + ex.getMessage());
            }
      }

    }

    @FXML
    private void ventanaMenuPrincipal() {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/MenuPrincipal.fxml"));
        try {
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Servicio Social");
            stage.getIcons().add(new Image("/fxml/img/User1.png"));
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            Stage principal = (Stage) btnRegresar.getScene().getWindow();
            principal.close();
        } catch (IOException ex) {
            Logger.getLogger(VerDocumentosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ventanaAgregarDocumento() {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/AgregarDocumento.fxml"));
        try {
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            Stage stage = new Stage();
            stage.setTitle("Agregar Documento");
            stage.getIcons().add(new Image("/fxml/img/addDocumento.png"));
            AgregarDocumentoController controller = (AgregarDocumentoController) loader.getController();
            controller.setInscripcion(inscripcionEstudiante);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.alwaysOnTopProperty();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    llenarTablaDocumentos();
                }
            });
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(VerDocumentosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ventanaValidarDocumento() {
        Documento documento = tablaDocumentos.getSelectionModel().getSelectedItem();
        if (documento != null) {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/ValidarDocumento.fxml"));
            try {
                AnchorPane anchorpane = loader.load();
                Scene scene = new Scene(anchorpane);
                Stage stage = new Stage();
                stage.setTitle("Validar Documento");
                stage.getIcons().add(new Image("/fxml/img/addDocumento.png"));
                ValidarDocumentoController controller = (ValidarDocumentoController) loader.getController();
                controller.setDocumento(documento);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.alwaysOnTopProperty();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setOnHidden(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        llenarTablaDocumentos();
                    }
                });
                stage.show();
                try {
                    File path = new File (documento.getLink());
                    Desktop.getDesktop().open(path);
                }catch (IOException ex) {
                     System.out.println("No se pudo abrir el documento:" +  ex.getMessage());
                }
            } catch (IOException ex) {
                Logger.getLogger(VerDocumentosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Advertencia");
                alert.setHeaderText("Seleccione un documento primero");
                alert.showAndWait();
        }
    }

    public void llenarTablaDocumentos() {
        DocumentosImp documentoimp = new DocumentosImp();
        //List<Documento> listadoc = documentoimp.getDocumentos(inscripcionEstudiante.getSeguimiento().getIdSeguimiento());
        inscripcionEstudiante.getSeguimiento().setListaDocumentos(documentoimp.getDocumentos(inscripcionEstudiante.getSeguimiento().getIdSeguimiento()));
        colTipoDoc.setCellValueFactory(new PropertyValueFactory("tipo"));
        colEstadoDoc.setCellValueFactory(new PropertyValueFactory("estado"));
        colFechaDoc.setCellValueFactory(new PropertyValueFactory("fecha"));

        ObservableList<Documento> observableList = FXCollections.observableArrayList(inscripcionEstudiante.getSeguimiento().getListaDocumentos());

        tablaDocumentos.setItems(observableList);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
