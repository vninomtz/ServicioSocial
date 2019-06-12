/**
 * Autor: Alan González Heredia
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 11/06/2019
 * Descripción: Controlador de la interfaz AgregarReporte.fxml
 */
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.reportemensualDAO.ReporteMensualImp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelo.Inscripcion;
import modelo.ReporteMensual;

/**
 * FXML Controller class
 *
 * @author alanglezh
 */
public class AgregarReporteController implements Initializable {

    private Inscripcion inscripcion;

    @FXML
    private JFXTextField txtNumeroReporte;
    @FXML
    private JFXComboBox cbxMes;
    @FXML
    private JFXButton btCargarReporte;
    @FXML
    private JFXButton btSalir;
    @FXML
    private JFXButton btGuardar;
    @FXML
    private Label lbArchivoAdjunto;
    @FXML
    private JFXTextField txtHoras;
    File archivo = null;
    int numeroUltimoReporte;

    public void setReporte(int numeroReporte) {
        this.numeroUltimoReporte = numeroReporte;
        llenarCbxNumeroReporte();

    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    /**
     * Llena el combo bx cbxMes con los nombres de los meses
     */
    private void llenarCbMes() {
        List<String> listaMes = new ArrayList();
        listaMes.add("Enero");
        listaMes.add("Febrero");
        listaMes.add("Marzo");
        listaMes.add("Abril");
        listaMes.add("Mayo");
        listaMes.add("Junio");
        listaMes.add("Julio");
        listaMes.add("Agosto");
        listaMes.add("Septiembre");
        listaMes.add("Ocutbre");
        listaMes.add("Noviembre");
        listaMes.add("Diciembre");

        ObservableList<String> obsevableListaTipoOpe
                = FXCollections.observableArrayList(listaMes);
        cbxMes.setItems(obsevableListaTipoOpe);
    }

    private void llenarCbxNumeroReporte() {
        txtNumeroReporte.setText(Integer.toString(numeroUltimoReporte + 1));
        txtNumeroReporte.setEditable(false);

    }

    /**
     * Metodo que copia un documento y lo retorna
     *
     * @return FIle documento nuevo
     */
    public File guardarDocumento() {
        Path origen = Paths.get(archivo.getAbsolutePath());
        Path destino = Paths.get("src\\main\\resources\\fxml\\reportesmensuales\\" + archivo.getName());
        try {
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return null;
        }
        return destino.toFile();
    }

    /**
     * Abre el explorador de archivos para cargar uno
     */
    @FXML
    private void clicBtCargar() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
        archivo = fileChooser.showOpenDialog(stage);
        if (archivo != null) {
            lbArchivoAdjunto.setText(archivo.getName());

        }

    }

    /**
     * Valida si una cadena tiene numeros
     *
     * @param str Texto del txtHoras
     * @return Verdadero si es numero
     */
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Metodo que valida los datos introducidos por el usuario
     *
     * @return true si los dato son validos
     */
    public boolean validarDatos() {

        if (cbxMes.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Seleccionar un mes antes de guardar");
            alert.showAndWait();
            return false;
        } else if (txtHoras.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Ingresar las horas antes de guardar");
            alert.showAndWait();
            return false;
        } else if (!isNumeric(txtHoras.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Por favor ingrese datos validos en horas");
            alert.showAndWait();
            return false;
        } else if (archivo == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerta");
            alert.setHeaderText("Por favor seleccione un reporte");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    /**
     * Metodo que guardar un objeto ReporteMensual en la base de datos
     */
    public void guardarReporte() {
        File copiaArchivo = guardarDocumento();
        int horas = Integer.parseInt(txtHoras.getText());
        String numeroReporte = txtNumeroReporte.getText();
        String mes = (String) cbxMes.getValue();

        ReporteMensual reporte = new ReporteMensual();
        reporte.setNumeroReporte(Integer.parseInt(numeroReporte));
        reporte.setIdSeguimiento(inscripcion.getSeguimiento().getIdSeguimiento());
        reporte.setHorasReportadas(horas);
        reporte.setLink(copiaArchivo.getPath());
        reporte.setMes(mes);
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        if (reporteImp.guardarReporte(reporte)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exito");
            alert.setHeaderText("El reporte se ha guardado exitosamente");
            alert.showAndWait();
        }

    }

    /**
     * Ocurre cuando el usuario da clic e salir
     *
     */
    @FXML
    private void clicBtSalir() {
        Stage principal = (Stage) btSalir.getScene().getWindow();
        principal.close();
    }

    /**
     *
     */

    @FXML
    private void clicBtGuardar() {
        if (validarDatos()) {
            guardarReporte();
            Stage ventana = (Stage) btSalir.getScene().getWindow();
            ventana.close();
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        llenarCbMes();

    }

}
