package sk.upjs.ics.teplakoshop;


import java.math.BigDecimal;

public class Teplaky {
    private Long id;
    
    private String farba;
            
    private String velkost;
            
    private BigDecimal cena;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getFarba() {
        return farba;
    }

    public void setFarba(String farba) {
        this.farba = farba;
    }

    public String getVelkost() {
        return velkost;
    }

    public void setVelkost(String velkost) {
        this.velkost = velkost;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Teplaky{" + "id=" + id + ", farba=" + farba + ", velkost=" + velkost + ", cena=" + cena + '}';
    }
    
    
}
