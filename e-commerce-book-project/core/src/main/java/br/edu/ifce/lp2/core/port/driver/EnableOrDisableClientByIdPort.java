package br.edu.ifce.lp2.core.port.driver;

public interface EnableOrDisableClientByIdPort {
    void execute(String id, boolean enable);
}
