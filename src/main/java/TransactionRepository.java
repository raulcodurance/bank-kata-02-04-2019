import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    private final Clock clock;
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(Clock clock) {

        this.clock = clock;
    }

    public void deposit(int amount) {

        Transaction deposit = new Transaction(clock.todayAsString(), amount);
        transactions.add(deposit);
    }

    public void withdraw(int amount) {

        Transaction withdraw = new Transaction(clock.todayAsString(), -amount);
        transactions.add(withdraw);
    }

    public List<Transaction> allTransactions() {

        return Collections.unmodifiableList(transactions);
    }
}
