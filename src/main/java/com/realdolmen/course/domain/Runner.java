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
            Adress a = new Adress("Street1","Sreet2","city", "zipcode", "country");
            Passenger p = new Passenger("bal","Vermeulen","Jef", 50,new byte[10], new Date(), com.realdolmen.course.domain.Passenger.PassengerType.REGULAR,new Date(),a);
            em.persist(p);
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
