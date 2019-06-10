/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public boolean cambiarEstado(String nuevoEstado,int idReporte);
    public boolean guardarReporte(ReporteMensual reporte);
        
    
        
    
}
