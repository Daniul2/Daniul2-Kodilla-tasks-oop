package com.kodilla;

interface Employee {
    double calculateSalary();
}

public class Application1 {
    public static void main(String[] args) {

        Employee perProductEmployee = new PerProductEmployee(300, 5.0);
        SalaryPayoutProcessor processor1 = new SalaryPayoutProcessor(perProductEmployee);
        processor1.processPayout();

        Employee basePlusBonusEmployee = new BasePlusBonusEmployee(2000.0, true);
        SalaryPayoutProcessor processor2 = new SalaryPayoutProcessor(basePlusBonusEmployee);
        processor2.processPayout();
    }
}

class PerProductEmployee implements Employee {
    private final int productsMade;
    private final double payPerProduct;

    public PerProductEmployee(int productsMade, double payPerProduct) {
        this.productsMade = productsMade;
        this.payPerProduct = payPerProduct;
    }

    @Override
    public double calculateSalary() {
        return productsMade * payPerProduct;
    }
}

class BasePlusBonusEmployee implements Employee {
    private final double baseSalary;
    private final boolean extraSaleMade;

    public BasePlusBonusEmployee(double baseSalary, boolean extraSaleMade) {
        this.baseSalary = baseSalary;
        this.extraSaleMade = extraSaleMade;
    }

    @Override
    public double calculateSalary() {
        return extraSaleMade ? baseSalary * 1.2 : baseSalary;
    }
}

abstract class SalaryPayout {
    private final Employee employee;

    public SalaryPayout(Employee employee) {
        this.employee = employee;
    }

    protected abstract void payout();

    public void processPayout() {
        System.out.println("Creating payout for: " + employee.calculateSalary() + " PLN");
        payout();
        System.out.println("Payout has been completed!");
    }
}

class SalaryPayoutProcessor extends SalaryPayout {
    public SalaryPayoutProcessor(Employee employee) {
        super(employee);
    }

    @Override
    protected void payout() {
        System.out.println("Sending money to employee");
    }
}
