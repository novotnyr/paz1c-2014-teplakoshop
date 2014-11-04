package sk.upjs.ics.teplakoshop;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabazovyTeplakyDaoTest {
    @Test
    public void test() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setURL("jdbc:sqlserver://localhost:1433;databaseName=teplaky");
        dataSource.setUser("paz1c");
        dataSource.setPassword("paz1c");
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int pocetRiadkov = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM teplaky");
        assertEquals(1, pocetRiadkov);
    }
    
    @Test
    public void testDajVsetky() {
        DatabazovyTeplakyDao teplakyDao = new DatabazovyTeplakyDao();
        List<Teplaky> teplaky = teplakyDao.dajVsetky();
        assertEquals(1, teplaky.size());        
    }
}
