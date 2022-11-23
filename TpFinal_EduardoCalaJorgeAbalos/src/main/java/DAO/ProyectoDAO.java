package DAO;

import Modelo.Proyectos;
import java.util.ArrayList;

public interface ProyectoDAO {
    void CrearProyecto(Proyectos empleado);
    void EliminarProyecto(int id);
    void EditarProyecto(Proyectos empleado);
    Proyectos traerProyecto(int id);
    ArrayList<Proyectos> TrearProyecto();
    float calcularMontoIndividual (int id);
}
