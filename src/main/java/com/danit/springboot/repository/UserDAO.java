package com.danit.springboot.repository;


import com.danit.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class UserDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public void saveUser(User user){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        //catch(Ex)
        //em.getTransaction.rollback();
    }

}
