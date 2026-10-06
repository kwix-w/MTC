package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface WithdrawalOperations {
    BigDecimal withdraw(BigDecimal balance, BigDecimal sum, BankType bankType);

    default BigDecimal applyCommission(BigDecimal sum, BankType bankType){
        if(sum == null || bankType == null || sum.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
            BigDecimal rawCommission = sum.multiply(bankType.getCommission());
            return rawCommission.setScale(2, RoundingMode.HALF_UP);

        }


    }

