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
public class CursoTest {
    
    public CursoTest() {
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
     * Test of getDescripcion method, of class Curso.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Curso instance = new Curso();
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescripcion method, of class Curso.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Curso instance = new Curso();
        instance.setDescripcion(descripcion);
    }

    /**
     * Test of getId_curso method, of class Curso.
     */
    @Test
    public void testGetId_curso() {
        System.out.println("getId_curso");
        Curso instance = new Curso();
        int expResult = -1;
        int result = instance.getId_curso();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_curso method, of class Curso.
     */
    @Test
    public void testSetId_curso() {
        System.out.println("setId_curso");
        int id_curso = 0;
        Curso instance = new Curso();
        instance.setId_curso(id_curso);
    }

    /**
     * Test of getNombre method, of class Curso.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Curso instance = new Curso();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Curso.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Curso instance = new Curso();
        instance.setNombre(nombre);
    }

    /**
     * Test of getCosto method, of class Curso.
     */
    @Test
    public void testGetCosto() {
        System.out.println("getCosto");
        Curso instance = new Curso();
        float expResult = 0.0F;
        float result = instance.getCosto();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCosto method, of class Curso.
     */
    @Test
    public void testSetCosto() {
        System.out.println("setCosto");
        float costo = 0.0F;
        Curso instance = new Curso();
        instance.setCosto(costo);
    }

    /**
     * Test of getCategoria method, of class Curso.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        Curso instance = new Curso();
        String expResult = "";
        String result = instance.getCategoria();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategoria method, of class Curso.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        String categoria = "";
        Curso instance = new Curso();
        instance.setCategoria(categoria);
    }

    /**
     * Test of getTexto method, of class Curso.
     */
    @Test
    public void testGetTexto() {
        System.out.println("getTexto");
        Curso instance = new Curso();
        String expResult = "";
        String result = instance.getTexto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTexto method, of class Curso.
     */
    @Test
    public void testSetTexto() {
        System.out.println("setTexto");
        String texto = "";
        Curso instance = new Curso();
        instance.setTexto(texto);
    }
    
}
