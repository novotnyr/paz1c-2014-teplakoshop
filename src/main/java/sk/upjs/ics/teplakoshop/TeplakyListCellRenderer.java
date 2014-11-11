package sk.upjs.ics.teplakoshop;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class TeplakyListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Teplaky teplaky = (Teplaky) value;
        
        StringBuilder sb = new StringBuilder();
        sb.append(teplaky.getFarba()).append(" ")
                .append(teplaky.getVelkost()).append(" ")
                .append(teplaky.getCena());
        
        return super.getListCellRendererComponent(list, sb, index, isSelected, cellHasFocus); 
    }

    
    
}
