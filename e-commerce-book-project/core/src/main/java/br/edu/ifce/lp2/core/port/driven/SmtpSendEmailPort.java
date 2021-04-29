package br.edu.ifce.lp2.core.port.driven;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public interface SmtpSendEmailPort {

    void execute(Message message);

    @Getter
    @Setter
    class Message {
        private Set<String> receivers;
        private String subject;
        private String body;
    }

}
