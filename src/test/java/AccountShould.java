import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {


    @Mock TransactionRepository transactionRepository;
    @Mock StatementPrinter statementPrinter;

    private Account account;

    @Before
    public void setUp() throws Exception {

        this.account = new AccountImpl(transactionRepository, statementPrinter);
    }

    @Test
    public void
    store_a_deposit_transaction() {

        account.deposit(100);

        verify(transactionRepository).deposit(100);
    }

    @Test
    public void
    store_a_withdraw_transaction() {

        account.withdraw(100);

        verify(transactionRepository).withdraw(100);
    }

    @Test
    public void
    print_transactions_as_statements() {

        List<Transaction> transactions = asList(new Transaction("02/04/2019",100));

        given(transactionRepository.allTransactions()).willReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}