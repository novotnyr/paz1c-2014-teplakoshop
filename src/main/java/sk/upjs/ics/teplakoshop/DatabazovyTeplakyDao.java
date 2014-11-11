package sk.upjs.ics.teplakoshop;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class DatabazovyTeplakyDao implements TeplakyDao{
    private JdbcTemplate jdbcTemplate;

    private BeanPropertyRowMapper<Teplaky> mapovac =
                new BeanPropertyRowMapper<>(Teplaky.class);

    public DatabazovyTeplakyDao() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setURL("jdbc:sqlserver://localhost:1433;databaseName=teplaky");
        dataSource.setUser("paz1c");
        dataSource.setPassword("paz1c");

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List<Teplaky> dajVsetky() {
        return jdbcTemplate.query("SELECT * FROM teplaky", mapovac);
    }

    @Override
    public List<Teplaky> hladatPodlaFarby(String filter) {
        filter = filter.trim();
        filter = "%" + filter + "%";
        
        return jdbcTemplate.query("select * from teplaky\n" +
                "where farba like ?", mapovac, filter);
    }

    @Override
    public void save(Teplaky teplaky) {
        if(teplaky.getId() == null) {
            Map<String, Object> hodnoty = new HashMap<String, Object>();
            hodnoty.put("farba", teplaky.getFarba());
            hodnoty.put("velkost", teplaky.getVelkost());
            hodnoty.put("cena", teplaky.getCena());

            SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);

            insert.setGeneratedKeyName("id");

            insert.setTableName("teplaky");
            Number id = insert.executeAndReturnKey(hodnoty);
            teplaky.setId(id.longValue());
        } else {
            String sql = "UPDATE teplaky\n"
                    + "SET farba = ?,\n"
                    + "velkost = ?,\n"
                    + "cena = ?\n"
                    + "WHERE id = ?";
            
            jdbcTemplate.update(sql, 
                    teplaky.getFarba(),
                    teplaky.getVelkost(),
                    teplaky.getCena(),
                    teplaky.getId());
        }
    }

    @Override
    public void odstran(Teplaky teplaky) {
        jdbcTemplate.update("DELETE FROM teplaky WHERE id = ?", 
                teplaky.getId());
    }

    
}
