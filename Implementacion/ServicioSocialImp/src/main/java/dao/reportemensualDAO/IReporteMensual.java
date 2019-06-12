/**
 * Autor: Alan González Heredia
 * Experiencia Educativa: Principios de Construcción de Software
 * Docente: Fredy Castañeda Sánchez
 * Fecha de creación: 10/06/2019
 * Fecha de ultima actualización: 11/06/2019
 * Descripción: Interfaz IReporteMensual.java
 */
package dao.reportemensualDAO;

import java.util.List;
import modelo.ReporteMensual;

/**
 *
 * @author alanglezh
 */
public interface IReporteMensual {

    public List<ReporteMensual> getReportes(int idSeguimiento);

    public boolean cambiarEstado(String nuevoEstado, int idReporte);

    public boolean guardarReporte(ReporteMensual reporte);

    public int obtenerUltimoReporte(int idseguimiento);

}
