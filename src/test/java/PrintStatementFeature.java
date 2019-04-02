import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    @Mock Console console;

    private Account account;
    private TransactionRepository transactionRepository;

    @Before
    public void setUp() throws Exception {

        this.transactionRepository = new TransactionRepository();
        this.account = new AccountImpl(transactionRepository);
    }

    @Test
    public void
    print_statement() {

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).print("DATE       | AMOUNT  | BALANCE");
        inOrder.verify(console).print("10/04/2014 | 500.00  | 1400.00");
        inOrder.verify(console).print("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).print("01/04/2014 | 1000.00 | 1000.00");
    }
}
