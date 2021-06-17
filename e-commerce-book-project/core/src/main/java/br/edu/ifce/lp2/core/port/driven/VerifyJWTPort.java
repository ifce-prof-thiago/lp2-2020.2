package br.edu.ifce.lp2.core.port.driven;

public interface VerifyJWTPort {
    boolean execute(String jwt, String fingerprint);
}
