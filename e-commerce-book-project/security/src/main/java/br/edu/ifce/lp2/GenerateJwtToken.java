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

        var index = Keys.randomIndex();

        var header = getJwsHeader(index);

        var payload = getJwtClaimsSet(client);

        var signedJWT = sign(index, header, payload, fingerprint);

        return signedJWT.serialize();
    }

    private JWSHeader getJwsHeader(int index) {
        return new JWSHeader.Builder(JWSAlgorithm.HS256)
                .type(JOSEObjectType.JWT)
                .keyID(String.format("%s", index))
                .build();
    }

    private JWTClaimsSet getJwtClaimsSet(Client client) {
        return new JWTClaimsSet.Builder()
                .issuer("https://ifce.lp2.edu.br")
                .audience("https://ifce.lp2.edu.br")
                .subject(client.getId())
                .expirationTime(Date.from(Instant.now().plusSeconds(3600)))
                .build();
    }

    private SignedJWT sign(int index, JWSHeader header, JWTClaimsSet payload, String fingerprint) {
        try {
            var signedJWT = new SignedJWT(header, payload);
            signedJWT.sign(new MACSigner(Keys.get(index, fingerprint)));
            return signedJWT;
        } catch (JOSEException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
