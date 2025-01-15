package com.mycompany.carrepairweb.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSource implements DataSource{
    
    private final EntityManagerFactory emf;
    
    public DatabaseSource(){
        emf = Persistence.createEntityManagerFactory("my_persistence_unit");
    }

    @Override
    public List<Job> getJobs() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT j FROM Job j");            
            return query.getResultList();         
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return new ArrayList<>();
    }

    @Override
    public void persistObject(Object object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();     
        } catch (PersistenceException e) {            
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Job job) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(job);
            em.getTransaction().commit();
        } catch(Exception ex){            
        }        
        return true;
    }

    @Override
    public boolean delete(int id) {
        EntityManager em = emf.createEntityManager();
        try{           
            em.getTransaction().begin();
            var result = em.createQuery("DELETE FROM Job j WHERE j.id=:id").setParameter("id", id).executeUpdate() != 0;
            em.getTransaction().commit(); 
            return result;
        } catch(Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();            
        }    
        return true;
    }
    
}
