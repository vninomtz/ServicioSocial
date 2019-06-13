/**
 * Autor: Juan Carlos Suarez Hernández
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 12/06/2019
 * Descripción: Controlador de la interfaz Registrar plan de actividades
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dao.registroPlanActividadesDAO.RegistroPlanActividadesImp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Inscripcion;
import modelo.RegistroPlanActividades;
import modelo.ResponsableProyecto;
import serviciosocial.main.MainApp;

public class RegistrarPlanRAController {

    //elementos de la interfaz y el controlador
    private Inscripcion inscripcion;
    private ResponsableProyecto responsable;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelMatricula;

    @FXML
    private JFXTextField textoNombreProyecto;

    @FXML
    private JFXTextField textoDuracion;

    @FXML
    private JFXTextArea textoDescripcion;

    @FXML
    private JFXTextField textoResponsabilidades;

    @FXML
    private JFXTextField textoHorario;

    @FXML
    private JFXTextField textoNombre;

    @FXML
    private JFXTextField textoPaterno;

    @FXML
    private JFXTextField textoMaterno;

    @FXML
    private JFXTextField textoCargo;

    @FXML
    private JFXTextField textoCorreo;

    @FXML
    private JFXButton botonSeleccionarResponsable;

    @FXML
    private JFXButton botonCancelar;

    @FXML
    private JFXButton botonGuardar;

    //set a elementos de la pantalla
    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
        labelNombre.setText("Nombre: " + this.inscripcion.getEstudiante().getNombre()
                + " " + this.inscripcion.getEstudiante().getPaterno() + " "
                + this.inscripcion.getEstudiante().getMaterno());
        labelMatricula.setText("Matricula: " + this.inscripcion.getEstudiante().getMatricula());
    }

    //Set a elemento del controlador
    public void setResponsable(ResponsableProyecto responsable) {
        this.responsable = responsable;
    }

    /**
     * @Descripción: Metodo para cargar los datos del responsable seleccionado
     */
    public void cargarDatosResponsable() {

        try {

            textoNombre.setText(this.responsable.getNombre());
            textoPaterno.setText(this.responsable.getPaterno());
            textoMaterno.setText(this.responsable.getMaterno());
            textoCargo.setText(this.responsable.getCargo());
            textoCorreo.setText(this.responsable.getCorreoElectronico());

            textoNombre.setEditable(false);
            textoPaterno.setEditable(false);
            textoMaterno.setEditable(false);
            textoCargo.setEditable(false);
            textoCorreo.setEditable(false);

        } catch (NullPointerException e) {//Excepcion en caso de que se cancele la accion de seleccion

            System.out.println("Aun no se selecciona un responsable");

        }

    }

    /**
     * @Descripción: que desarroya la misma acción que los demas botones
     * @param event
     */
    @FXML
    void cancelar(ActionEvent event) {
        Stage ventana = (Stage) botonCancelar.getScene().getWindow();
        ventana.close();
    }

    /**
     * @Descripción: metodo para abrir y cargar la ventana para seleccionar el responsable de
     * proyecto
     * @param event
     */
    @FXML
    private void mostrarVentanaSeleccion(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/SeleccionarResponsable.fxml"));
            AnchorPane anchorpane = loader.load();
            Scene scene = new Scene(anchorpane);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage stage = new Stage();
            stage.setTitle("Selección Responsable");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.alwaysOnTopProperty();
            stage.initModality(Modality.APPLICATION_MODAL);
            SeleccionarResponsableController controller
                    = (SeleccionarResponsableController) loader.getController();
            controller.setController(this);
            stage.showAndWait();
            cargarDatosResponsable();

        } catch (IOException ex) {
            System.out.println("Error al mostrar ventana Ventas: " + ex);
        }
    }

    /**
     * @Descripción: Metodo para guardar el plan y registro de actividades una ves completado todo
     * lo que dice el caso de uso
     * @param event
     */
    @FXML
    public void guardar(ActionEvent event) {

        if ((textoNombreProyecto.getText().equals("") != true) && (textoDuracion.getText().equals("")
                != true) && (textoHorario.getText().equals("") != true)
                && (textoResponsabilidades.getText().equals("") != true) && (textoDescripcion.getText().equals("") != true) && (this.responsable != null)) {

            RegistroPlanActividades registroPlanA = new RegistroPlanActividades();
            registroPlanA.setDescripcion(textoDescripcion.getText());
            registroPlanA.setDuracion(textoDuracion.getText());
            registroPlanA.setHorario(textoHorario.getText());
            registroPlanA.setNombre(textoNombreProyecto.getText());
            registroPlanA.setResponsabilidades(textoResponsabilidades.getText());
            registroPlanA.setIdseguimiento(this.inscripcion.getSeguimiento().getIdSeguimiento());
            registroPlanA.setResponsableProyecto(this.responsable);

            RegistroPlanActividadesImp registroPlanActividadesDAO = new RegistroPlanActividadesImp();

            if (registroPlanActividadesDAO.guardarRegistroPlanActividades(registroPlanA) == true) {

                Stage ventana = (Stage) botonGuardar.getScene().getWindow();
                ventana.close();

            }
            
        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Rellene todos los campos");
            alert.showAndWait();

        }

    }

    @FXML
    void initialize() {

        textoNombre.setEditable(false);
        textoPaterno.setEditable(false);
        textoMaterno.setEditable(false);
        textoCargo.setEditable(false);
        textoCorreo.setEditable(false);

    }
}
