/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasIniciosesionDAO;

import dao.inicioSesion.InicioSesionImp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alanglezh
 */
public class DaoInicioSesionTest {

    public DaoInicioSesionTest() {
    }

    @Test
    public void isUsuarioRegistradoTest() {
        InicioSesionImp sesion = new InicioSesionImp();
        boolean resultado = sesion.isUsuarioRegistrado("alanHeredia", "54321");
        assertTrue(resultado);
    }
}
