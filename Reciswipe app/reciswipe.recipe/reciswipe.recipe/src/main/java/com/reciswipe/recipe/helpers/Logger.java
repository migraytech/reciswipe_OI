package com.reciswipe.recipe.helpers;

public class Logger {

    private Logger(){}
    private static void realLog(String source, String message) {
        System.out.println(source.toUpperCase() + ": " + message);
    }

    private static void errLog(String source, String message) {
        System.err.println(source.toUpperCase() + ": " + message);
    }

    public static void log(String source, String message) {
        realLog(source, message);
    }

    public static void log(String source, Object obj) {
        realLog(source, obj.toString());
    }

    public static void log(String source, Exception ex) {
        realLog(source, ex.toString());
    }

    public static void log(Class source, String message) {
        realLog(source.getName(), message);
    }

    public static void log(Class source, Object obj) {
        realLog(source.getName(), obj.toString());
    }

    public static void log(Class source, Exception ex) {
        realLog(source.getName(), ex.toString());
    }

    public static void log(String source, boolean error, String message) {
        errLog(source, message);
    }

    public static void log(String source, boolean error, Object obj) {
        errLog(source, obj.toString());
    }

    public static void log(String source, boolean error, Exception ex) {
        errLog(source, ex.toString());
    }

    public static void log(Class source, boolean error, String message) {
        errLog(source.getName(), message);
    }

    public static void log(Class source, boolean error, Object obj) {
        errLog(source.getName(), obj.toString());
    }

    public static void log(Class source, boolean error, Exception ex) {
        errLog(source.getName(), ex.toString());
    }
}
