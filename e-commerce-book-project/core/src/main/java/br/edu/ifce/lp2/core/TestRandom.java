package br.edu.ifce.lp2.core;

import java.security.SecureRandom;

public class TestRandom {

    private final static String chars = "1234567890ABCDEFGHIJKLMNOPQRSTUVXYWZabcdefg";

    public static void main(String[] args) {

        var random = new SecureRandom();

        for (var i = 0; i < 10; i++) {
            var x = random.nextInt(chars.length());
            System.out.println(chars.charAt(x));
        }

    }
}
