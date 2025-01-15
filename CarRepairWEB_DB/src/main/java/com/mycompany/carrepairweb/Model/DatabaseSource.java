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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
