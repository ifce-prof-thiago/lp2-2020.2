package br.edu.ifce.lp2;

import br.edu.ifce.lp2.core.port.driven.GetIdByClientLoggedPort;
import br.edu.ifce.lp2.core.port.driven.VerifyJWTPort;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Objects;

@Named
@RequiredArgsConstructor
public class GetIdByClientLogged implements GetIdByClientLoggedPort {

    private final HttpServletRequest http;
    private final VerifyJWTPort verifyJWTPort;

    @Override
    public String execute() {

        String jwt = getJwt();

        verify(jwt);

        try {
            var token = SignedJWT.parse(jwt);
            return token.getJWTClaimsSet().getSubject();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Token not is valid!");
        }

    }

    private String getJwt() {

        var authHeader = http.getHeader("Authorization");

        if (Objects.isNull(authHeader))
            throw new IllegalArgumentException("Token not is valid!");

        return authHeader.substring("Bearer".length()).trim();
    }

    private void verify(String jwt) {
        var userAgent = http.getHeader("User-Agent");
        var isValid = verifyJWTPort.execute(jwt, userAgent);

        if (!isValid)
            throw new IllegalArgumentException("Token not is valid!");
    }
}
