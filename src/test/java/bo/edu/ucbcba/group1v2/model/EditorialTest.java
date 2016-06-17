package bo.edu.ucbcba.group1v2.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rebeca on 17/06/2016.
 */
public class EditorialTest {
    private Editorial movie;
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        movie = new Editorial();
    }
    @Test
    public void testSetTitle() {
        movie.setName("aaaa");
        assertEquals("aaaa", movie.getName());
    }

    @Test
    public void testSetPais() {
        movie.setPais("aaaa");
        assertEquals("aaaa", movie.getPais());
    }

    @Test
    public void testSetDireccion() {
        movie.setDireccion("aaaa");
        assertEquals("aaaa", movie.getDireccion());
    }

    @Test
    public void testSetFono() {
        movie.setTelefono(111);
        assertEquals(111, movie.getTelefono());
    }
}
