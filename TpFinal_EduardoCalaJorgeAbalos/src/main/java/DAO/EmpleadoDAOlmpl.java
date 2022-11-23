/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empleado;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import persistencia.EmpleadoJpaController;
import persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class EmpleadoDAOlmpl implements EmpleadoDAO {
    public static SimpleDateFormat sd = new SimpleDateFormat("YYYY");//formato de fecha
    
    EmpleadoJpaController EmpleadoJPA = new EmpleadoJpaController();

    @Override
    public void CrearEmpleado(Empleado empleado) {
        EmpleadoJPA.create(empleado);
    }

    @Override
    public void EliminarEmpleado(int id) {
        try {
            EmpleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpleadoDAOlmpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void EditarEmpleado(Empleado empleado) {
        try {
            EmpleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoDAOlmpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado traerEmpleado(int id) {
        
        
        return EmpleadoJPA.findEmpleado(id);
    }

    @Override
    public ArrayList<Empleado> TrearListaEmpleado() {
        List<Empleado>lista=EmpleadoJPA.findEmpleadoEntities();
        ArrayList<Empleado>listaEmpleado = new ArrayList(lista);
        return listaEmpleado;
    }
    
    @Override
    public int CalcularEdad(Date fecha1){
        Period edad = Period.between(LocalDate.of(Integer.parseInt(sd.format(fecha1)),fecha1.getMonth(),fecha1.getDate()), LocalDate.now());
        return edad.getYears();
    }
    
}
