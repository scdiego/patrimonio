/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Negocio.Bien;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class FrmGridBienes extends javax.swing.JDialog {

    /**
     * Creates new form FrmGridBienes
     */
    DefaultTableModel tblBienes = new DefaultTableModel();
    public CtrlVista logica;
    
    public FrmGridBienes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cargarGrid();
        this.gridBienes.setModel(tblBienes);
    }
    
    public final void limpiarGrid(){
        if (this.tblBienes.getRowCount() > 0) {
            for (int i = this.tblBienes.getRowCount() - 1; i > -1; i--) {
               this.tblBienes.removeRow(i);
            }
        }
    }
    public final void colocarEncabezadoGrid(){
        String[] columnNames = {"Nro de Inventario",
                        "Descripcion",
                        "Estado"};
        this.tblBienes.setColumnIdentifiers(columnNames);
    }
    public final void cargarGrid(){
       // gridBienes
        Bien auxBien;
        
        this.limpiarGrid();
        this.colocarEncabezadoGrid();
        Object[][] data = null;
        Object[] row = null;
        int i = 0;
        for (Map.Entry bien : logica.listadeBienes().entrySet()) {
            auxBien = (Bien)bien.getValue();
            row[0]=auxBien.getNroInventario();
            row[1]=auxBien.getDescripcion();
            row[2]=auxBien.getEstado();
            data[i] = row;

            i = i + 1;
        }
        this.tblBienes.addRow(data);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gridBienes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grid Bienes - Patrimonio");

        gridBienes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        gridBienes.setName("gridBienes"); // NOI18N
        jScrollPane1.setViewportView(gridBienes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmGridBienes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGridBienes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGridBienes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGridBienes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmGridBienes dialog = new FrmGridBienes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gridBienes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}