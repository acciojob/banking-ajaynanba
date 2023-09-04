package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    int timesOfWithdraw = 0;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
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
        double simpleInterest = getBalance() + (getBalance() * getRate() * years)/100;
        return simpleInterest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundInterest = getBalance() * (Math.pow((1 + getRate() / 100), years));
        return compoundInterest;
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
