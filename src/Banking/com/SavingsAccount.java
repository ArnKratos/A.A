package Banking.com;
import java.math.BigDecimal;
// Inheritance: Наследование от AbstractAccount
public class SavingsAccount extends AbstractAccount {
    private double interestRate;

    public SavingsAccount(BigDecimal initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    // Polymorphism: Реализация абстрактного метода
    @Override
    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            System.out.println("Ошибка: Недостаточно средств.");
        } else {
            balance = balance.subtract(amount);
            System.out.println("Успешно снято: " + amount);
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount{" + super.toString() + ", rate=" + interestRate + "}";
    }
}
