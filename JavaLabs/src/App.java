import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
        System.out.println("Result: " + result);

        // task 3
        var input = new Scanner(System.in).nextInt();
        if (input > 3) {
            System.out.println("Add 10");
            input += 10;
        } else {
            System.out.println("Subtract 10");
            input -= 10;
        }
        System.out.println("Result: " + input);
    }
}
