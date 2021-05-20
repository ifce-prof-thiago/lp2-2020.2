package br.edu.ifce.lp2;

import java.util.Base64;

public class Base64URL {

    private Base64URL() {}

    public static String encode(String data) {
        return encode(data.getBytes());
    }

    public static String encode(byte[] data) {
        return new String(Base64.getUrlEncoder().withoutPadding().encodeToString(data));
    }

    public static String decode(String dada) {
        return new String(Base64.getUrlDecoder().decode(dada));
    }

}
