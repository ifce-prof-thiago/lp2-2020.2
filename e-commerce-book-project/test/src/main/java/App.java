import br.edu.ifce.lp2.core.domain.Hello;

public class App {

    public static void main(String[] args) {

        Hello x = new Hello();
        x.setMsg("Hello");

        System.out.println(x.getMsg());

    }
}
