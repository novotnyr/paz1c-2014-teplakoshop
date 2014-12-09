package sk.upjs.ics.teplakoshop;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabazovyZnackaDao implements ZnackaDao {
    private JdbcTemplate jdbcTemplate;
    
    private BeanPropertyRowMapper<Znacka> mapovac
            = BeanPropertyRowMapper.newInstance(Znacka.class);

    public DatabazovyZnackaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<Znacka> dajVsetky() {
        return jdbcTemplate.query("SELECT * FROM znacka", mapovac);
    }
    
    @Override
    public void save(Znacka znacka) {
        
    }
}
