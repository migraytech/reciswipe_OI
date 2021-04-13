package com.reciswipe.auth.helpers;

public class JsonResult {
    private String message;
    private Boolean result;
    private Object item;
    private int errorCode;
    private ErrorCode errorEnum;
    private String errorMessage;

    public JsonResult() {
    }

    public JsonResult(String text, Boolean result) {
        this.message = text;
        this.result = result;
    }

    public JsonResult(String text, Boolean result, Object item) {
        this.message = text;
        this.result = result;
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        setErrorEnum(ErrorCode.valueOf(errorCode));
    }

    public void setErrorCode(ErrorCode errorCode) {
        setErrorEnum(errorCode);
        setErrorCode(errorCode.getValue());
    }

    public void setErrorCode(String errorCode){
        setErrorCode((ErrorCode.valueOf(errorCode)));
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Enum getErrorEnum() {
        return errorEnum;
    }

    private void setErrorEnum(ErrorCode errorEnum) {
        this.errorEnum = errorEnum;
    }
}
