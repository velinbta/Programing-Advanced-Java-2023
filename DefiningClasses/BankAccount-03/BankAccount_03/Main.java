package BankAccount_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {

                case "Create":
                    // Добавя нов акант и увеличава броя на създадените акаунти
                    BankAccount.create();
                    System.out.printf("Account ID%d created\n", BankAccount.getIdCount());

                    break;

                case "Deposit": {
                    // Депозира дадената сума, ако акаунтът е валиден
                    int id = Integer.parseInt(data[1]);
                    double amount = Double.parseDouble(data[2]);

                    if (BankAccount.isValid(id)) {

                        BankAccount.getAccount(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d\n", amount, id);

                    } else {

                        System.out.println("Account does not exist");

                    }

                    break;
                }
                case "SetInterest":
                    // Задава лихвен процент за всички акаунти
                    double interestRate = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interestRate);

                    break;

                case "GetInterest": {
                    // Дава лихвения процент за определени години на посочен акаунт, ако е валиден
                    int id = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);

                    if (BankAccount.isValid(id)) {

                        double currentAccountInterestRate = BankAccount.getAccount(id).getInterest(years);
                        System.out.printf("%.2f\n", currentAccountInterestRate);

                    } else {

                        System.out.println("Account does not exist");

                    }
                    break;
                }

                default:

                    throw new IllegalArgumentException("Command not found " + command);

            }

            input = scanner.nextLine();
        }

    }

}
