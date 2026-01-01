package Banking.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String name;
    private String email;
    private List<AbstractAccount> accounts;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(AbstractAccount account) {
        this.accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public List<AbstractAccount> getAccounts() {
        return accounts;
    }

    // Sorting support (Comparable)
    @Override
    public int compareTo(Customer other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Customer: " + name + " (" + email + ")";
    }
}
