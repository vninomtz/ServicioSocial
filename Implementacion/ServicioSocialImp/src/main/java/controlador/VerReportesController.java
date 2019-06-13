/**
 * Autor: Alan González Heredia
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 11/06/2019
 * Descripción: Controlador de la interfaz VerReportes.fxml
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import dao.reportemensualDAO.ReporteMensualImp;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private JFXButton btnRegresar;
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
    @FXML
    private MenuItem mtAdministrarEstudiantes;
    @FXML
    private MenuItem mtAdministrarServicioSocial;
    @FXML
    private MenuItem mtSalirCuenta;
    @FXML
    private Label lbMatricula;
    @FXML
    private Label lbEstudiante;

    private Inscripcion inscripcion = new Inscripcion();

    /**
     * Método que recibe un objeto Inscripcion de la interfaz MenuPrincipal.fxml
     *
     * @param inscripcion objeto de tipo Inscripcion
     */
    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
        lbMatricula.setText(inscripcion.getEstudiante().getMatricula());
        lbEstudiante.setText(inscripcion.getEstudiante().toString());
        llenarTablaReportes();

    }

    /**
     * Método que muestra a la interfaz inicioSesion.fxml
     */
    @FXML
    private void clicBtSalirCuenta() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Salir del sistema");
        alert.setContentText("¿Estás seguro de que quieres salir?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/InicioSesion.fxml"));
            try {
                AnchorPane anchorpane = loader.load();
                Scene scene = new Scene(anchorpane);
                //scene.getStylesheets().add("/styles/Styles.css");
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

    /**
     * Metodo que muestra la la ventana MenuPrincipal.fxm
     */
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

    /**
     * Muestra un archivo en pantalla, a partir de su ruta
     *
     * @param ruta contiene el path del archivo
     */
    private void mostrarPdf(String ruta) {
        try {
            File path = new File(ruta);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            System.out.println("No se pudo abrir el Reporte:" + ex.getMessage());
        }
    }

    /**
     * Metodo que recibe un reporte y muestra la ventana validar, enviando dicho
     * reporte
     *
     * @param reporte Objeto tipo ReporteMensual
     */
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
            mostrarPdf(reporte.getLink());

        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex);
        }
    }

    /**
     * Ocurre cuando el usuario da clic en el boton Validar Reporte, muestra la
     * ventana si se selecciono un reporte de la tabla
     */
    @FXML
    private void clicBtValidarReporte() {
        ReporteMensual reporte = (ReporteMensual) tablaReportes.getSelectionModel().getSelectedItem();
        if (reporte != null) {
            mostrarVentanaValidar(reporte);

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Seleccione un Reporte Mensual primero");
            alert.showAndWait();
        }
    }

    /**
     * Obtiene el numero del ultimo reporte asociado con el seguimiento de la
     * inscripcion correspondiente
     *
     * @return numero del ultimo reporte subido
     */
    private int obtenerUltimoReporte() {
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        int numero = reporteImp.obtenerUltimoReporte(inscripcion.getSeguimiento().getIdSeguimiento());
        System.out.println("Numero: " + numero);
        return numero;
    }

    /**
     * Ocurre cuando el usuario da clic el boton Agregar Reporte y muestra la
     * ventana AgregarReporte.fxml y cuandi se cierra se recarga la tabla de la
     * ventana actual .
     */
    @FXML
    private void clicBtAgregarReporte() {
        try {

            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/AgregarReporte.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Agregar Reporte");
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

    /**
     * Asigna los valores correspondientes a las columnas de la tabla con la
     * informacion de los reportes
     */
    private void llenarTablaReportes() {

        List<ReporteMensual> listaReporteMensual = new ArrayList();
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        listaReporteMensual = reporteImp.getReportes(inscripcion.getSeguimiento().getIdSeguimiento());
        if (listaReporteMensual == null) {
            colNumeroReporte.setCellValueFactory(new PropertyValueFactory("numeroReporte"));
            colMes.setCellValueFactory(new PropertyValueFactory("mes"));
            colHoras.setCellValueFactory(new PropertyValueFactory("horasReportadas"));
            colEstado.setCellValueFactory(new PropertyValueFactory("estado"));

            ObservableList<ReporteMensual> observableListReporte = FXCollections.observableArrayList(listaReporteMensual);
            tablaReportes.setItems(observableListReporte);

        } else{
            System.out.println("Tabla vacia");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
