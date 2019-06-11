/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.DocumentosDAO;

import java.util.List;
import modelo.Documento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vik-t
 */
public class DocumentosImpTest {
    
    public DocumentosImpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDocumentos method, of class DocumentosImp.
     */
    @Test
    public void testGetDocumentos() {
        System.out.println("getDocumentos");
        int idSeguimiento = 0;
        DocumentosImp instance = new DocumentosImp();
        List<Documento> expResult = null;
        List<Documento> result = instance.getDocumentos(idSeguimiento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
