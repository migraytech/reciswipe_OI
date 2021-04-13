package com.reciswipe.auth.helpers;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {

    NOTHING_WRONG(0),
    FAILED_JSON_CONVERSION(1000),

    FAILED_CREATING_USER(3001),
    FAILED_LOG_IN(3002),
    FAILED_DELETE_USER(3003),
    FAILED_RETRIEVING_ALL_ACCOUNTS(3004),
    FAILED_LOG_OUT(3005),

    GENERIC_OR_UNKNOWN(1);

    private int value;
    private static Map map = new HashMap<>();

    ErrorCode(){

    }
    private ErrorCode(int value) {
        this.value = value;
    }

    static {
        for (ErrorCode errorCode : ErrorCode.values()) {
            map.put(errorCode.value, errorCode);
        }
    }

    public static ErrorCode valueOf(int errorCode) {
        ErrorCode code = (ErrorCode) map.get(errorCode);
        if (code == null){
            code = GENERIC_OR_UNKNOWN;
        }
        return code;
    }

    public int getValue() {
        return value;
    }
}
