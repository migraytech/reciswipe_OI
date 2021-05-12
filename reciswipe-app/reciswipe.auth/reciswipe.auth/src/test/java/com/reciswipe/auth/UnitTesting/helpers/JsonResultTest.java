package com.reciswipe.auth.UnitTesting.helpers;

import com.reciswipe.auth.helpers.ErrorCode;
import com.reciswipe.auth.helpers.JsonResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JsonResultTest {

    private static JsonResult jsonResult;

    @Before
    public void setUp() {
        jsonResult = new JsonResult();
    }

    @Test
    public void getSetMessage() {
        String message = "UnitTest";
        jsonResult.setMessage(message);
        assertEquals(message, jsonResult.getMessage());
    }

    @Test
    public void getSetNullMessage() {
        String message = null;
        jsonResult.setMessage(message);
        assertEquals(message, jsonResult.getMessage());
    }

    @Test
    public void getSetResultTrue() {
        boolean result = true;
        jsonResult.setResult(result);
        assertEquals(result, jsonResult.getResult());
    }

    @Test
   public void getSetResultFalse() {
        boolean result = false;
        jsonResult.setResult(result);
        assertEquals(result, jsonResult.getResult());
    }

    @Test
   public void getSetItem() {
        Object object = new Object();
        jsonResult.setItem(object);
        assertEquals(object, jsonResult.getItem());
    }

    @Test()
    public void getSetItemNull() {
        Object object = null;
        jsonResult.setItem(object);
        assertEquals(object, jsonResult.getItem());
    }

    @Test
    public void SetGetErrorCodeOnNumber() {
        int code = 2001;
        jsonResult.setErrorCode(code);
        assertEquals(ErrorCode.valueOf(code), jsonResult.getErrorEnum());
        assertEquals(code, jsonResult.getErrorCode());
    }

    @Test
    public void SetGetErrorCodeOnEnum() {
        int code = 3001;
        jsonResult.setErrorCode(ErrorCode.valueOf(code));
        assertEquals(ErrorCode.valueOf(code), jsonResult.getErrorEnum());
        assertEquals(code, jsonResult.getErrorCode());
    }

    @Test
    public void GetSetErrorMessage() {
        String message = "UnitTest";
        jsonResult.setMessage(message);
        assertEquals(message, jsonResult.getMessage());
    }

}
