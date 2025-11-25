package org.example;

public final class MyUtilityClass {
    public static boolean isStringEmpty(String s){
        return (s == null || s.isBlank());
    }
}
