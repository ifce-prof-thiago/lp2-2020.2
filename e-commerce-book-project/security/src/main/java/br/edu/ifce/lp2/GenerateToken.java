package br.edu.ifce.lp2;

import br.edu.ifce.lp2.core.domain.Client;
import br.edu.ifce.lp2.core.port.driven.GenerateJWTPort;

import javax.inject.Named;

import static br.edu.ifce.lp2.Base64URL.encode;
import static java.lang.String.format;

@Named
public class GenerateToken implements GenerateJWTPort {

    private static String header = """
                {
                    "alg": "HS256"
                }
            """;

    private static String payload = """
            {
                    "username":%s
            }
            """;

    private static String keyBackend = "Abcd1234@";

    public String execute(Client client, String fingerprint) {

        payload = format(payload, client.getEmail(), client.getName());

        var key = keyBackend + fingerprint;

        var encodedData = format("%s.%s", encode(header), encode(payload));

        var signature = HmacSha256.sign(key, encodedData);

        return format("%s.%s", encodedData, signature);

    }
}
