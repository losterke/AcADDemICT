package com.realdolmen.course.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by TLAAU71 on 8/09/2014.
 */
public class Runner {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction transaction;

        try{
            emf = Persistence.createEntityManagerFactory("TimPu");
            em = emf.createEntityManager();
            transaction = em.getTransaction();


            transaction.begin();
            em.persist(new Book("bla", "me"));
            Date birth = new Date();
            birth.setTime(406867380);
            em.persist(new Passenger("bal", "Lemahieu", "Tim", 50, new byte[10], birth, Passenger.PassengerType.OCCASIONAL, new Date()));
            em.persist(new Ticket(BigDecimal.ONE, new Date(),"Souse"));
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(em != null)
                em.close();
            if(emf != null)
                emf.close();
        }
    }
}
