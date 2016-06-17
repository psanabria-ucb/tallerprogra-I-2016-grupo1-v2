package bo.edu.ucbcba.group1v2.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rebeca on 17/06/2016.
 */
public class CustomerTest {

    private Customer movie;
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        movie = new Customer();
    }
    @Test
    public void testSetFirstName() {
        movie.setFirtsName("aaaa");
        assertEquals("aaaa", movie.getFirtsName());
    }
    @Test
    public void testSetLastNameM() {
        movie.setLastNameM("aaaa");
        assertEquals("aaaa", movie.getLastNameM());
    }
    @Test
    public void testSetLastNameP() {
        movie.setLastNameF("aaaa");
        assertEquals("aaaa", movie.getLastNameF());
    }

    @Test
    public void testSetAdress() {
        movie.setAddress("aaaa");
        assertEquals("aaaa", movie.getAddress());
    }

    @Test
    public void testSetNumber() {
        movie.setNumberPhone(111);
        assertEquals(111, movie.getNumberPhone());
    }


    @Test
    public void testSetCi() {
        movie.setCi(111);
        assertEquals(111, movie.getCi());
    }



}
