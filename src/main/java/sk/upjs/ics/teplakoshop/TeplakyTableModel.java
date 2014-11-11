package sk.upjs.ics.teplakoshop;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TeplakyTableModel extends AbstractTableModel {
    private static final int POCET_STLPCOV = 3;
    
    private TeplakyDao teplakyDao = DaoFactory.INSTANCE.getTeplakyDao();
    
    private List<Teplaky> teplaky = new LinkedList<>();
    
    @Override
    public int getRowCount() {
        return teplaky.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teplaky vybraneTeplaky = teplaky.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return vybraneTeplaky.getFarba();
            case 1:
                return vybraneTeplaky.getVelkost();
            case 2:
                return vybraneTeplaky.getCena();
            default:
                return "???";
        }
    }
    
    public void obnov() {
        teplaky = teplakyDao.dajVsetky();
        fireTableDataChanged();
    }
    
    public Teplaky dajPodlaCislaRiadku(int riadok) {
        return teplaky.get(riadok);
    }
}
