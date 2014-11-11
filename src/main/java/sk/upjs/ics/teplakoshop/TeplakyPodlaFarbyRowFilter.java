package sk.upjs.ics.teplakoshop;

import javax.swing.RowFilter;

public class TeplakyPodlaFarbyRowFilter extends RowFilter {
    private static final int STLPEC_FARBA = 0;
    
    private String farba = "";
    
    @Override
    public boolean include(Entry entry) {
        String farba = entry.getStringValue(STLPEC_FARBA);
        return farba.contains(this.farba);
    }
    
    public void setFarba(String farba) {
        this.farba = farba;
    }
}
