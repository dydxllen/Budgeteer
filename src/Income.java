import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
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

public class Income extends Transaction {
    private int selectedRow;

    public Income() {
        setTitle("Income");
        initComponents();
        Table();
    }

    private void initComponents() {

        Income = new javax.swing.JPanel();
        incTitle = new javax.swing.JLabel();
        incDate = new javax.swing.JLabel();
        incDateChooser = new com.toedter.calendar.JDateChooser();
        incDescTF = new javax.swing.JTextField();
        Description1 = new javax.swing.JLabel();
        Category1 = new javax.swing.JLabel();
        incCategoryCB = new javax.swing.JComboBox<>();
        Amount1 = new javax.swing.JLabel();
        incAmountTF = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        incTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        editBtn1 = new javax.swing.JButton();
        deleteBtn1 = new javax.swing.JButton();
        menuBtn1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(360, 640));
        setMinimumSize(new java.awt.Dimension(360, 640));
        setResizable(false);

        Income.setBackground(new java.awt.Color(164, 164, 255));
        Income.setPreferredSize(new java.awt.Dimension(360, 640));

        incTitle.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        incTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        incTitle.setText("INCOMES");
        incTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        incDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        incDate.setText("Date");

        incDescTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incDescTFActionPerformed(evt);
            }
        });

        Description1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Description1.setText("Description");

        Category1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Category1.setText("Category");

        incCategoryCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Scholarship", "Part-time Job", "Loan" }));
        incCategoryCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incCategoryCBActionPerformed(evt);
            }
        });

        Amount1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Amount1.setText("Amount");

        incAmountTF.setText("");
        incAmountTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incAmountTFActionPerformed(evt);
            }
        });

        incTable.setModel(new javax.swing.table.DefaultTableModel(
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
        incTable.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                incTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(incTable);

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit(1).png"))); // NOI18N
        editBtn1.setText("Edit");
        editBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn1ActionPerformed(evt);
            }
        });

        deleteBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin.png"))); // NOI18N
        deleteBtn1.setText("Delete");
        deleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn1ActionPerformed(evt);
            }
        });

        menuBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-menu-50.png"))); // NOI18N
        menuBtn1.setText("Menu");
        menuBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtn1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Income", "Expenses" }));
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

        javax.swing.GroupLayout IncomeLayout = new javax.swing.GroupLayout(Income);
        Income.setLayout(IncomeLayout);
        IncomeLayout.setHorizontalGroup(
                IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IncomeLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IncomeLayout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(IncomeLayout.createSequentialGroup()
                                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(incTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(IncomeLayout.createSequentialGroup()
                                                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IncomeLayout.createSequentialGroup()
                                                                                .addGap(1, 1, 1)
                                                                                .addComponent(Amount1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(IncomeLayout.createSequentialGroup()
                                                                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(incDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(Description1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(Category1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(1, 1, 1)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(incDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(IncomeLayout.createSequentialGroup()
                                                                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(incDescTF)
                                                                                        .addComponent(incCategoryCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(incAmountTF, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                                .addGap(32, 32, 32)))
                                                                .addGap(85, 85, 85))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IncomeLayout.createSequentialGroup()
                                                                .addComponent(addBtn)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(editBtn1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(menuBtn1)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                .addGap(18, 18, 18))))
        );
        IncomeLayout.setVerticalGroup(
                IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IncomeLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(incTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(incDate)
                                        .addComponent(incDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Description1)
                                        .addComponent(incDescTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(incCategoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Category1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Amount1)
                                        .addComponent(incAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(menuBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Income, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Income, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void createRecord(LocalDate incomeDate, String incomeDescription, String incomeCategory, float incomeAmount) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("income.txt", true));

            String record = String.format("%s,%s,%s,%.2f", incomeDate.toString(), incomeDescription, incomeCategory, incomeAmount);
            writer.write(record);
            writer.newLine();
            writer.close();

            System.out.println("Record created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating the record: " + e.getMessage());
        }
    }

    public static void incRecord(ArrayList<incData> income){
        File file = new File("income.txt");
        try{
            Scanner input = new Scanner(file);

            while (input.hasNextLine()){
                String line = input.nextLine();
                String [] parts = line.split(",");
                inData = new incData(LocalDate.parse(parts[0]), parts[1], parts[2], Float.valueOf(parts[3]));
                income.add(inData);
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

            for (int i = 0; i < incTable.getRowCount(); i++) {
                LocalDate date = (LocalDate) incTable.getValueAt(i, 0);
                String description = (String) incTable.getValueAt(i, 1);
                String category = (String) incTable.getValueAt(i, 2);
                float amount = (float) incTable.getValueAt(i, 3);

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
        incRecord(income);
        Object[][] data = new Object[income.size()][5];

        int i=0;
        for(incData s : income){
            data[i][0] = s.incomeDate;
            data[i][1] = s.incomeDescription;
            data[i][2] = s.incomeCategory;
            data[i][3] = s.incomeAmount;
            i = i+1;
        }
        String [] columnNames= {"Date","Description","Category","Amount"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        incTable.setModel(model);
        incTable.setEnabled(true);
        jScrollPane4.setViewportView(incTable);
    }

    private void incDescTFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void incCategoryCBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void incAmountTFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }



    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if(incDescTF.getText().equals("")||incAmountTF.getText().equals("")){
            incDateChooser.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Input Field should not be empty.");
        }
        else{
            addBtn.setEnabled(true);

            Date selectedDate = incDateChooser.getDate();
            Instant instant = selectedDate.toInstant();
            ZoneId zone = ZoneId.systemDefault();
            LocalDate incomeDate = instant.atZone(zone).toLocalDate();

            createRecord(incomeDate, incDescTF.getText(), Objects.requireNonNull(incCategoryCB.getSelectedItem()).toString(), parseFloat(incAmountTF.getText()));
            income.clear();
            Table();

            incDateChooser.setDate(null);
            incDescTF.setText("");
            incCategoryCB.setSelectedIndex(0);
            incAmountTF.setText("");

            JOptionPane.showMessageDialog(this, "Added successfully!");
        }
    }

    private void incTableMouseClicked(MouseEvent evt) {
        try{
            DefaultTableModel model = (DefaultTableModel)incTable.getModel();
            selectedRow = incTable.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(selectedRow, 0).toString());
            incDateChooser.setDate(date);
            incDescTF.setText(model.getValueAt(selectedRow, 1).toString());
            incCategoryCB.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
            incAmountTF.setText(model.getValueAt(selectedRow, 3).toString());

        } catch (ParseException e) {
            Logger.getLogger(Expenses.class.getName()).log(Level.SEVERE,null, evt);
        }
    }

    private void editBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedRow == -1) {
            // No row selected, display an error message
            JOptionPane.showMessageDialog(this, "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the values from the selected row
        LocalDate date = (LocalDate) incTable.getValueAt(selectedRow, 0);
        String description = (String) incTable.getValueAt(selectedRow, 1);
        String category = (String) incTable.getValueAt(selectedRow, 2);
        float amount = (float) incTable.getValueAt(selectedRow, 3);

        // Show a dialog to edit the values
        JTextField dateField = new JTextField(date.toString());
        JTextField descriptionField = new JTextField(description);
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"Scholarship", "Part-time Job", "Loan"});
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
                incTable.setValueAt(LocalDate.parse(dateField.getText()), selectedRow, 0);
                incTable.setValueAt(descriptionField.getText(), selectedRow, 1);
                incTable.setValueAt(categoryComboBox.getSelectedItem(), selectedRow, 2);
                incTable.setValueAt(parseFloat(amountField.getText()), selectedRow, 3);

                // Save the changes to the file
                saveRecords();

                //clear text field
                incDateChooser.setDate(null);
                incDescTF.setText("");
                incCategoryCB.setSelectedIndex(0);
                incAmountTF.setText("");

                // Show a success message
                JOptionPane.showMessageDialog(this, "Expense edited successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                // Error in parsing values
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) incTable.getModel();

        int selectedRow = incTable.getSelectedRow();
        if(selectedRow != -1){
            model.removeRow(selectedRow);

            try {
                File file = new File("income.txt");
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

                incDateChooser.setDate(null);
                incDescTF.setText("");
                incCategoryCB.setSelectedIndex(0);
                incAmountTF.setText("");

                JOptionPane.showMessageDialog(this, "SelectedRow successfully deleted.");

            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void menuBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        Menu menu = new Menu();
        menu.show();
        dispose();
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel Amount1;
    private javax.swing.JLabel Category1;
    private javax.swing.JLabel Description1;
    private javax.swing.JPanel Income;
    private javax.swing.JButton deleteBtn1;
    private javax.swing.JButton editBtn1;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField incDescTF;
    private static javax.swing.JTable incTable;
    private javax.swing.JTextField incAmountTF;
    private javax.swing.JComboBox<String> incCategoryCB;
    private javax.swing.JLabel incDate;
    private com.toedter.calendar.JDateChooser incDateChooser;
    private javax.swing.JLabel incTitle;
    private javax.swing.JComboBox<String> jComboBox1;
    private static javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton menuBtn1;
    // End of variables declaration
}
