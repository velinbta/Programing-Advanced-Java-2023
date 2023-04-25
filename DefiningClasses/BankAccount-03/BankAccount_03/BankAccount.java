package BankAccount_03;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private static int id;
    private static double defaultInterestRate = 0.02;
    private double balance;
    private static final List<BankAccount> bankAccountList = new ArrayList<>();

    public static void create() {
        // Прибавя нов акаунт в списъка и същевременно увеличава и броя на създадените акаунти
        bankAccountList.add(new BankAccount());
    }

    public BankAccount() {
        // Увеличава глобално броя на създадените акаунти
        id++;
    }

    public static void setInterestRate(double interestRate) {
        defaultInterestRate = interestRate;
    }

    public double getInterest(int years) {
        // Пресмята лихвения процент за зададените години
        return balance * (years * defaultInterestRate);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public static BankAccount getAccount(int accountNumber) {
        // Връща посочени акаунт от списъка
        return bankAccountList.get(accountNumber - 1);
    }

    public static boolean isValid(int accountNumber) {
        // Проверява, дали акаунта е валиден в списъка с акаунти
        return accountNumber - 1 >= 0 && accountNumber - 1 < bankAccountList.size();
    }

    public static int getIdCount() {
        // Връща броя на всички акаунти
        return id;
    }

}
