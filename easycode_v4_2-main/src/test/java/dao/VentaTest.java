/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jorge
 */
public class VentaTest {
    
    public VentaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId_venta method, of class Venta.
     */
    @Test
    public void testGetId_venta() {
        System.out.println("getId_venta");
        Venta instance = new Venta();
        int expResult = -1;
        int result = instance.getId_venta();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_venta method, of class Venta.
     */
    @Test
    public void testSetId_venta() {
        System.out.println("setId_venta");
        int id_venta = 0;
        Venta instance = new Venta();
        instance.setId_venta(id_venta);
    }

    /**
     * Test of getId_curso method, of class Venta.
     */
    @Test
    public void testGetId_curso() {
        System.out.println("getId_curso");
        Venta instance = new Venta();
        int expResult = -1;
        int result = instance.getId_curso();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_curso method, of class Venta.
     */
    @Test
    public void testSetId_curso() {
        System.out.println("setId_curso");
        int id_curso = 0;
        Venta instance = new Venta();
        instance.setId_curso(id_curso);
    }

    /**
     * Test of getFecha_venta method, of class Venta.
     */
    @Test
    public void testGetFecha_venta() {
        System.out.println("getFecha_venta");
        Venta instance = new Venta();
        String expResult = "";
        String result = instance.getFecha_venta();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFecha_venta method, of class Venta.
     */
    @Test
    public void testSetFecha_venta() {
        System.out.println("setFecha_venta");
        String fecha_venta = "";
        Venta instance = new Venta();
        instance.setFecha_venta(fecha_venta);
    }

    /**
     * Test of getId_usuario method, of class Venta.
     */
    @Test
    public void testGetId_usuario() {
        System.out.println("getId_usuario");
        Venta instance = new Venta();
        int expResult = -1;
        int result = instance.getId_usuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_usuario method, of class Venta.
     */
    @Test
    public void testSetId_usuario() {
        System.out.println("setId_usuario");
        int id_usuario = 0;
        Venta instance = new Venta();
        instance.setId_usuario(id_usuario);
    }
    
}
