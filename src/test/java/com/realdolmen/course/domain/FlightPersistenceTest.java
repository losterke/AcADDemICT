package com.realdolmen.course.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by TLAAU71 on 10/09/2014.
 */
public class FlightPersistenceTest extends DataSetPersistenceTest {

    @Test
    public void Persist(){
        List<String> s = new ArrayList<>();
        s.add("testring");
        DomesticFlight f = new DomesticFlight(3L, "MH370", new Date(), new Date(),"SN",s);
        em().merge(f);
        assertNotNull(f.getId());
        assertNotNull(f.getArrivalTime());
        assertNotNull(f.getDepartureTime());
        assertNotNull(f.getNumber());
    }

    @Test
    public void retrieve(){
        Flight f = em().getReference(Flight.class, 1L);
        assertNotNull(f.getId());
    }

    @Test
    public void Update(){
        Flight f = em().getReference(Flight.class, 1L);
        assertEquals("MH080",f.getNumber());
        f.setNumber("MH450");
        em().merge(f);
        assertEquals("MH450",f.getNumber());
    }
}
