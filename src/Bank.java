package banking;

public class Main {
    public static void main(String[] args) {

        Account acc1 = new Account(1001, 5000);
        Account acc2 = new Account(1002, 3000);

        Customer customer1 = new Customer("Alice", acc1);
        Customer customer2 = new Customer("Bob", acc2);

        Bank bank = new Bank("National Bank");

        System.out.println(customer1);
        System.out.println(customer2);

        bank.compareCustomers(customer1, customer2);
    }
}

