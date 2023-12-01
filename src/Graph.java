import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Locale.Category;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph {
    private DefaultCategoryDataset expenseDataset;
    private DefaultCategoryDataset incomeDataset;

    private List<LocalDate> expenseDates;
    private List<LocalDate> incomeDates;

    public Graph() {
        expenseDataset = new DefaultCategoryDataset();
        incomeDataset = new DefaultCategoryDataset();
        expenseDates = new ArrayList<>();
        incomeDates = new ArrayList<>();
    }

    public void readExpensesData(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String dateString = fields[0];
                String amountString = fields[3];
                try {
                    LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    double amount = Double.parseDouble(amountString);
//                    String monthYear = YearMonth.from(date).format(DateTimeFormatter.ofPattern("MM-yyyy"));

                    if(filePath.equals("expenses.txt")){
                        expenseDataset.setValue(amount, "Expense", date.toString());
                        expenseDates.add(date);
                    } else if (filePath.equals("income.txt")){
                        incomeDataset.setValue(amount, "Income", date.toString());
                        incomeDates.add(date);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + line);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        JFreeChart expenseChart = ChartFactory.createLineChart("Total Expenses", "Month", "Amount",
                expenseDataset, PlotOrientation.VERTICAL, true, true, false);

        JFreeChart incomeChart = ChartFactory.createLineChart("Total Income", "Month", "Amount",
                incomeDataset, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel expenseChartPanel = new ChartPanel(expenseChart);
        ChartPanel incomeChartPanel = new ChartPanel(incomeChart);

        JFrame expenseFrame = new JFrame("Expense Summary");
        expenseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        expenseFrame.setSize(360, 640);
        expenseFrame.setLocationRelativeTo(null);
        expenseFrame.getContentPane().add(expenseChartPanel);

        JFrame incomeFrame = new JFrame("Income Summary");
        incomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        incomeFrame.setSize(360, 640);
        incomeFrame.setLocationRelativeTo(null);
        incomeFrame.getContentPane().add(incomeChartPanel);

        expenseFrame.setVisible(true);
        incomeFrame.setVisible(true);
    }
}
