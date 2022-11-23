/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empleado;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alumno
 */
public interface EmpleadoDAO {
    void CrearEmpleado(Empleado empleado);
    void EliminarEmpleado(int id);
    void EditarEmpleado(Empleado empleado);
    Empleado traerEmpleado(int id);
    ArrayList<Empleado> TrearListaEmpleado();
    int CalcularEdad(Date FechaNacimeinto);
}
