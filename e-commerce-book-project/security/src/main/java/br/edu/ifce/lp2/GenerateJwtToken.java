package br.edu.ifce.lp2;

import br.edu.ifce.lp2.core.domain.Client;
import br.edu.ifce.lp2.core.port.driven.GenerateJWTPort;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import javax.inject.Named;
import java.time.Instant;
import java.util.Date;

@Named
public class GenerateJwtToken implements GenerateJWTPort {

    public String execute(Client client, String fingerprint) {

        try {
            var index = Keys.randomIndex();

            var header = new JWSHeader.Builder(JWSAlgorithm.HS256)
                    .type(JOSEObjectType.JWT)
                    .keyID(String.format("%s", index))
                    .build();

            var payload = new JWTClaimsSet.Builder()
                    .issuer("https://ifce.lp2.edu.br")
                    .audience("https://ifce.lp2.edu.br")
                    .subject(client.getEmail())
                    .expirationTime(Date.from(Instant.now().plusSeconds(3600)))
                    .build();

            var signedJWT = new SignedJWT(header, payload);

            signedJWT.sign(new MACSigner(Keys.get(index, fingerprint)));

            return signedJWT.serialize();

        } catch (JOSEException e) {
            throw new IllegalArgumentException(e);
        }


    }
}
