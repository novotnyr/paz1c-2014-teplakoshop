package sk.upjs.ics.teplakoshop;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabazovyTeplakyDaoTest {
    @Test
    public void test() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3066/teplaky");
        dataSource.setUser("root");
        dataSource.setPassword("");
        
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
