/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasreportemensualDAO;

import dao.reportemensualDAO.ReporteMensualImp;
import java.util.ArrayList;
import java.util.List;
import modelo.ReporteMensual;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alanglezh
 */
public class DaoReporteMensualTest {

    public DaoReporteMensualTest() {
    }

    @Test
    public void getReportesTest() {
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        List<ReporteMensual> resultado = reporteImp.getReportes(1);
        List<ReporteMensual> resultadoEsperado = new ArrayList();
        assertEquals(resultado, resultadoEsperado);

    }

    @Test

    public void cambiarEstadoTest() {
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        boolean resultado = reporteImp.cambiarEstado("Rechazado", 1);
        assertTrue(resultado);

    }

    @Test
    public void guardarReporteTest() {
        ReporteMensual reporte = new ReporteMensual();
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        reporte.setIdSeguimiento(2);
        boolean resultado = reporteImp.guardarReporte(reporte);
        assertTrue(resultado);

    }

    @Test
    public void obtenerUltimoReporte() {
        ReporteMensualImp reporteImp = new ReporteMensualImp();
        int resultado = reporteImp.obtenerUltimoReporte(3);
        assertEquals(resultado, 0);
    }

}
