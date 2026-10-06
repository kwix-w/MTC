package org.example;

import java.math.BigDecimal;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account account = new Account(12345, 999, new BigDecimal("10000.00"), BankType.AUM);
        System.out.println("Эталонный аккаунт в базе: " + account);

        System.out.println("Введите 5-значный номер карты: ");
        if (!scanner.hasNextInt()){
            System.out.println("Ошибка доступа: номер карты должен быть числом.");
            return;
        }
        int enteredCard = scanner.nextInt();
        System.out.println("Введите 3-значный пин-код: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка доступа: пин-код должен быть числом.");
            return;
        }
        int enteredPin = scanner.nextInt();
        if (enteredCard != account.getCardNum() || enteredPin != account.getPin()) {
            System.out.println("Ошибка доступа: неверный номер карты или пин-код.");
            return;
        }
        System.out.println("Авторизация успешна.\n");
        CashMachine bankomat = new CashMachine();

        System.out.println("Введите сумму для внесения: ");
        if (!scanner.hasNextBigDecimal()) {
            System.out.println("Ошибка: неверный формат суммы.");
            return;
        }
        BigDecimal depositSum = scanner.nextBigDecimal();
        account.balance = bankomat.deposit(account.getBalance(), depositSum);
        System.out.println("Обновленный баланс после внесения: " + account.getBalance() + " руб.");
        System.out.println();

        System.out.print("Введите сумму для снятия: ");
        if (!scanner.hasNextBigDecimal()) {
            System.out.println("Ошибка: неверный формат суммы.");
            return;
        }
        BigDecimal withdrawSum = scanner.nextBigDecimal();
        account.balance = bankomat.withdraw(account.getBalance(), withdrawSum, account.getBankType());
        System.out.println("Обновленный баланс после снятия: " + account.getBalance() + " руб.");



    }
}