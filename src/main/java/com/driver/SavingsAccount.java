package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    int timesOfWithdraw = 0;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0.0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        try {
            if(amount >= maxWithdrawalLimit){
                throw new Exception("Maximum Withdraw Limit Exceed");
            }
            else {
                super.withdraw(amount);
                timesOfWithdraw++;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double simpleInterest = (getBalance() * getRate() * years)/100;
        return simpleInterest + getBalance();
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double principal = getBalance();  // Get the initial balance
        double rate = getRate();          // Get the annual interest rate

        double compoundInterest = principal * Math.pow(1 + (rate / (100 * times)), times * years);

        // Calculate the final amount by subtracting the principal (initial amount)
        double finalAmount = compoundInterest - principal;

        return finalAmount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public int getTimesOfWithdraw() {
        return timesOfWithdraw;
    }

    public void setTimesOfWithdraw(int timesOfWithdraw) {
        this.timesOfWithdraw = timesOfWithdraw;
    }
}
