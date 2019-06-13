/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasDocumentoDAO;

import dao.documentosDAO.DocumentosImp;
import java.util.List;
import modelo.Documento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Vik-t
 */
public class DaoDocumentoTest {
    
    public DaoDocumentoTest() {
    }
    
    
    @Test
    public void getDocumentosTest() {
        DocumentosImp documentos = new DocumentosImp();
        List<Documento> listaDoc = documentos.getDocumentos(1);
        assertNotNull(listaDoc);
    }
    
    @Test
    public void actualizarEstadoDocumentoTest() {
        DocumentosImp documentos = new DocumentosImp();
        boolean respuesta = documentos.actualizarEstadoDocumento("Validado", 14);
        assertTrue(respuesta);
    }
     
}
