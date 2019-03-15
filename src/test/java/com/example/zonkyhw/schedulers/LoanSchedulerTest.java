package com.example.zonkyhw.schedulers;

import org.awaitility.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanSchedulerTest {

    @SpyBean
    private LoanScheduler loanScheduler;

    @Test
    public void shouldRunTwoTimes() {
        await().atMost(Duration.FIVE_MINUTES)
                .untilAsserted(() -> verify(loanScheduler, times(2)).lookForLoans());
        verifyNoMoreInteractions(loanScheduler);
    }

}
