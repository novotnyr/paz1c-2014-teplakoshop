package sk.upjs.ics.teplakoshop;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabazovyTeplakyDao implements TeplakyDao{
    private JdbcTemplate jdbcTemplate;
    
    public DatabazovyTeplakyDao() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setURL("jdbc:sqlserver://localhost:1433;databaseName=teplaky");
        dataSource.setUser("paz1c");
        dataSource.setPassword("paz1c");

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List<Teplaky> dajVsetky() {
        BeanPropertyRowMapper<Teplaky> mapovac =
                new BeanPropertyRowMapper<>(Teplaky.class);
        return jdbcTemplate.query("SELECT * FROM teplaky", mapovac);
    }

    @Override
    public List<Teplaky> hladatPodlaFarby(String filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Teplaky teplaky) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
