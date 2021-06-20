public class App {
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Insert entity to work with");
            System.out.println("1. Академическая группа");
            System.out.println("2. Специальность");
            System.out.println("3. Дисциплина");
            System.out.println("4. Аудитория");
            System.out.println("5. Преподаватель");

            var option = Integer.parseInt(System.console().readLine());
        }
    }
}

abstract class BaseCodeWithNumber {
    String code; // код
    int number; // номер
}

class Group extends BaseCodeWithNumber {
    void displayInfo() {
        System.out.printf("Group code: %s \tNumber: %d\n", code, number);
    }
}

class Speciality extends BaseCodeWithNumber {
    void displayInfo() {
        System.out.printf("Speciality code: %s \tNumber: %d\n", code, number);
    }
}
