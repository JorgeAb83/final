/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Empleado;
import Modelo.Proyectos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author alumno
 */
public class ProyectosJpaController implements Serializable {

    public ProyectosJpaController (){
        emf=Persistence.createEntityManagerFactory("com.mycompany_TpFinal_EduardoCalaJorgeAbalos_jar_1.0-SNAPSHOTPU");
    }
    public ProyectosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proyectos proyectos) {
        if (proyectos.getListaempleado() == null) {
            proyectos.setListaempleado(new ArrayList<Empleado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empleado> attachedListaempleado = new ArrayList<Empleado>();
            for (Empleado listaempleadoEmpleadoToAttach : proyectos.getListaempleado()) {
                listaempleadoEmpleadoToAttach = em.getReference(listaempleadoEmpleadoToAttach.getClass(), listaempleadoEmpleadoToAttach.getId());
                attachedListaempleado.add(listaempleadoEmpleadoToAttach);
            }
            proyectos.setListaempleado(attachedListaempleado);
            em.persist(proyectos);
            for (Empleado listaempleadoEmpleado : proyectos.getListaempleado()) {
                Proyectos oldProyectoOfListaempleadoEmpleado = listaempleadoEmpleado.getProyecto();
                listaempleadoEmpleado.setProyecto(proyectos);
                listaempleadoEmpleado = em.merge(listaempleadoEmpleado);
                if (oldProyectoOfListaempleadoEmpleado != null) {
                    oldProyectoOfListaempleadoEmpleado.getListaempleado().remove(listaempleadoEmpleado);
                    oldProyectoOfListaempleadoEmpleado = em.merge(oldProyectoOfListaempleadoEmpleado);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proyectos proyectos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyectos persistentProyectos = em.find(Proyectos.class, proyectos.getId());
            List<Empleado> listaempleadoOld = persistentProyectos.getListaempleado();
            List<Empleado> listaempleadoNew = proyectos.getListaempleado();
            List<Empleado> attachedListaempleadoNew = new ArrayList<Empleado>();
            for (Empleado listaempleadoNewEmpleadoToAttach : listaempleadoNew) {
                listaempleadoNewEmpleadoToAttach = em.getReference(listaempleadoNewEmpleadoToAttach.getClass(), listaempleadoNewEmpleadoToAttach.getId());
                attachedListaempleadoNew.add(listaempleadoNewEmpleadoToAttach);
            }
            listaempleadoNew = attachedListaempleadoNew;
            proyectos.setListaempleado(listaempleadoNew);
            proyectos = em.merge(proyectos);
            for (Empleado listaempleadoOldEmpleado : listaempleadoOld) {
                if (!listaempleadoNew.contains(listaempleadoOldEmpleado)) {
                    listaempleadoOldEmpleado.setProyecto(null);
                    listaempleadoOldEmpleado = em.merge(listaempleadoOldEmpleado);
                }
            }
            for (Empleado listaempleadoNewEmpleado : listaempleadoNew) {
                if (!listaempleadoOld.contains(listaempleadoNewEmpleado)) {
                    Proyectos oldProyectoOfListaempleadoNewEmpleado = listaempleadoNewEmpleado.getProyecto();
                    listaempleadoNewEmpleado.setProyecto(proyectos);
                    listaempleadoNewEmpleado = em.merge(listaempleadoNewEmpleado);
                    if (oldProyectoOfListaempleadoNewEmpleado != null && !oldProyectoOfListaempleadoNewEmpleado.equals(proyectos)) {
                        oldProyectoOfListaempleadoNewEmpleado.getListaempleado().remove(listaempleadoNewEmpleado);
                        oldProyectoOfListaempleadoNewEmpleado = em.merge(oldProyectoOfListaempleadoNewEmpleado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = proyectos.getId();
                if (findProyectos(id) == null) {
                    throw new NonexistentEntityException("The proyectos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyectos proyectos;
            try {
                proyectos = em.getReference(Proyectos.class, id);
                proyectos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proyectos with id " + id + " no longer exists.", enfe);
            }
            List<Empleado> listaempleado = proyectos.getListaempleado();
            for (Empleado listaempleadoEmpleado : listaempleado) {
                listaempleadoEmpleado.setProyecto(null);
                listaempleadoEmpleado = em.merge(listaempleadoEmpleado);
            }
            em.remove(proyectos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proyectos> findProyectosEntities() {
        return findProyectosEntities(true, -1, -1);
    }

    public List<Proyectos> findProyectosEntities(int maxResults, int firstResult) {
        return findProyectosEntities(false, maxResults, firstResult);
    }

    private List<Proyectos> findProyectosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proyectos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Proyectos findProyectos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proyectos.class, id);
        } finally {
            em.close();
        }
    }

    public int getProyectosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proyectos> rt = cq.from(Proyectos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
