package com.ia.cobol.test;

public class Test {
    public static void main(String[] args) {
        String text = "line 1nnline 3nnnline 5";
        String adjusted = text.replaceAll("(?m)^[ t]*r?n", "");
        System.out.println(adjusted);

    }
}
