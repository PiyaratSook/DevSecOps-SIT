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
public class UserTest {
    
    public UserTest() {
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
     * Test of getNombre method, of class User.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        User instance = new User();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class User.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        User instance = new User();
        instance.setNombre(nombre);
    }

    /**
     * Test of getApellidos method, of class User.
     */
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        User instance = new User();
        String expResult = "";
        String result = instance.getApellidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setApellidos method, of class User.
     */
    @Test
    public void testSetApellidos() {
        System.out.println("setApellidos");
        String apellidos = "";
        User instance = new User();
        instance.setApellidos(apellidos);
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new User();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        User instance = new User();
        instance.setId(id);
    }

    /**
     * Test of getCorreo method, of class User.
     */
    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
        User instance = new User();
        String expResult = "";
        String result = instance.getCorreo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCorreo method, of class User.
     */
    @Test
    public void testSetCorreo() {
        System.out.println("setCorreo");
        String correo = "";
        User instance = new User();
        instance.setCorreo(correo);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User();
        instance.setPassword(password);
    }
    
}
