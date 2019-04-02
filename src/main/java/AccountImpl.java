public class AccountImpl implements Account {

    private TransactionRepository transactionRepository;

    public AccountImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void deposit(int amount) {

        transactionRepository.deposit(100);
    }

    @Override
    public void withdraw(int amount) {

        transactionRepository.withdraw(100);
    }

    @Override
    public void printStatement() {

    }
}
