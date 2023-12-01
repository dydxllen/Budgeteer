import java.time.LocalDate;

public class incData {
    LocalDate incomeDate;
    String incomeDescription;
    String incomeCategory;
    Float incomeAmount;

    public incData(LocalDate incomeDate, String incomeDescription, String incomeCategory, Float incomeAmount){
        this.incomeDate = incomeDate;
        this.incomeDescription = incomeDescription;
        this.incomeCategory = incomeCategory;
        this.incomeAmount = incomeAmount;
    }
    public LocalDate getIncomeDate(){
        return incomeDate;
    }

    public String getIncomeDescription(){
        return incomeDescription;
    }

    public String getIncomeCategory(){
        return incomeCategory;
    }

    public Float getIncomeAmount(){
        return incomeAmount;
    }
}
