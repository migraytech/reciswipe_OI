package com.reciswipe.recipe.helpers;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {
    NOTHING_WRONG(0),
    FAILED_JSON_CONVERSION(1000),

    FAILED_CREATING_RECIPE(3001),

    GENERIC_OR_UNKNOWN(1);

    private int value;
    private static Map map = new HashMap<>();

    private ErrorCode(){

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
