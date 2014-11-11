package sk.upjs.ics.teplakoshop;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student
 */
public class HlavnyFormular extends javax.swing.JFrame {
    private TeplakyDao teplakyDao 
            = DaoFactory.INSTANCE.getTeplakyDao();

    private TeplakyTableModel teplakyTableModel = new TeplakyTableModel();
            
    private TableRowSorter teplakyRowSorter = new TableRowSorter(teplakyTableModel);
    
    private TeplakyPodlaFarbyRowFilter teplakyPodlaFarbyRowFilter 
            = new TeplakyPodlaFarbyRowFilter();
    /**
     * Creates new form HlavnyFormular
     */
    public HlavnyFormular() {
        initComponents();
        
        //teplakyRowSorter.setComparator(1, comparator);
        teplakyRowSorter.setRowFilter(teplakyPodlaFarbyRowFilter);
        
        tabTeplaky.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tabTeplakySelectionValueChanged(e);
            }
        });
        
        aktualizujZoznamTeplakov();        
    }

    private void tabTeplakySelectionValueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            if(!tabTeplaky.getSelectionModel().isSelectionEmpty()) {
                btnUpravit.setEnabled(true);
                btnOdstranit.setEnabled(true);
            } else {
                btnUpravit.setEnabled(false);
                btnOdstranit.setEnabled(false);
            }
        }
    }

    private void aktualizujZoznamTeplakov() {
        teplakyTableModel.obnov();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHlavicka = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTagline = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        btnVyhladavat = new javax.swing.JButton();
        btnPridat = new javax.swing.JButton();
        btnUpravit = new javax.swing.JButton();
        btnOdstranit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabTeplaky = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHlavicka.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHlavicka.setText("Teplákošop");

        lblTagline.setText("Tepláky pre každý zadok!");

        btnVyhladavat.setText("Hľadať");
        btnVyhladavat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVyhladavatActionPerformed(evt);
            }
        });

        btnPridat.setText("Pridať...");
        btnPridat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPridatActionPerformed(evt);
            }
        });

        btnUpravit.setText("Upraviť...");
        btnUpravit.setEnabled(false);
        btnUpravit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpravitActionPerformed(evt);
            }
        });

        btnOdstranit.setText("Odstrániť...");
        btnOdstranit.setEnabled(false);
        btnOdstranit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdstranitActionPerformed(evt);
            }
        });

        tabTeplaky.setModel(teplakyTableModel);
        tabTeplaky.setRowSorter(teplakyRowSorter);
        tabTeplaky.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabTeplaky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTeplakyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabTeplaky);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTagline)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHlavicka))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPridat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpravit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOdstranit)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtFilter)
                        .addGap(18, 18, 18)
                        .addComponent(btnVyhladavat)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHlavicka)
                    .addComponent(lblTagline))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVyhladavat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpravit)
                    .addComponent(btnOdstranit)
                    .addComponent(btnPridat))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVyhladavatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVyhladavatActionPerformed
        String filter = txtFilter.getText();
        teplakyPodlaFarbyRowFilter.setFarba(filter);
        
        aktualizujZoznamTeplakov();
    }//GEN-LAST:event_btnVyhladavatActionPerformed

    private void btnPridatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPridatActionPerformed
        UpravitTeplakyForm upravitTeplakyForm = new UpravitTeplakyForm(this);
        upravitTeplakyForm.setVisible(true);
        
        aktualizujZoznamTeplakov();
    }//GEN-LAST:event_btnPridatActionPerformed

    private void btnUpravitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpravitActionPerformed
        int vybranyRiadok = tabTeplaky.getSelectedRow();
        int vybratyIndexVModeli = tabTeplaky.convertRowIndexToModel(vybranyRiadok);
        
        Teplaky vybrateTeplaky
                = teplakyTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);
        
        UpravitTeplakyForm upravitTeplakyForm 
                = new UpravitTeplakyForm(vybrateTeplaky, this);
        upravitTeplakyForm.setVisible(true);
        
        aktualizujZoznamTeplakov();
    }//GEN-LAST:event_btnUpravitActionPerformed

    private void btnOdstranitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdstranitActionPerformed
        int vybranyRiadok = tabTeplaky.getSelectedRow();
        int vybratyIndexVModeli = tabTeplaky.convertRowIndexToModel(vybranyRiadok);
        
        Teplaky vybrateTeplaky
                = teplakyTableModel.dajPodlaCislaRiadku(vybratyIndexVModeli);

        if(vybrateTeplaky == null) {
            return;
        }
        
        int tlacidlo = JOptionPane.showConfirmDialog(this, 
                "Naozaj odstrániť?",
                "Odstrániť tepláky",
                JOptionPane.YES_NO_OPTION
        );
        if(tlacidlo == JOptionPane.YES_OPTION) {
            teplakyDao.odstran(vybrateTeplaky);    
            aktualizujZoznamTeplakov();            
        }
    }//GEN-LAST:event_btnOdstranitActionPerformed

    private void tabTeplakyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTeplakyMouseClicked
        if(evt.getClickCount() == 2) {
            btnUpravit.doClick();
        }
    }//GEN-LAST:event_tabTeplakyMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HlavnyFormular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HlavnyFormular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HlavnyFormular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HlavnyFormular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HlavnyFormular().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdstranit;
    private javax.swing.JButton btnPridat;
    private javax.swing.JButton btnUpravit;
    private javax.swing.JButton btnVyhladavat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHlavicka;
    private javax.swing.JLabel lblTagline;
    private javax.swing.JTable tabTeplaky;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables
}
