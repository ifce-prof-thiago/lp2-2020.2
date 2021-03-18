import br.edu.ifce.lp2.core.port.driver.HelloPort;
import br.edu.ifce.lp2.core.userstories.HelloUS;

public class App {

    public static void main(String[] args) {

        HelloPort helloPort = new HelloUS();

        helloPort.execute("Bob");

    }
}
