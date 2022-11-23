/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empleado;
import static Principal.main.calendar;
import static Principal.main.getDateCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alumno
 */
  
    
public class EmpleadoDAOlmplTest {
    public static Calendar calendar = new GregorianCalendar();
    
    public static Date getDateCalendar(){
        return calendar.getTime();
    }
    public EmpleadoDAOlmplTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    @org.junit.jupiter.api.Test
    public void testCalcularEdad() {
        System.out.println("CalcularEdad");
         calendar.set(2002,8,5);
          Date fecha1=getDateCalendar();
        EmpleadoDAOlmpl instance = new EmpleadoDAOlmpl();
        int expResult = 20;
        int result = instance.CalcularEdad(fecha1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
