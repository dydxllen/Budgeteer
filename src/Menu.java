import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        setTitle("Menu");
        initComponents();
//        setSize(380,675);
        expTable();
        incTable();
        String balance = getBalance();
        RMLB.setText("RM " + balance);
        totalExpenses = 0;
        totalIncome = 0;
    }

    private void initComponents() {

        dynamicDriveToolTipTagFragmentGenerator1 = new org.jfree.chart.imagemap.DynamicDriveToolTipTagFragmentGenerator();
        menuPanel = new javax.swing.JPanel();
        navToInc = new javax.swing.JButton();
        navToDashboard = new javax.swing.JButton();
        navToGraph = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        balJL = new javax.swing.JLabel();
        RMLB = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Title1 = new javax.swing.JLabel();
        Title2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(360, 640));
        setMinimumSize(new java.awt.Dimension(360, 640));

        menuPanel.setBackground(new java.awt.Color(164, 164, 255));
        menuPanel.setMaximumSize(new java.awt.Dimension(360, 640));
        menuPanel.setMinimumSize(new java.awt.Dimension(360, 640));
        menuPanel.setPreferredSize(new java.awt.Dimension(360, 640));

        navToInc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navToInc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-income-50.png"))); // NOI18N
        navToInc.setText("Transaction");
        navToInc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navToInc.setInheritsPopupMenu(true);
        navToInc.setMaximumSize(new java.awt.Dimension(107, 84));
        navToInc.setMinimumSize(new java.awt.Dimension(107, 84));
        navToInc.setPreferredSize(new java.awt.Dimension(107, 84));
        navToInc.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        navToInc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navToInc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navToIncActionPerformed(evt);
            }
        });

        navToDashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navToDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-overview-48.png"))); // NOI18N
        navToDashboard.setText("Dashboard");
        navToDashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navToDashboard.setInheritsPopupMenu(true);
        navToDashboard.setMaximumSize(new java.awt.Dimension(107, 84));
        navToDashboard.setMinimumSize(new java.awt.Dimension(107, 84));
        navToDashboard.setPreferredSize(new java.awt.Dimension(107, 84));
        navToDashboard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        navToDashboard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navToDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navToDashboardActionPerformed(evt);
            }
        });

        navToGraph.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        navToGraph.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-graph-48.png"))); // NOI18N
        navToGraph.setText("Graph");
        navToGraph.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navToGraph.setInheritsPopupMenu(true);
        navToGraph.setMaximumSize(new java.awt.Dimension(107, 84));
        navToGraph.setMinimumSize(new java.awt.Dimension(107, 84));
        navToGraph.setPreferredSize(new java.awt.Dimension(107, 84));
        navToGraph.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        navToGraph.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navToGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navToGraphActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        balJL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        balJL.setText("Balance:");

        RMLB.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        RMLB.setText("RM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(RMLB, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(balJL)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(balJL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RMLB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Date", "Description", "Category", "Amount"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        Title1.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        Title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title1.setText(" EXPENSES");
        Title1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Title2.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        Title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title2.setText("INCOMES");
        Title2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Date", "Description", "Category", "Amount"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel2.setBackground(new java.awt.Color(164, 164, 255));
        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo budgeteer 50x50.png"))); // NOI18N
        jLabel2.setText("BUDGETEER");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Title2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                                                .addComponent(navToInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(navToGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(navToDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(15, 15, 15))))
                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(15, 15, 15)))
                                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Title1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Title2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(navToDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(navToInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(navToGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    static float totalExpenses = 0;
    static float totalIncome = 0;
    static String balance;

    public void expTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); //clear the existing table data

        try (BufferedReader br = new BufferedReader(new FileReader("expenses.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void incTable() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); //clear the existing table data

        try (BufferedReader br = new BufferedReader(new FileReader("income.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static float calculateExp(){
        try{
            File file = new File("expenses.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                for(String part:parts){
                    try{
                        float floatValue = Float.parseFloat(part);
                        totalExpenses += floatValue;
                    } catch (NumberFormatException e) {
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return totalExpenses;
    }

    public static float calculateIncome(){
        try{
            File file = new File("income.txt");
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                for(String part:parts){
                    try{
                        float floatValue = Float.parseFloat(part);
                        totalIncome += floatValue;
                    } catch (NumberFormatException e) {
                }
            }
        }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return totalIncome;
    }

    public static String getBalance(){
        float expAmount = calculateExp();
        float incAmount = calculateIncome();
        float amount = incAmount - expAmount;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        balance = decimalFormat.format(amount);

        return balance;
    }

    private void navToIncActionPerformed(java.awt.event.ActionEvent evt) {
        Expenses expenses = new Expenses();
        expenses.show();

        dispose();
    }

    private void navToDashboardActionPerformed(java.awt.event.ActionEvent evt) {
        Dashboard dashboard = new Dashboard();
        dashboard.show();

        dispose();
    }

    private void dayOrMonthCBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void navToGraphActionPerformed(java.awt.event.ActionEvent evt) {
        Graph graph = new Graph();
        graph.readExpensesData("expenses.txt");
        graph.readExpensesData("income.txt");
        graph.show();
        dispose();
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel RMLB;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JLabel balJL;
    private org.jfree.chart.imagemap.DynamicDriveToolTipTagFragmentGenerator dynamicDriveToolTipTagFragmentGenerator1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton navToInc;
    private javax.swing.JButton navToGraph;
    private javax.swing.JButton navToDashboard;
    // End of variables declaration
}
