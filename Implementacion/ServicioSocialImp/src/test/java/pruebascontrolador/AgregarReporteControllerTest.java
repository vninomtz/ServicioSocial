/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebascontrolador;

import controlador.AgregarReporteController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alanglezh
 */
public class AgregarReporteControllerTest {
    
    public AgregarReporteControllerTest() {
    }
    
    @Test
    public void isNumericTest(){
        AgregarReporteController controlador = new AgregarReporteController();
        boolean resultado = controlador.isNumeric("1");
        assertTrue(resultado);
    }
    
    
}
