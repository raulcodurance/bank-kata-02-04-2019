import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ClockShould {


    private Clock clock;


    @Before
    public void setUp() throws Exception {
        this.clock = new TestableClock();
    }

    @Test
    public void
    return_today_as_dd_MM_yyyy_format() {

        String date = clock.todayAsString();
        assertThat(date, is("10/04/2019"));
    }


    private class TestableClock extends Clock {
        @Override
        protected LocalDate today() {
            return LocalDate.of(2019,04,10);
        }
    }
}