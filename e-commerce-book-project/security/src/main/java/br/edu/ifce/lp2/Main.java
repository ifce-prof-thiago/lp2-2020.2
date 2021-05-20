package br.edu.ifce.lp2;

import static br.edu.ifce.lp2.Base64URL.encode;
import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {

        var header = """
                    {
                        "alg": "HS256"
                    }
                """;

        var payload = """
                {
                     "username": "thiago@lar.ifce.edu.br",
                     "permission": "ROLE_ADMIN"           
                }
                """;

        var key = "KEY_BACKEND+{FINGERPRINT}";

        var encodedData = format("%s.%s", encode(header), encode(payload));

        var signature = HmacSha256.sign(key, encodedData);

        var jwt = format("%s.%s", encodedData, signature);


    }
}
