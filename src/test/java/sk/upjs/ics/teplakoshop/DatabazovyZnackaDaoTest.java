package sk.upjs.ics.teplakoshop;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabazovyZnackaDaoTest {
    
    public DatabazovyZnackaDaoTest() {
    }

    @Test
    public void testDajVsetky() {
        ZnackaDao znackaDao = DaoFactory.INSTANCE.getZnackaDao();
        List<Znacka> znacky = znackaDao.dajVsetky();
        assertEquals(2, znacky.size());
    }

    @Test
    public void testSave() {
        System.out.println("save");
        Znacka znacka = null;
        DatabazovyZnackaDao instance = null;
        instance.save(znacka);
        fail("The test case is a prototype.");
    }
    
}
