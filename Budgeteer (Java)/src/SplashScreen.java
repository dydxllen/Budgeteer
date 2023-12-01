import javax.swing.JOptionPane;

public class SplashScreen extends javax.swing.JFrame {

    public SplashScreen() {
        initComponents();
    }
                   
    private void initComponents() {

        // flatLightLaf1 = new com.formdev.flatlaf.FlatLightLaf();
        BackGroundColour = new javax.swing.JPanel();
        BudgeteerLogo = new javax.swing.JLabel();
        LoadingBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        Welcome = new javax.swing.JLabel();
        LoadingValue = new javax.swing.JLabel();
        LoadingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(153, 153, 255));
        setMinimumSize(new java.awt.Dimension(390, 640));
        setUndecorated(true);

        BackGroundColour.setBackground(new java.awt.Color(164, 164, 255));
        BackGroundColour.setForeground(new java.awt.Color(0, 51, 51));
        BackGroundColour.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        BackGroundColour.setMinimumSize(new java.awt.Dimension(360, 640));
        BackGroundColour.setPreferredSize(new java.awt.Dimension(360, 640));

        BudgeteerLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("\\img\\logo budgeteer-01.png"))); // NOI18N
        BudgeteerLogo.setText("jLabel2");
        BudgeteerLogo.setMaximumSize(new java.awt.Dimension(350, 300));
        BudgeteerLogo.setMinimumSize(new java.awt.Dimension(350, 300));
        BudgeteerLogo.setPreferredSize(new java.awt.Dimension(350, 300));

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel1.setText("Ready to budget your spendings?");

        Welcome.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        Welcome.setText("Welcome, Budgeteers!");

        LoadingValue.setText("0%");

        LoadingLabel.setText("Loading...");

        javax.swing.GroupLayout BackGroundColourLayout = new javax.swing.GroupLayout(BackGroundColour);
        BackGroundColour.setLayout(BackGroundColourLayout);
        BackGroundColourLayout.setHorizontalGroup(
            BackGroundColourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundColourLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(BudgeteerLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackGroundColourLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LoadingLabel)
                .addGap(260, 260, 260)
                .addComponent(LoadingValue))
            .addGroup(BackGroundColourLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackGroundColourLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(BackGroundColourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundColourLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Welcome))
                    .addComponent(jLabel1)))
        );
        BackGroundColourLayout.setVerticalGroup(
            BackGroundColourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundColourLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BudgeteerLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(BackGroundColourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoadingLabel)
                    .addComponent(LoadingValue))
                .addGap(4, 4, 4)
                .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(BackGroundColourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Welcome)
                    .addGroup(BackGroundColourLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundColour, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundColour, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatLaf Light".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        SplashScreen sp = new SplashScreen();
        sp.setVisible(true);
        
        Menu menu = new Menu();

        try {

            for (int i = 0; i <= 100; i++) {
                Thread.sleep(15);
                sp.LoadingValue.setText(i + "%");

                if (i == 10) {
                    sp.LoadingLabel.setText("Turning On Modules...");
                }
                if (i == 20) {
                    sp.LoadingLabel.setText("Loading Modules...");
                }
                if (i == 50) {
                    sp.LoadingLabel.setText("Connecting to Database...");
                }
                if (i == 70) {
                    sp.LoadingLabel.setText("Connection Successful...");
                }
                if (i == 80) {
                    sp.LoadingLabel.setText("Launching Application...");
                }
                sp.LoadingBar.setValue(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        //make splash screen not visible, while making dashboard visible 
        sp.setVisible(false);
        menu.setVisible(true);
        
        sp.dispose();
        
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel BackGroundColour;
    private javax.swing.JLabel BudgeteerLogo;
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel Welcome;
    // private com.formdev.flatlaf.FlatLightLaf flatLightLaf1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
