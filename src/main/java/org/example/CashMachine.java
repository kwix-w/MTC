package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashMachine implements WithdrawalOperations, DepositOperations{
    @Override
    public BigDecimal deposit(BigDecimal balance, BigDecimal sum) {
        if(balance == null) {
            balance = BigDecimal.ZERO;
        }
        if (sum == null || sum.compareTo(BigDecimal.ZERO) <= 0) {
            return balance.setScale(2, RoundingMode.HALF_UP);
        }
        return balance.add(sum).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal withdraw(BigDecimal balance, BigDecimal sum, BankType bankType) {
        if (balance == null) {
            balance = BigDecimal.ZERO;
        }
        if (sum == null || sum.compareTo(BigDecimal.ZERO) <= 0) {
            return balance.setScale(2, RoundingMode.HALF_UP);
        }
        BigDecimal commission = applyCommission(sum, bankType);
        BigDecimal totalDebit = sum.add(commission);

        if (totalDebit.compareTo(balance) > 0) {
            System.out.println("Недостаточно средств на счете.");
            return balance.setScale(2, RoundingMode.HALF_UP);
        }
        return balance.subtract(totalDebit).setScale(2, RoundingMode.HALF_UP);
    }
}
