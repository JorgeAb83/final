
package DAO;


import Modelo.Empleado;
import Modelo.Proyectos;
import persistencia.ProyectosJpaController;
import persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectoDAOlmpl implements ProyectoDAO  {
    ProyectosJpaController ProyectoJPA = new ProyectosJpaController();
    
    @Override
    public void CrearProyecto(Proyectos empleado) {
        ProyectoJPA.create(empleado);
    }

    @Override
    public void EliminarProyecto(int id) {
        try {
            ProyectoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProyectoDAOlmpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void EditarProyecto(Proyectos empleado) {
        try {
            ProyectoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ProyectoDAOlmpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Proyectos traerProyecto(int id) {
        return ProyectoJPA.findProyectos(id);
    }

    @Override
    public ArrayList<Proyectos> TrearProyecto() {
       List<Proyectos>lista=ProyectoJPA.findProyectosEntities();
        ArrayList<Proyectos>listaProyectos = new ArrayList(lista);
        return listaProyectos;
    }
    @Override
    public float calcularMontoIndividual (int id){
        float div=0;
        int k=0;
        List<Proyectos>lista=ProyectoJPA.findProyectosEntities();
        ArrayList<Proyectos>listaProyectos = new ArrayList(lista);
        for(Proyectos p:listaProyectos){
            if(p.getId()==id){
                for(Empleado e:p.getListaempleado()){
                    k++;
                }
            }
        }
        if(k==0){
            return k;
        }else{
          for(Proyectos p:listaProyectos){
            if(p.getId()==id){
              div=p.getMonto()/k;
            }
        } 
          return div;
        }
        
        
        
    }

}
