/**
 * Autor: Juan Carlos Suarez Hernández
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 12/06/2019
 * Descripción: Controlador de la interfazRegistrar Responsable
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.responsableProyectoDAO.ResponsableProyectoImp;
import dao.unidadReceptoraDAO.UnidadReceptoraImp;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import modelo.ResponsableProyecto;
import modelo.UnidadReceptora;

public class RegistrarResponsableController {
    
    //Atrinutos de la interfaz
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private JFXButton botonCancelar;

    @FXML
    private JFXButton botonGuardar;

    @FXML
    private JFXComboBox<UnidadReceptora> comboUnidadReceptora;

    //Lista Observable de Unidades Receptoras
    @FXML
    private ObservableList<UnidadReceptora> listaUnidadesR;

    /**
     * Descripciòn: metodo utilizado para cargar el combo que se utiliza en la interfaz
     */
    public void cargarCombo() {
        
        UnidadReceptoraImp unidadReceptoraDAO = new UnidadReceptoraImp();
        List<UnidadReceptora> listaAuxiliar;
        listaAuxiliar = unidadReceptoraDAO.getUnidadesReceptoras();
        listaUnidadesR = FXCollections.observableArrayList();

        for (UnidadReceptora unidarReceptora : listaAuxiliar) {

            listaUnidadesR.add(unidarReceptora);

        }

        comboUnidadReceptora.setItems(listaUnidadesR);
    }

    
    /**
     * Desripciòn: Metodo utilizado como momento de acciòn para cunado el actor da clic en el 
     * botonCancelar de la interfaz, cierra la interfaz
     * @param event 
     */
    @FXML
    public void cancelar(ActionEvent event) {
        Stage ventana = (Stage) botonCancelar.getScene().getWindow();
        ventana.close();
    }

    /**
     * Descripciòn:Metodo utilizado como momento de acciòn para cunado el actor da clic en el 
     * botonGuardar de la interfaz, guarda el responsable del proyecto
     * @param event 
     */
    @FXML
    public void guardar(ActionEvent event) {

        if ((textoNombre.getText().equals("") != true) && (textoPaterno.getText().equals("") != true)
                && (textoMaterno.getText().equals("") != true) && (textoCargo.getText().equals("")
                != true) && (textoCorreo.getText().equals("") != true)
                && (comboUnidadReceptora.getValue() != null)) {

            ResponsableProyecto responsableProyecto = new ResponsableProyecto();
            responsableProyecto.setCargo(textoCargo.getText());
            responsableProyecto.setCorreoElectronico(textoCorreo.getText());
            responsableProyecto.setMaterno(textoMaterno.getText());
            responsableProyecto.setPaterno(textoPaterno.getText());
            responsableProyecto.setNombre(textoNombre.getText());
            responsableProyecto.setUnidadReceptora(comboUnidadReceptora.getValue());

            ResponsableProyectoImp responsableProyectoDAO = new ResponsableProyectoImp();
            responsableProyectoDAO.guardarResponsable(responsableProyecto);

            Stage ventana = (Stage) botonGuardar.getScene().getWindow();
            ventana.close();

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Rellene todos los campos");
            alert.showAndWait();

        }

    }

    @FXML
    void initialize() {
        cargarCombo();
    }
}
