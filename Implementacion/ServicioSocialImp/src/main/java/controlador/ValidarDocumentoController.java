/**
 * Autor: Victor Manuel Niño Martínez
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 11/06/2019
 * Descripción: Controlador de la interfaz ValidarDocumento.fxml
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dao.documentosDAO.DocumentosImp;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import modelo.Documento;

/**
 * FXML Controller class
 *
 * @author Vik-t
 */
public class ValidarDocumentoController implements Initializable {

    private final String RECHAZAR = "Rechazado";
    private final String VALIDAR = "Validado";
    @FXML private JFXTextArea txtDescripcionDoc;
    @FXML private JFXButton btnCancelar;
    @FXML private JFXButton btnValidar;
    @FXML private JFXTextField txtTipoDoc;
    @FXML private JFXButton btnRechazar;
    @FXML private JFXTextField txtEstadoDoc;
    @FXML private JFXTextField txtFechaDoc;
    private Documento documento;

     /**
     * Método que recibe un objeto del stage VerDocumentos
     * @param documento objeto de tipo Documento
     */
    public void setDocumento(Documento documento) {
        this.documento = documento;
        txtTipoDoc.setText(documento.getTipo());
        txtDescripcionDoc.setText(documento.getDescripcion());
        txtEstadoDoc.setText(documento.getEstado());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        txtFechaDoc.setText(format.format(documento.getFecha()));
    }
    
    /**
     * Método que cierra el stage ValidarDocumento.fxml
     */
    @FXML
    private void clicCancelar() {
        Stage ventana = (Stage)btnCancelar.getScene().getWindow();
        ventana.close();
    }
    
    /**
     * Método que cambia el estado del Documento a Validado 
     */
    @FXML
    private void clicBtnValidar() {
        DocumentosImp documentoImp = new DocumentosImp();
        if(documentoImp.actualizarEstadoDocumento(VALIDAR, documento.getIdDocumento())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Actualizacion Exitosa");
            alert.setHeaderText("Se cambio el estado del documento a VALIDADO");
            alert.showAndWait();
            Stage ventana = (Stage)btnCancelar.getScene().getWindow();
            ventana.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Actualizacion Fallida");
            alert.setHeaderText("No se pudo actualizar el estado del documento,"
                    + "intentelo más tarde");
            alert.showAndWait();
        }
    }
    
    /**
     * Método que cambia el estado del Documento a Rechazado
     */
    @FXML
    private void clicBtnRechazar() {
        DocumentosImp documentoImp = new DocumentosImp();
        if(documentoImp.actualizarEstadoDocumento(RECHAZAR, documento.getIdDocumento())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Actualizacion Exitosa");
            alert.setHeaderText("Se cambio el estado del documento a RECHAZADO");
            alert.showAndWait();
            Stage ventana = (Stage)btnCancelar.getScene().getWindow();
            ventana.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Actualizacion Fallida");
            alert.setHeaderText("No se pudo actualizar el estado del documento,"
                    + "intentelo más tarde");
            alert.showAndWait();
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }        
}
