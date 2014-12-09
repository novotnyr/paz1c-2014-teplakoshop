package sk.upjs.ics.teplakoshop;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum DaoFactory {
    INSTANCE;
    
    private TeplakyDao teplakyDao;
    
    private ZnackaDao znackaDao;
    
    private JdbcTemplate jdbcTemplate;
    
    private DataSource dataSource;
    
    public TeplakyDao getTeplakyDao() {
        if(this.teplakyDao == null) {
            this.teplakyDao = new DatabazovyTeplakyDao(getJdbcTemplate());
        }
        return this.teplakyDao;
    }
    
    public ZnackaDao getZnackaDao() {
        if(this.znackaDao == null) {
            this.znackaDao = new DatabazovyZnackaDao(getJdbcTemplate());
        }
        return this.znackaDao;
    }
    
    public JdbcTemplate getJdbcTemplate() {
        if(this.jdbcTemplate == null) {
            this.jdbcTemplate = new JdbcTemplate(getDataSource());
        }
        return this.jdbcTemplate;
    }

    public DataSource getDataSource() {
        if(this.dataSource == null) {
            Properties properties = getProperties();
            if("test".equals(properties.get("rezim"))) {
                System.out.println("Aplikacia bezi v testovacom rezime!");
                
                SQLServerDataSource dataSource = new SQLServerDataSource();
                dataSource.setURL("jdbc:sqlserver://localhost:1433;databaseName=teplaky");
                dataSource.setUser("paz1c");
                dataSource.setPassword("paz1c");
                this.dataSource = dataSource;                
            } else {            
                SQLServerDataSource dataSource = new SQLServerDataSource();
                dataSource.setURL("jdbc:sqlserver://localhost:1433;databaseName=teplaky");
                dataSource.setUser("paz1c");
                dataSource.setPassword("paz1c");
                this.dataSource = dataSource;
            }
        }
        return this.dataSource;
    }
    
    private Properties getProperties() {
        try {
            String propertiesFile;
            
            if("true".equals(System.getProperty("testovaciRezim"))) {
                propertiesFile = "/teplakoshop-test.properties";
            } else {
                propertiesFile = "/teplakoshop.properties";
            }
            
            System.out.println("Nacitavam konfiguraciu z " + propertiesFile);
            
            InputStream in
                    = DaoFactory.class.getResourceAsStream(propertiesFile);

            Properties properties = new Properties();
            properties.load(in);
            
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Nenasiel sa konfiguracny subor");
        }
    }
}
