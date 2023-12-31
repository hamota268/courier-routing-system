/*created by:
Youssef Mohamed Ahmed c6
 */

package Views;

import Controllers.CityController;
import static Controllers.CityController.getAllCities;
import Models.City;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddNewLocation extends javax.swing.JFrame {
    
    DefaultTableModel cityDistancesTable;

    /**
     * Creates new form AddNewLocation
     * @param cityDistancesTable
     */
    public AddNewLocation(DefaultTableModel cityDistancesTable) {
        initComponents();
        this.cityDistancesTable = cityDistancesTable;
        
        String[] cities = getAllCities();
        DefaultComboBoxModel cityNamesA = new DefaultComboBoxModel(cities);
        DefaultComboBoxModel cityNamesB = new DefaultComboBoxModel(cities);
        cmbCityA.setModel(cityNamesA);
        cmbCityB.setModel(cityNamesB);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spnDistance = new javax.swing.JSpinner();
        btnAddNewLocationToTable = new javax.swing.JButton();
        cmbCityA = new javax.swing.JComboBox<>();
        cmbCityB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add New Location"));

        jLabel1.setText("City A");

        jLabel2.setText("City B");

        jLabel3.setText("Distance (KM)");

        btnAddNewLocationToTable.setText("Insert");
        btnAddNewLocationToTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewLocationToTableActionPerformed(evt);
            }
        });

        cmbCityA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a city" }));

        cmbCityB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a city" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnDistance)
                    .addComponent(cmbCityA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(btnAddNewLocationToTable))
                        .addGap(0, 282, Short.MAX_VALUE))
                    .addComponent(cmbCityB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbCityA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbCityB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddNewLocationToTable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewLocationToTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewLocationToTableActionPerformed

        int distance = (int) spnDistance.getValue();
        
        String[] cities = getAllCities();
        
//        if (cmbCityA.getSelectedIndex() == 0 || cmbCityB.getSelectedIndex() == 0){
//            JOptionPane.showMessageDialog(null, "Please select both cities.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        
        if (cmbCityA.getSelectedItem() == cmbCityB.getSelectedItem()){
            JOptionPane.showMessageDialog(null, "You cannot select same city.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        CityController.addRoadDistance(cmbCityA.getSelectedIndex(), cmbCityB.getSelectedIndex(), distance);
        cityDistancesTable.addRow(new Object[] {cmbCityA.getSelectedItem(), cmbCityB.getSelectedItem(), distance + " KM"});
        JOptionPane.showMessageDialog(this, "New Road Added!", "Success", JOptionPane.INFORMATION_MESSAGE, null);
    }//GEN-LAST:event_btnAddNewLocationToTableActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewLocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewLocationToTable;
    private javax.swing.JComboBox<String> cmbCityA;
    private javax.swing.JComboBox<String> cmbCityB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spnDistance;
    // End of variables declaration//GEN-END:variables
}
