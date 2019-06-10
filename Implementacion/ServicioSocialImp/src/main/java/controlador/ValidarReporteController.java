/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    

    @FXML
    private void clicBtAprobar() {
        ReporteMensualImp reporteimp = new ReporteMensualImp();
        reporteimp.cambiarEstado("Validado", reporte.getIdReporteMensual());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reporte Aprobado");
        alert.setHeaderText("El reporte se aprobo Exitosamente");
        alert.showAndWait();
        Stage principal = (Stage) btnSalir.getScene().getWindow();
        principal.close();
    }

    private void iniciaInterfaz() {
        txtNumeroReporte.setText(Integer.toOctalString(reporte.getNumeroReporte()));
        txtMes.setText(reporte.getMes());
        txthoras.setText(Integer.toString(reporte.getHorasReportadas()));

        txtNumeroReporte.setDisable(true);
        txtMes.setDisable(true);
        txthoras.setDisable(true);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
