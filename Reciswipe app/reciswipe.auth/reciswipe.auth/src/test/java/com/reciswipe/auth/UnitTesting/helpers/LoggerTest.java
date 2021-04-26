package com.reciswipe.auth.UnitTesting.helpers;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.reciswipe.auth.helpers.Logger.log;

@SpringBootTest
public class LoggerTest {

    @Test
    public void logStringSourceMessage() {
        log("Test", "");
    }
    @Test
    public void logStringSourceExceptionMessage() {
        log("Test", "");
    }

    @Test
    public void logClassSourceMessage() {
        log(this.getClass().getName(), "Test this log by name ");
    }

    @Test
    public void logClassSourceExceptionMessage() {
        log(this.getClass(), "Everything broke again");
    }

    @Test
    public void logClassSourceExceptionByErrorNullPointerException()
    {
        try{
            String empty = null;
            String not = empty.substring(0);
        }
        catch (Exception e) {
            log(this.getClass(), true, e);
        }
    }

    @Test
    public void logClassSourceExceptionByErrorNullPointerException2()
    {
        try{
            String empty = null;
            String not = empty.substring(1);
        }
        catch (Exception e) {
            log(this.getClass(), true, e);
        }
    }

}
