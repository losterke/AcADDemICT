package com.realdolmen.course.domain;

import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by TLAAU71 on 8/09/2014.
 */
public class PersistenceTest {

    private static EntityManagerFactory emf;

    private EntityManager em;
    private EntityTransaction transaction;

    @BeforeClass
    public static void initEM(){
        emf = Persistence.createEntityManagerFactory("TimPu");
    }

    @Before
    public void init(){
        em = emf.createEntityManager();
        transaction = em.getTransaction();
        transaction.begin();
    }

    @After
    public void destroy(){
        if(transaction != null && !transaction.getRollbackOnly())
            transaction.commit();
        if(em != null)
            em.close();
    }

    @AfterClass
    public static void destroyEmf(){
        if(emf != null)
            emf.close();
    }

    protected EntityManager em(){
        return this.em;
    }
}
