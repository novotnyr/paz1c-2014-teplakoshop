package sk.upjs.ics.teplakoshop;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabazovyTeplakyDaoTest {
    @BeforeClass
    public static void setUpTests() {
        System.setProperty("testovaciRezim", "true");
    }
    
    @Test
    public void test() {
        
        int pocetRiadkov = DaoFactory.INSTANCE.getJdbcTemplate().queryForInt("SELECT COUNT(*) FROM teplaky");
        assertEquals(1, pocetRiadkov);
    }
    
    @Test
    public void testDajVsetky() {
        TeplakyDao teplakyDao = DaoFactory.INSTANCE.getTeplakyDao();
        List<Teplaky> teplaky = teplakyDao.dajVsetky();
        assertEquals(1, teplaky.size());        
    }
}
