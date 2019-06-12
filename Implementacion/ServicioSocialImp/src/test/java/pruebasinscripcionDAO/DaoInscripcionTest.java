/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasinscripcionDAO;

import dao.inscripcionDAO.InscripcionImp;
import java.util.ArrayList;
import java.util.List;
import modelo.Inscripcion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alanglezh
 */
public class DaoInscripcionTest {

    public DaoInscripcionTest() {
    }

    @Test
    public void getInscripcionesTest() {
        InscripcionImp inscripcion = new InscripcionImp();
        List<Inscripcion> resultado = inscripcion.getInscripciones();
        assertNotNull(resultado);

    }

    @Test
    public void getInscripcionTest() {
        InscripcionImp inscripcion = new InscripcionImp();
        List<Inscripcion> resultado = inscripcion.getInscripcion(3);
        assertEquals(resultado.get(0).getFolioInscripcion(), 6);
    }

}
