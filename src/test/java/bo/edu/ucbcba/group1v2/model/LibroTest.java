package bo.edu.ucbcba.group1v2.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rebeca on 17/06/2016.
 */
public class LibroTest {
    private Libro movie;
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        movie = new Libro();
    }

    @Test
    public void testSetTitle() {
        movie.setNombre("aaaa");
        assertEquals("aaaa", movie.getNombre());
    }

    @Test
    public void testSetGenero() {
        movie.setGenero("aaaa");
        assertEquals("aaaa", movie.getGenero());
    }

    @Test
    public void testSetDescrip() {
        movie.setDescription("aaaa");
        assertEquals("aaaa", movie.getDescription());
    }


    @Test
    public void testSetIsbn() {
        movie.setIsbn(111);
        assertEquals(111, movie.getIsbn());
    }

    @Test
    public void testSetLanza() {
        movie.setLanzamiento(111);
        assertEquals(111, movie.getLanzamiento());
    }

    @Test
    public void testSetEdit() {
        movie.setEditname("aaaa");
        assertEquals("aaaa", movie.getEditname());
    }

}

