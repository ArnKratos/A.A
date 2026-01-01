package Banking.com;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

// Abstraction principle: Абстрактный базовый класс
public abstract class AbstractAccount {
    // Encapsulation: поля private
    private final String id;
    protected BigDecimal balance; // protected для доступа в наследниках

    public AbstractAccount(BigDecimal initialBalance) {
        this.id = UUID.randomUUID().toString(); // Генерация уникального ID
        this.balance = initialBalance;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Сумма депозита должна быть положительной");
        }
        this.balance = this.balance.add(amount);
    }

    // Абстрактный метод, который должны реализовать наследники
    public abstract void withdraw(BigDecimal amount);

    // Overriding methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAccount that = (AbstractAccount) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Balance: " + balance;
    }
}
