package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class Account {
    public int cardNum;
    public int pin;
    public BigDecimal balance;
    public BankType bankType;

    public Account(int cardNum, int pin, BigDecimal balance, BankType bankType){
        if(cardNum >= 10000 && cardNum <= 99999) {
            this.cardNum = cardNum;
        } else {
            this.cardNum = 10000;
        }
        if(pin >= 100 && pin <= 999){
            this.pin = pin;
        } else {
            this.pin = 100;
        }
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            this.balance = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        } else {
            this.balance = balance.setScale(2, RoundingMode.HALF_UP);
        }
        if (bankType == null) {
            this.bankType = BankType.NEO;
        } else {
            this.bankType = bankType;
        }
    }
    public int getCardNum(){
        return cardNum;
    }
    public int getPin(){
        return pin;
    }
    public BigDecimal getBalance(){
        return balance;
    }
    public BankType getBankType(){
        return bankType;
    }

    @Override
    public String toString() {
        return bankType.getName() + " Карта: " + cardNum + ", Баланс: " + balance + " руб.";

    }
}
