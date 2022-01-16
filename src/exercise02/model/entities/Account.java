package exercise02.model.entities;

import exercise02.model.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    private static final String ERR_WITHOUT_BALANCE = "Sua conta não possui saldo suficiente para efetuar a transação";
    private static final String ERR_WITHDRAW_LIMIT = "Limite de saque ultrapassado!";

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw (Double amount) throws DomainException{
        if (balance < amount){
            throw new DomainException(ERR_WITHOUT_BALANCE);
        }
        if (withdrawLimit < amount){
            throw new DomainException(ERR_WITHDRAW_LIMIT);
        }
        balance -= amount;
    }
}
