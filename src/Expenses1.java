//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Objects;
//import java.util.Scanner;
//
//import static java.lang.Float.parseFloat;
//
//public class Expenses1 extends JFrame {
//
//    // Variables declaration - do not modify
//    private javax.swing.JLabel Amount;
//    private javax.swing.JLabel Category;
//    private javax.swing.JLabel Description;
//    private com.toedter.calendar.JDateChooser ExpDateChooser;
//    private javax.swing.JPanel Expenses;
//    private javax.swing.JButton addBtn;
//    private javax.swing.JButton deleteBtn;
//    private javax.swing.JButton editBtn;
//    private javax.swing.JTextField expAmountTF;
//    private javax.swing.JComboBox<String> expCategoryCB;
//    private javax.swing.JLabel expDate;
//    private javax.swing.JTextField expDescTF;
//    public static javax.swing.JTable expTable;
//    private javax.swing.JLabel expTitle;
//    private javax.swing.JComboBox<String> jComboBox1;
//    private static javax.swing.JScrollPane jScrollPane1;
//    private javax.swing.JButton menuBtn;
//    private javax.swing.JButton viewBtn;
//    // End of variables declaration
//    private static theData goData;
//    static LocalDate today = LocalDate.now(); //Local time
//    static ArrayList<theData> expenses = new ArrayList<>();
//
//
//    public static void createRecord(LocalDate expenseDate, String expenseDescription, String expenseCategory, float expenseAmount){
//        try {
//            //output buffer stream
//            BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.txt", true));
//
//            // Format the record data as a string
//            String record = String.format("%s,%s,%s,%.2f", expenseDate.toString(), expenseDescription, expenseCategory, expenseAmount);
//
//            writer.write(record);
//            writer.newLine();
//            writer.close();
//
//            System.out.println("Record created successfully.");
//        } catch (IOException e) {
//            System.err.println("Error creating the record: " + e.getMessage());
//        }
//    }
//
//    public static void readRecord(ArrayList<theData> expenses){ //Read the file
//        try{
//            File inputFile = new File("expenses.txt");
//            Scanner input = new Scanner(inputFile);
//
//            while(input.hasNextLine()){
//                String line = input.nextLine();
//                String [] parts = line.split(","); // Sort the data into parts
//                goData = new theData(parts[1], parts[2], Float.valueOf(parts[3]), LocalDate.parse(parts[0]));
//                expenses.add(goData);
//            }
//        }
//        catch(IOException e)
//        {
//            System.out.println("Error reading the record: " + e.getMessage());
//        }
//    }
//
//    public static void Table(){
//        readRecord(expenses);
//        //Expenses Menu
//
//        Object[][] data = new Object[expenses.size()][5];
//        Object[] getMenu = new Object[expenses.size()];
//        //String[] comboBoxName = new String[expenses.size()]; //ComboBox Data
//
//        int i =0;
//        for(theData s : expenses){
//            data[i][0] = s.expenseDate;
//            data[i][1] = s.expenseDescription;
//            data[i][2] = s.expenseCategory;
//            data[i][3] = s.expenseAmount;
//            //comboBoxName[i] = i+1+". " + s.expenseDescription; //ComboBox Data Selection
////            comboBoxName = new String[0];
////            comboBoxName[i] = s.expenseDescription; //ComboBox Data Selection
//            i = i+1;
//        }
//        //For Table in View
//        String[] columnNames = {"Date","Category","Description","Amount"}; //Table column names
//        DefaultTableModel model = new DefaultTableModel(data, columnNames);
//        expTable.setModel(model);
//        expTable.setEnabled(true);
//        jScrollPane1.setViewportView(expTable);
//
//        //For ComboBox
////        expCategoryCB.setModel(new javax.swing.DefaultComboBoxModel<>(comboBoxName)); //Change the current ComboBox Data Selection
////        expCategoryCB.setModel(new javax.swing.DefaultComboBoxModel<>(comboBoxName)); //Change the current ComboBox Data Selection
////        expCategoryCB.setModel(new javax.swing.DefaultComboBoxModel<>(comboBoxName)); //Change the current ComboBox Data Selection
//    }
//
//    public static void updateRecord(int lineNumber) {
//        File file;
//        file = new File("expenses.txt");
//
//        // Check if the file exists
//        if (file.exists()) {
//            try {
//                StringBuilder content;
//                try (BufferedReader reader = new BufferedReader(new FileReader(file)) //read existing file
//                ) {
//                    content = new StringBuilder();
//                    String line;
//                    int currentLine = 1;
//                    // Read the file line by line and update the specific line
//                    while ((line = reader.readLine()) != null) {
//                        if (currentLine == lineNumber) {
//
//                        } else {
//                            content.append(line).append(System.lineSeparator());
//                        }
//                        currentLine++;
//                    }
//                }
//
//                try ( // Write the updated content back to the file
//                      BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//                    writer.write(content.toString());
//                }
//
//                System.out.println("Item deleted updated successfully!");
//
//            } catch (IOException e) {
//            }
//        } else {
//            System.out.println("Item not found!");
//        }
//    }
//
//    public static void deleteRecord(int lineNumber) {
//        File file = new File("expenses.txt");
//
//        // Check if the file exists
//        if (file.exists()) {
//            try {
//                StringBuilder content;
//                try (BufferedReader reader = new BufferedReader(new FileReader(file)) //read existing file
//                ) {
//                    content = new StringBuilder();
//                    String line;
//                    int currentLine = 1;
//                    // Read the file line by line and update the specific line
//                    while ((line = reader.readLine()) != null) {
//                        if (currentLine == lineNumber) {
//
//                        } else {
//                            content.append(line).append(System.lineSeparator());
//                        }
//                        currentLine++;
//                    }
//                }
//
//                try ( // Write the updated content back to the file
//                      BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//                    writer.write(content.toString());
//                }
//
//                System.out.println("Item have been deleted successfully!");
//
//            } catch (IOException e) {
//            }
//        } else {
//            System.out.println("Item not found!");
//        }
//    }
//
//    private void initComponents() {
//
//        Expenses = new javax.swing.JPanel();
//        expTitle = new javax.swing.JLabel();
//        expDate = new javax.swing.JLabel();
//        ExpDateChooser = new com.toedter.calendar.JDateChooser();
//        Description = new javax.swing.JLabel();
//        expDescTF = new javax.swing.JTextField();
//        Category = new javax.swing.JLabel();
//        expCategoryCB = new javax.swing.JComboBox<>();
//        Amount = new javax.swing.JLabel();
//        expAmountTF = new javax.swing.JTextField();
//        jScrollPane1 = new javax.swing.JScrollPane();
//        expTable = new javax.swing.JTable();
//        addBtn = new javax.swing.JButton();
//        editBtn = new javax.swing.JButton();
//        deleteBtn = new javax.swing.JButton();
//        menuBtn = new javax.swing.JButton();
//        viewBtn = new javax.swing.JButton();
//        jComboBox1 = new javax.swing.JComboBox<>();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setMaximumSize(new java.awt.Dimension(360, 640));
//        setMinimumSize(new java.awt.Dimension(360, 640));
//        setPreferredSize(new java.awt.Dimension(360, 640));
//
//        Expenses.setBackground(new java.awt.Color(164, 164, 255));
//        Expenses.setMaximumSize(new java.awt.Dimension(360, 640));
//        Expenses.setMinimumSize(new java.awt.Dimension(360, 640));
//
//        expTitle.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
//        expTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        expTitle.setText(" EXPENSES");
//        expTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
//
//        expDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        expDate.setText("Date");
//
//        Description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        Description.setText("Description");
//
//        expDescTF.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                expDescTFActionPerformed(evt);
//            }
//        });
//
//        Category.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        Category.setText("Category");
//
//        expCategoryCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food", "Entertainment", "Transport", "Fees", "Groceries" }));
//        expCategoryCB.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                expCategoryCBActionPerformed(evt);
//            }
//        });
//
//        Amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        Amount.setText("Amount");
//
//        expAmountTF.setText("RM ");
//        expAmountTF.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                expAmountTFActionPerformed(evt);
//            }
//        });
//
//        expTable.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//
//                },
//                new String [] {
//                        "Date", "Description", "Category", "Amount"
//                }
//        ) {
//            boolean[] canEdit = new boolean [] {
//                    false, true, false, true
//            };
//
//            public boolean isCellEditable(int rowIndex, int columnIndex) {
//                return canEdit [columnIndex];
//            }
//        });
//        jScrollPane1.setViewportView(expTable);
//
//        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
//        addBtn.setText("Add");
//        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                addBtnMouseClicked(evt);
//            }
//        });
//        addBtn.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                addBtnActionPerformed(evt);
//            }
//        });
//
//        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit(1).png"))); // NOI18N
//        editBtn.setText("Edit");
//        editBtn.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                editBtnActionPerformed(evt);
//            }
//        });
//
//        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin.png"))); // NOI18N
//        deleteBtn.setText("Delete");
//        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                deleteBtnActionPerformed(evt);
//            }
//        });
//
//        menuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-menu-50.png"))); // NOI18N
//        menuBtn.setText("Menu");
//        menuBtn.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                menuBtnActionPerformed(evt);
//            }
//        });
//
//        viewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-read-24.png"))); // NOI18N
//        viewBtn.setText("View");
//        viewBtn.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                viewBtnActionPerformed(evt);
//            }
//        });
//
//        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expenses", "Income", " " }));
//
//        javax.swing.GroupLayout ExpensesLayout = new javax.swing.GroupLayout(Expenses);
//        Expenses.setLayout(ExpensesLayout);
//        ExpensesLayout.setHorizontalGroup(
//                ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(ExpensesLayout.createSequentialGroup()
//                                .addGap(17, 17, 17)
//                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(ExpensesLayout.createSequentialGroup()
//                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                                                        .addGroup(ExpensesLayout.createSequentialGroup()
//                                                                .addComponent(addBtn)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(viewBtn)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(editBtn)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(deleteBtn))
//                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                                .addGap(0, 15, Short.MAX_VALUE))
//                                        .addGroup(ExpensesLayout.createSequentialGroup()
//                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                        .addGroup(ExpensesLayout.createSequentialGroup()
//                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                                                        .addComponent(expTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                        .addGroup(ExpensesLayout.createSequentialGroup()
//                                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                                        .addComponent(expDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                                        .addComponent(Description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                                        .addComponent(Amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                                        .addComponent(Category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                                        .addComponent(ExpDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                        .addComponent(expDescTF, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                        .addComponent(expAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                        .addComponent(expCategoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                                                .addGap(77, 77, 77)))
//                                                .addGap(25, 25, 25))))
//                        .addGroup(ExpensesLayout.createSequentialGroup()
//                                .addGap(129, 129, 129)
//                                .addComponent(menuBtn)
//                                .addGap(0, 0, Short.MAX_VALUE))
//        );
//        ExpensesLayout.setVerticalGroup(
//                ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(ExpensesLayout.createSequentialGroup()
//                                .addGap(17, 17, 17)
//                                .addComponent(expTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addComponent(expDate)
//                                        .addComponent(ExpDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(Description)
//                                        .addComponent(expDescTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(expCategoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(Category))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(Amount)
//                                        .addComponent(expAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(18, 18, 18)
//                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(18, 18, 18)
//                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
//                                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(116, 116, 116))
//        );
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addComponent(Expenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addComponent(Expenses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//        );
//
//        pack();
//        setLocationRelativeTo(null);
//    }// </editor-fold>
//
//    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
////
////        if(expDescTF.getText().equals("")||expAmountTF.getText().equals("")){
////            ExpDateChooser.setEnabled(false);
////            TextField jLabel11 = null;
////            jLabel11.setText("Input Field cannot be empty");
////        }
////        else {
////            addBtn.setEnabled(true);
//////            createRecord(jComboBox3.getSelectedItem().toString(),jTextField1.getText(),Float.valueOf(jTextField2.getText()),today);
////            createRecord(today, expDescTF.getText(), Objects.requireNonNull(expCategoryCB.getSelectedItem()).toString(), Float.parseFloat(expAmountTF.getText()));
////            expenses.clear(); //Remove old data
////            //readRecord(expenses);
////            Table(); // Get latest data
////        }
////
////        //DATE, DESCRIPTION, CATEGORY, AMOUNT
//////        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
//////        String date = dFormat.format(ExpDateChooser.getDate());
//////        String category = expCategoryCB.getSelectedItem().toString();
//////        DefaultTableModel model = (DefaultTableModel)expTable.getModel();
//////
//////        model.addRow(new Object[]{date,expDescTF.getText(), category ,expAmountTF.getText()});
//////                double amount = Double.parseDouble(expAmountTF.getText());
//    }
//
//    private void expDescTFActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void expCategoryCBActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//        String expCat = expCategoryCB.getSelectedItem().toString();
//    }
//
//    private void expAmountTFActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {
//        if(expDescTF.getText().equals("")||expAmountTF.getText().equals("")){
//            ExpDateChooser.setEnabled(false);
//            TextField jLabel11 = null;
//            jLabel11.setText("Input Field cannot be empty");
//        }
//        else {
//            addBtn.setEnabled(true);
////            createRecord(jComboBox3.getSelectedItem().toString(),jTextField1.getText(),Float.valueOf(jTextField2.getText()),today);
//            createRecord(today, expDescTF.getText(), Objects.requireNonNull(expCategoryCB.getSelectedItem()).toString(), parseFloat(expAmountTF.getText()));
//            expenses.clear(); //Remove old data
//            //readRecord(expenses);
//            Table(); // Get latest data
//        }
//    }
//
//    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Expenses().setVisible(true);
//            }
//        });
//    }
//
//
//}
