package com.realdolmen.course.domain;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by TLAAU71 on 9/09/2014.
 */
public class TicketPersistenceTest extends DataSetPersistenceTest {

    @Test
    public void ticketPersistenceTest(){
        Ticket t = new Ticket(BigDecimal.TEN, new Date(), "Brussel");
        em().persist(t);
        assertNotNull(t.getId());
        assertNotNull(t.getDestination());
        assertNotNull(t.getPrice());
        Ticket test = em().getReference(Ticket.class, t.getId());
        assertEquals(test,t);

    }

    @Test
    public void ticketRemove() {
        Ticket t = em().getReference(Ticket.class, 1L);
        em().remove(t);
        em().flush();
        em().clear();
        assertNull(t.getId());
    }

    @Test
    public void ticketUpdate(){
        Ticket t = em().getReference(Ticket.class, 2L);
        assertEquals("Paris", t.getDestination());
        em().persist(t);
        t.setDestination("London");
        em().merge(t);
        assertEquals("London", t.getDestination());

    }
}
