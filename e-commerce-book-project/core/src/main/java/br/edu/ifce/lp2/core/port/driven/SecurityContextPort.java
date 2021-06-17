package br.edu.ifce.lp2.core.port.driven;

public interface SecurityContextPort {

    boolean isAdmin();

    boolean isUser();

    boolean isEnabled();

    boolean isNotAdmin();

    boolean isNotUser();

    boolean isNotEnabled();

}
