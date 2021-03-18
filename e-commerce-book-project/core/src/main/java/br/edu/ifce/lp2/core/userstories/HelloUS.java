package br.edu.ifce.lp2.core.userstories;

import br.edu.ifce.lp2.core.domain.Hello;
import br.edu.ifce.lp2.core.port.driver.HelloPort;

public class HelloUS implements HelloPort {

    @Override
    public void execute(String msg) {

        var hello = new Hello();
        hello.setMsg(msg);
        hello.print();

    }
}
