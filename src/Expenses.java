import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Float.parseFloat;

public class Expenses extends Transaction {

    // Variables declaration - do not modify
    private javax.swing.JLabel Amount;
    private javax.swing.JLabel Category;
    private javax.swing.JLabel Description;
    private com.toedter.calendar.JDateChooser ExpDateChooser;
    private javax.swing.JPanel Expenses;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField expAmountTF;
    private javax.swing.JComboBox<String> expCategoryCB;
    private javax.swing.JLabel expDate;
    private javax.swing.JTextField expDescTF;
    public static javax.swing.JTable expTable;
    private javax.swing.JLabel expTitle;
    private javax.swing.JComboBox<String> jComboBox1;
    private static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menuBtn;
    private javax.swing.JButton viewBtn;
    private int selectedRow;
    // End of variables declaration

    public Expenses() {
        setTitle("Expenses");
        initComponents();
        Table();
        String filepath = "expenses.txt";
        setSize(380,675);
    }

    private void initComponents() {

        Expenses = new javax.swing.JPanel();
        expTitle = new javax.swing.JLabel();
        expDate = new javax.swing.JLabel();
        ExpDateChooser = new com.toedter.calendar.JDateChooser();
        Description = new javax.swing.JLabel();
        expDescTF = new javax.swing.JTextField();
        Category = new javax.swing.JLabel();
        expCategoryCB = new javax.swing.JComboBox<>();
        Amount = new javax.swing.JLabel();
        expAmountTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        expTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(360, 640));
        setMinimumSize(new java.awt.Dimension(360, 640));
        setPreferredSize(new java.awt.Dimension(360, 640));

        Expenses.setBackground(new java.awt.Color(164, 164, 255));
        Expenses.setMaximumSize(new java.awt.Dimension(360, 640));
        Expenses.setMinimumSize(new java.awt.Dimension(360, 640));

        expTitle.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        expTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expTitle.setText(" EXPENSES");
        expTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        expDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        expDate.setText("Date");

        Description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Description.setText("Description");

        expDescTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expDescTFActionPerformed(evt);
            }
        });

        Category.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Category.setText("Category");

        expCategoryCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food", "Entertainment", "Transport", "Fees", "Groceries" }));
        expCategoryCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expCategoryCBActionPerformed(evt);
            }
        });

        Amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Amount.setText("Amount");

        expAmountTF.setText(" ");
        expAmountTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expAmountTFActionPerformed(evt);
            }
        });

        expTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Date", "Description", "Category", "Amount"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        expTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(expTable);

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit(1).png"))); // NOI18N
        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        menuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-menu-50.png"))); // NOI18N
        menuBtn.setText("Menu");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        viewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-read-24.png"))); // NOI18N
        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expenses", "Income"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
                String selectedItem = (String) comboBox.getSelectedItem();
                if (selectedItem.equals("Expenses")) {
                     Expenses e = new Expenses();
                     e.setVisible(true);
                    expenses.clear();
                    income.clear();
                     dispose();

                } else if (selectedItem.equals("Income")) {
                     Income i = new Income();
                     i.setVisible(true);
                    expenses.clear();
                    income.clear();
                     dispose();
                }
             }
         });

        javax.swing.GroupLayout ExpensesLayout = new javax.swing.GroupLayout(Expenses);
        Expenses.setLayout(ExpensesLayout);
        ExpensesLayout.setHorizontalGroup(
                ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ExpensesLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ExpensesLayout.createSequentialGroup()
                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(ExpensesLayout.createSequentialGroup()
                                                                .addComponent(addBtn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(viewBtn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(editBtn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deleteBtn))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 15, Short.MAX_VALUE))
                                        .addGroup(ExpensesLayout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(ExpensesLayout.createSequentialGroup()
                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(expTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(ExpensesLayout.createSequentialGroup()
                                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(expDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ExpDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(expDescTF, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(expAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(expCategoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(77, 77, 77)))
                                                .addGap(25, 25, 25))))
                        .addGroup(ExpensesLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(menuBtn)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        ExpensesLayout.setVerticalGroup(
                ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ExpensesLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(expTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(expDate)
                                        .addComponent(ExpDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Description)
                                        .addComponent(expDescTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(expCategoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Category))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Amount)
                                        .addComponent(expAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(Expenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Expenses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>


    public static void createRecord(LocalDate expenseDate, String expenseDescription, String expenseCategory, float expenseAmount){
        try {
            //output buffer stream
            BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.txt", true));

            // Format the record data as a string
            String record = String.format("%s,%s,%s,%.2f", expenseDate.toString(), expenseDescription, expenseCategory, expenseAmount);

            writer.write(record);
            writer.newLine();
            writer.close();

            System.out.println("Record created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating the record: " + e.getMessage());
        }
    }

    public static void readRecord(ArrayList<theData> expenses){ //Read the file
        File file = new File("expenses.txt");
            try{
                Scanner input = new Scanner(file);

                while(input.hasNextLine()){
                    String line = input.nextLine();
                    String [] parts = line.split(","); // Sort the data into parts
                    goData = new theData(LocalDate.parse(parts[0]), parts[1], parts[2], Float.valueOf(parts[3]));
                    expenses.add(goData);
                }
                input.close();
            }catch(IOException e)
            {
                System.out.println("expenses.txt is empty" + e.getMessage());
            }
    }

    public static void saveRecords() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.txt"));

            for (int i = 0; i < expTable.getRowCount(); i++) {
                LocalDate date = (LocalDate) expTable.getValueAt(i, 0);
                String description = (String) expTable.getValueAt(i, 1);
                String category = (String) expTable.getValueAt(i, 2);
                float amount = (float) expTable.getValueAt(i, 3);

                String record = String.format("%s,%s,%s,%.2f", date.toString(), description, category, amount);

                writer.write(record);
                writer.newLine();
            }

            writer.close();

            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving the records: " + e.getMessage());
        }
    }

    public static void Table(){
        readRecord(expenses);

        Object[][] data = new Object[expenses.size()][5];

        int i =0;
        for(theData s : expenses){
            data[i][0] = s.expenseDate;
            data[i][1] = s.expenseDescription;
            data[i][2] = s.expenseCategory;
            data[i][3] = s.expenseAmount;
            i = i+1;
        }
        //For Table in View
        String[] columnNames = {"Date","Description","Category","Amount"}; //Table column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        expTable.setModel(model);
        expTable.setEnabled(true);
        jScrollPane1.setViewportView(expTable);
    }

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if(expDescTF.getText().equals("")||expAmountTF.getText().equals("")){
            ExpDateChooser.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Input Field should not be empty.");
        }
        else {
            addBtn.setEnabled(true);

            // Retrieve the selected date from jDateChooser
            Date selectedDate = ExpDateChooser.getDate();
            Instant instant = selectedDate.toInstant();
            ZoneId zone = ZoneId.systemDefault();
            LocalDate expenseDate = instant.atZone(zone).toLocalDate();

            createRecord(expenseDate, expDescTF.getText(), Objects.requireNonNull(expCategoryCB.getSelectedItem()).toString(), parseFloat(expAmountTF.getText()));
            expenses.clear(); //Remove old data
            Table(); // Get latest data

            ExpDateChooser.setDate(null);
            expDescTF.setText("");
            expCategoryCB.setSelectedIndex(0);
            expAmountTF.setText("");

            JOptionPane.showMessageDialog(this, "Added successfully!");
        }
    }

    private void expTableMouseClicked(java.awt.event.MouseEvent evt){
        try {
            DefaultTableModel model = (DefaultTableModel)expTable.getModel();
            selectedRow = expTable.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(selectedRow,0).toString());
            ExpDateChooser.setDate(date);
            expDescTF.setText(model.getValueAt(selectedRow, 1).toString());
            expCategoryCB.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
            expAmountTF.setText(model.getValueAt(selectedRow, 3).toString());

        } catch (ParseException ex) {
            Logger.getLogger(Expenses.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedRow == -1) {
            // No row selected, display an error message
            JOptionPane.showMessageDialog(this, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the values from the selected row
        LocalDate date = (LocalDate) expTable.getValueAt(selectedRow, 0);
        String description = (String) expTable.getValueAt(selectedRow, 1);
        String category = (String) expTable.getValueAt(selectedRow, 2);
        float amount = (float) expTable.getValueAt(selectedRow, 3);

        // Show a dialog to edit the values
        JTextField dateField = new JTextField(date.toString());
        JTextField descriptionField = new JTextField(description);
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"Food", "Entertainment", "Transport", "Fees", "Groceries"});
        categoryComboBox.setSelectedItem(category);
        JTextField amountField = new JTextField(Float.toString(amount));

        Object[] message = {
                "Date:", dateField,
                "Description:", descriptionField,
                "Category:", categoryComboBox,
                "Amount:", amountField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Edit Expense", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                // Update the values in the table
                expTable.setValueAt(LocalDate.parse(dateField.getText()), selectedRow, 0);
                expTable.setValueAt(descriptionField.getText(), selectedRow, 1);
                expTable.setValueAt(categoryComboBox.getSelectedItem(), selectedRow, 2);
                expTable.setValueAt(parseFloat(amountField.getText()), selectedRow, 3);

                // Save the changes to the file
                saveRecords();

                //clear text field
                ExpDateChooser.setDate(null);
                expDescTF.setText("");
                expCategoryCB.setSelectedIndex(0);
                expAmountTF.setText("");

                // Show a success message
                JOptionPane.showMessageDialog(this, "Expense edited successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                // Error in parsing values
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) expTable.getModel();

        int selectedRow = expTable.getSelectedRow();
        if(selectedRow != -1){
            model.removeRow(selectedRow);

            try {
                File file = new File("expenses.txt");
                BufferedReader br =  new BufferedReader(new FileReader(file));
                int lineNumber = 1;
                String updatedRecords = "";

                String line = br.readLine();

                while(line != null)
                {
                    if(lineNumber != selectedRow+1)
                    {
                        updatedRecords = updatedRecords + line + "\n";

                    }
                    line = br.readLine();
                    lineNumber++;
                }

                FileWriter writer = new FileWriter(file);
                writer.write(updatedRecords);

                br.close();
                writer.close();

                ExpDateChooser.setDate(null);
                expDescTF.setText("");
                expCategoryCB.setSelectedIndex(0);
                expAmountTF.setText("");

                JOptionPane.showMessageDialog(this, "SelectedRow successfully deleted.");

            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void expDescTFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void expCategoryCBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void expAmountTFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Menu menu = new Menu();
        menu.show();
        dispose();
    }

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    }
