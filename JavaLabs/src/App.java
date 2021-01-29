import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {

        // task 1
        System.out.println("Silence is golden");

        SimpleDateFormat formater = new SimpleDateFormat("EEEE");
        Date date = new Date();

        System.out.println(formater.format(date));
        System.out.println("Agnia");

        // task 2
        Float result = (float) 1 / 2 + (float) 1 / 4;
        System.out.println("Result:" + result);

    }
}
