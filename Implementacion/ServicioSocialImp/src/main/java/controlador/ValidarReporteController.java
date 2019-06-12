/**
 * Autor: Alan González Heredia
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 11/06/2019
 * Descripción: Controlador de la interfaz ValidarReporte.fxml
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.reportemensualDAO.ReporteMensualImp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import modelo.ReporteMensual;

/**
 * FXML Controller class
 *
 * @author alanglezh
 */
public class ValidarReporteController implements Initializable {

    @FXML
    private JFXButton btnAprobar;
    @FXML
    private JFXButton btnRechazar;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXTextField txtNumeroReporte;
    @FXML
    private JFXTextField txtMes;
    @FXML
    private JFXTextField txthoras;

    private ReporteMensual reporte = new ReporteMensual();

    public void setReporte(ReporteMensual reporte) {
        this.reporte = reporte;
        iniciaInterfaz();
    }
    
    /**
     * Ocurre cuando el usuario da clic en el boton aprobar, cambia el estado del 
     * reporte a "Validado"
     */

    @FXML
    private void clicBtAprobar() {
        ReporteMensualImp reporteimp = new ReporteMensualImp();
        reporteimp.cambiarEstado("Validado", reporte.getIdReporteMensual());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reporte Aprobado");
        alert.setHeaderText("Se cambio el estado del reporte ha validado");
        alert.showAndWait();
        Stage principal = (Stage) btnSalir.getScene().getWindow();
        principal.close();
    }
    
    /**
     * Ocurre cuando el usuario da clic en el boton aprobar, cambia el estado del 
     * reporte a "Validado"
     */

    @FXML
    private void clicBtRechazar() {
        ReporteMensualImp reporteimp = new ReporteMensualImp();
        reporteimp.cambiarEstado("Rechazado", reporte.getIdReporteMensual());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reporte Reachazo");
        alert.setHeaderText("Se cambio el estado del reporte ha rechazado");
        alert.showAndWait();
        Stage principal = (Stage) btnSalir.getScene().getWindow();
        principal.close();
    }
    
    /**
     * Ocurre cuando el usuario da clic en el boton salir 
     */
    @FXML
    private void clicBtnSalir() {
        Stage principal = (Stage) btnSalir.getScene().getWindow();
        principal.close();
    }

    private void iniciaInterfaz() {
        txtNumeroReporte.setText(Integer.toOctalString(reporte.getNumeroReporte()));
        txtMes.setText(reporte.getMes());
        txthoras.setText(Integer.toString(reporte.getHorasReportadas()));

        txtNumeroReporte.setEditable(false);
        txtMes.setEditable(false);
        txthoras.setEditable(false);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
