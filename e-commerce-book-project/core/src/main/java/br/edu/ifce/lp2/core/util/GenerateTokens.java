package br.edu.ifce.lp2.core.util;

import br.edu.ifce.lp2.core.domain.Token;

import java.security.SecureRandom;

public class GenerateTokens {

    private final static String chars = "1234567890ABCDEFGHIJKLMNOPQRSTUVXYWZabcdefg";

    public static Token execute(int length) {

        var value = "";

        var random = new SecureRandom();

        for (var i = 0; i < length; i++) {
            value += chars.charAt(random.nextInt(chars.length()));
        }

        var token = new Token();
        token.setValue(value);

        return token;

    }


}
