package Banking.com;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Java Banking System v1.0 ===");

        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить клиента");
            System.out.println("2. Создать счет для клиента");
            System.out.println("3. Показать всех клиентов");
            System.out.println("4. Найти богатых клиентов");
            System.out.println("5. Выход");
            System.out.print("> ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите email: ");
                    String email = scanner.nextLine();
                    bank.addCustomer(new Customer(name, email));
                }
                case "2" -> {
                    System.out.print("Введите имя клиента: ");
                    String searchName = scanner.nextLine();
                    bank.findCustomerByName(searchName).ifPresentOrElse(
                            customer -> {
                                System.out.print("Начальный баланс: ");
                                try {
                                    BigDecimal balance = new BigDecimal(scanner.nextLine());
                                    customer.addAccount(new SavingsAccount(balance, 0.05));
                                    System.out.println("Счет создан.");
                                } catch (NumberFormatException e) {
                                    System.out.println("Ошибка: введите число.");
                                }
                            },
                            () -> System.out.println("Клиент не найден.")
                    );
                }
                case "3" -> {
                    bank.getSortedCustomers().forEach(c -> {
                        System.out.println(c);
                        c.getAccounts().forEach(a -> System.out.println("\t" + a));
                    });
                }
                case "4" -> bank.filterCustomersRich(new BigDecimal("1000.00"))
                        .forEach(System.out::println);
                case "5" -> running = false;
            }
        }
    }
}