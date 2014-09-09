package com.realdolmen.course.domain;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Created by TLAAU71 on 8/09/2014.
 */
public class PassengerPersistence extends PersistenceTest {

    @Test
    public void PassengerPersistence()throws Exception{

        Passenger p = new Passenger("bal","Vermeulen","Jef", 50,new byte[10], new Date(), com.realdolmen.course.domain.Passenger.PassengerType.REGULAR, new Date());
        em().persist(p);
        assertNotNull(p.getId());
        assertNotNull(p.getDateOfBirth());
        assertNotNull(p.getPassengerType());
        assertNotNull(p.getAge());
    }

    @Test()
    public void Persist() throws Exception{
        Passenger p = new Passenger(null,null,null,0,new byte[10], null, null,null);
        assertNull(p.getId());
        assertNull(p.getDateOfBirth());
        assertNull(p.getPassengerType());
    }

    @Test
    public void BeforePersist(){
        Passenger p = new Passenger("bal","Vermeulen","Jos", 50,new byte[10], new Date(), com.realdolmen.course.domain.Passenger.PassengerType.REGULAR, new Date());
        assertNull(p.getDateLastUpdated());
        em().persist(p);
        assertNotNull(p.getDateLastUpdated());
    }

}
