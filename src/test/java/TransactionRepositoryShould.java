import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class )
public class TransactionRepositoryShould {

    public static final String TODAY = "02/04/2019";
    private TransactionRepository transactionsRepository;
    @Mock Clock clock;

    @Before
    public void setUp() throws Exception {

        given(clock.todayAsString()).willReturn(TODAY);
        this.transactionsRepository = new TransactionRepository(clock);
    }

    @Test
    public void
    create_and_Store_a_deposit_transaction() {

        transactionsRepository.deposit(100);

        List<Transaction> transactions = transactionsRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, 100)));
    }

    @Test
    public void
    create_and_Store_a_withdraw_transaction() {

        transactionsRepository.withdraw(100);

        List<Transaction> transactions = transactionsRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, -100)));
    }

    private Transaction transaction(String date, int amount) {
        return new Transaction(date, amount);
    }
}