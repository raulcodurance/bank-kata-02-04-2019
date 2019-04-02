public class AccountImpl implements Account {

    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    public AccountImpl(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
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

        statementPrinter.print(transactionRepository.allTransactions());
    }
}
