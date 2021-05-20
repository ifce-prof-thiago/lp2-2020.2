package br.edu.ifce.lp2;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static br.edu.ifce.lp2.Base64URL.encode;
import static javax.crypto.Mac.getInstance;

public class HmacSha256 {

    private final static String algorithm = "HmacSha256";
    private final static String charsetName = "UTF-8";

    private HmacSha256() {
    }

    public static String sign(String secret, String data) {
        try {
            var sha256Hmac = getInstance(algorithm);

            var key = new SecretKeySpec(secret.getBytes(charsetName), algorithm);
            sha256Hmac.init(key);

            var signedBytes = sha256Hmac.doFinal(data.getBytes(charsetName));

            return encode(signedBytes);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            throw new RuntimeException("Error with HMAC SHA256");
        }
    }

}
