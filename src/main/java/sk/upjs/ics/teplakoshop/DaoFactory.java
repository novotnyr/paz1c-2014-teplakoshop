package sk.upjs.ics.teplakoshop;

public enum DaoFactory {
    INSTANCE;
    
    public TeplakyDao getTeplakyDao() {
        return new DatabazovyTeplakyDao();
    }
}
