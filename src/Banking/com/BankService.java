package Banking.com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BankService {
    private List<Customer> customerPool;

    public BankService() {
        this.customerPool = new ArrayList<>();
    }

    // Метод добавления клиента
    public void addCustomer(Customer customer) {
        customerPool.add(customer);
    }

    // Searching: Поиск клиента по имени (возвращает Optional, чтобы избежать null)
    public Optional<Customer> findCustomerByName(String name) {
        return customerPool.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Sorting: Сортировка клиентов по имени
    public List<Customer> getSortedCustomers() {
        return customerPool.stream()
                .sorted() // Использует compareTo из класса Customer
                .collect(Collectors.toList());
    }

    // Filtering: Найти клиентов с балансом выше указанного (rich clients)
    public List<Customer> filterCustomersRich(BigDecimal threshold) {
        return customerPool.stream()
                .filter(c -> c.getAccounts().stream()
                        .anyMatch(a -> a.getBalance().compareTo(threshold) > 0))
                .collect(Collectors.toList());
    }
}
