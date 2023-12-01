import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Transaction extends javax.swing.JFrame {

    File file = new File("expenses.txt");
    File incomefile = new File("income.txt");


    public void createNewExpenses(){
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex){
                Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    int lineCount = 0;
    public void countLine(){
        lineCount = 0;
        try{
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while(raf.readLine() != null){
                lineCount++;
            }
            raf.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showExp(){
        String titleLine = "Date, Description, Category, Amount";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) expTable.getModel();
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            String[] splitTitle = titleLine.trim().split(",");
            model.setColumnIdentifiers(splitTitle);

            Object[] object = reader.lines().toArray();

            for (int i=0; i<object.length; i++){
                String[] dataSplit = object[i].toString().trim().split(",");
                model.addRow(dataSplit);
            }
            reader.close();
        } catch (FileNotFoundException ex){
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE,null,ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createNewIncome(){
        if (!incomefile.exists()){
            try {
                incomefile.createNewFile();
            } catch (IOException ex){
                Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addExp(){
        countLine();
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            for (int i=1; i<=lineCount; i++){
                raf.readLine();
            }

            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dFormat.format(ExpDateChooser.getDate());
            String category = expCategoryCB.getSelectedItem().toString();
            raf.writeBytes(date + "," + expDescTF.getText()+"," + category + "," + expAmountTF.getText());
            raf.writeBytes(System.lineSeparator());
            raf.close();

            DefaultTableModel model = (DefaultTableModel)expTable.getModel();
            model.addRow(new Object[]{date,expDescTF.getText(), category ,expAmountTF.getText()});
        } catch (FileNotFoundException ex) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addInc(){
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dFormat.format(incDateChooser.getDate());
            String category = incCategoryCB.getSelectedItem().toString();
            raf.writeBytes(date + "," + expDescTF1.getText()+"," + category + "," + incAmountTF.getText());
            raf.writeBytes(System.lineSeparator());
            raf.close();

            DefaultTableModel model = (DefaultTableModel)expTable1.getModel();
            model.addRow(new Object[]{date,expDescTF1.getText(), category ,incAmountTF.getText()});
        } catch (FileNotFoundException ex) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void editExp(){
        //set data for their text feild
        DefaultTableModel tblModel = (DefaultTableModel)expTable.getModel();

        //set data to text field when raw is selected
        String tblDate = tblModel.getValueAt(expTable.getSelectedRow(),0).toString();
        String tblDescription = tblModel.getValueAt(expTable.getSelectedRow(), 1).toString();
        String tblCategory = tblModel.getValueAt(expTable.getSelectedRow(), 2).toString();
        String tblAmount = tblModel.getValueAt(expTable.getSelectedRow(), 3).toString();

        ExpDateChooser.setText(tblDate);

    }


    public Transaction() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

    }

    private void initComponents() {

        Transactions = new javax.swing.JTabbedPane();
        Expenses = new javax.swing.JPanel();
        expTitle = new javax.swing.JLabel();
        expDate = new javax.swing.JLabel();
        ExpDateChooser = new com.toedter.calendar.JDateChooser();
        Description = new javax.swing.JLabel();
        expDescTF = new javax.swing.JTextField();
        Receipt = new javax.swing.JLabel();
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
        jButton1 = new javax.swing.JButton();
        Income = new javax.swing.JPanel();
        incTitle = new javax.swing.JLabel();
        incDate = new javax.swing.JLabel();
        incDateChooser = new com.toedter.calendar.JDateChooser();
        expDescTF1 = new javax.swing.JTextField();
        Description1 = new javax.swing.JLabel();
        Receipt1 = new javax.swing.JLabel();
        Category1 = new javax.swing.JLabel();
        incCategoryCB = new javax.swing.JComboBox<>();
        Amount1 = new javax.swing.JLabel();
        incAmountTF = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        expTable1 = new javax.swing.JTable();
        enterBtn1 = new javax.swing.JButton();
        editBtn1 = new javax.swing.JButton();
        deleteBtn1 = new javax.swing.JButton();
        menuBtn1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(360, 640));
        setMinimumSize(new java.awt.Dimension(360, 640));
        setPreferredSize(new java.awt.Dimension(360, 640));
        setResizable(false);

        Transactions.setMaximumSize(new java.awt.Dimension(360, 640));
        Transactions.setMinimumSize(new java.awt.Dimension(360, 640));
        Transactions.setPreferredSize(new java.awt.Dimension(360, 640));

        Expenses.setBackground(new java.awt.Color(164, 164, 255));
        Expenses.setMaximumSize(new java.awt.Dimension(360, 640));
        Expenses.setMinimumSize(new java.awt.Dimension(360, 640));
        Expenses.setPreferredSize(new java.awt.Dimension(360, 640));

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

        Receipt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Receipt.setText("Receipt (image)");

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

        expAmountTF.setText("RM ");
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
                    false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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

        jButton1.setText("Upload");

        javax.swing.GroupLayout ExpensesLayout = new javax.swing.GroupLayout(Expenses);
        Expenses.setLayout(ExpensesLayout);
        ExpensesLayout.setHorizontalGroup(
                ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ExpensesLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(expTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(ExpensesLayout.createSequentialGroup()
                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(expDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Receipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Amount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ExpDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(expDescTF, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(expAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(expCategoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1))
                                                .addGap(77, 77, 77))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(25, 25, 25))
                        .addGroup(ExpensesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(addBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menuBtn)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        ExpensesLayout.setVerticalGroup(
                ExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ExpensesLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(expTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(Receipt)
                                        .addComponent(jButton1))
                                .addGap(7, 7, 7)
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
                                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(203, Short.MAX_VALUE))
        );

        expTitle.getAccessibleContext().setAccessibleDescription("");

        Transactions.addTab("Expenses", Expenses);

        Income.setBackground(new java.awt.Color(164, 164, 255));

        incTitle.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        incTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        incTitle.setText("INCOMES");
        incTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        incDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        incDate.setText("Date");

        expDescTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expDescTF1ActionPerformed(evt);
            }
        });

        Description1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Description1.setText("Description");

        Receipt1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Receipt1.setText("Receipt (image)");

        Category1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Category1.setText("Category");

        incCategoryCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Scholarship", "Part-time Job", "Loan", " " }));
        incCategoryCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incCategoryCBActionPerformed(evt);
            }
        });

        Amount1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Amount1.setText("Amount");

        incAmountTF.setText("RM ");
        incAmountTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incAmountTFActionPerformed(evt);
            }
        });

        expTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(expTable1);

        enterBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        enterBtn1.setText("Add");
        enterBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBtn1ActionPerformed(evt);
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

        jButton2.setText("Upload");

        javax.swing.GroupLayout IncomeLayout = new javax.swing.GroupLayout(Income);
        Income.setLayout(IncomeLayout);
        IncomeLayout.setHorizontalGroup(
                IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IncomeLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IncomeLayout.createSequentialGroup()
                                                .addComponent(enterBtn1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IncomeLayout.createSequentialGroup()
                                                                .addComponent(editBtn1)
                                                                .addGap(175, 175, 175))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IncomeLayout.createSequentialGroup()
                                                                .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(menuBtn1)))
                                                .addGap(25, 25, 25))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IncomeLayout.createSequentialGroup()
                                                .addComponent(incTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(17, 17, 17))
                                        .addGroup(IncomeLayout.createSequentialGroup()
                                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Receipt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                                                        .addComponent(expDescTF1)
                                                                        .addComponent(incCategoryCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(incAmountTF, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(IncomeLayout.createSequentialGroup()
                                                                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGap(33, 33, 33)))
                                                                .addGap(32, 32, 32)))
                                                .addGap(102, 102, 102))
                                        .addGroup(IncomeLayout.createSequentialGroup()
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addGap(25, 25, 25))))
        );
        IncomeLayout.setVerticalGroup(
                IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IncomeLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(incTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(incDate)
                                        .addComponent(incDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Description1)
                                        .addComponent(expDescTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(IncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Receipt1)
                                        .addComponent(jButton2))
                                .addGap(7, 7, 7)
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
                                        .addComponent(enterBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(menuBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(305, 305, 305))
        );

        Transactions.addTab("Incomes", Income);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Transactions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Transactions, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void menuBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        Menu menu = new Menu();
        menu.show();
        dispose();
    }

    private void deleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void editBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void enterBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
        createNewIncome();
        addInc();
    }

    private void incAmountTFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void incCategoryCBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void expDescTF1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Menu menu = new Menu();
        menu.show();
        dispose();
    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        createNewExpenses();
        addExp();
        showExp();

        //DATE, DESCRIPTION, CATEGORY, AMOUNT
//        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String date = dFormat.format(ExpDateChooser.getDate());
//        String category = expCategoryCB.getSelectedItem().toString();
//        DefaultTableModel model = (DefaultTableModel)expTable.getModel();
//
//        model.addRow(new Object[]{date,expDescTF.getText(), category ,expAmountTF.getText()});
        //        double amount = Double.parseDouble(expAmountTF.getText());
    }

    private void expAmountTFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void expCategoryCBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String expCat = expCategoryCB.getSelectedItem().toString();

    }

    private void expDescTFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void expTableMouseClicked(java.awt.event.MouseEvent evt){

    }

    // public static void main(String args[]) {
    //     /* Set the Nimbus look and feel */
    //     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //     /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
    //      */
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new CRUD().setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify
    private javax.swing.JLabel Amount;
    private javax.swing.JLabel Amount1;
    private javax.swing.JLabel Category;
    private javax.swing.JLabel Category1;
    private javax.swing.JLabel Description;
    private javax.swing.JLabel Description1;
    private com.toedter.calendar.JDateChooser ExpDateChooser;
    private javax.swing.JPanel Expenses;
    private javax.swing.JPanel Income;
    private javax.swing.JLabel Receipt;
    private javax.swing.JLabel Receipt1;
    private javax.swing.JTabbedPane Transactions;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn1;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton editBtn1;
    private javax.swing.JButton enterBtn1;
    private javax.swing.JTextField expAmountTF;
    private javax.swing.JComboBox<String> expCategoryCB;
    private javax.swing.JLabel expDate;
    private javax.swing.JTextField expDescTF;
    private javax.swing.JTextField expDescTF1; //incDescTF
    private javax.swing.JTable expTable;
    private javax.swing.JTable expTable1;
    private javax.swing.JLabel expTitle;
    private javax.swing.JTextField incAmountTF;
    private javax.swing.JComboBox<String> incCategoryCB;
    private javax.swing.JLabel incDate;
    private com.toedter.calendar.JDateChooser incDateChooser;
    private javax.swing.JLabel incTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton menuBtn;
    private javax.swing.JButton menuBtn1;

    // End of variables declaration
}
