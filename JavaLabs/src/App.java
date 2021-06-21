import java.util.ArrayList;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Information information = new Information();
        while (true) {
            System.out.println("Insert action to do");
            System.out.println("1. Remove");
            System.out.println("2. Create");
            System.out.println("3. Edit");
            System.out.println("4. ShowAll");

            var option = Integer.parseInt(System.console().readLine());
            if (option == 4) {
                information.displayInfo();
                continue;
            }

            var entity = Integer.parseInt(System.console().readLine());
            System.out.println("Set entity to work with");
            System.out.println("1. Академическая группа");
            System.out.println("2. Специальность");
            System.out.println("3. Дисциплина");
            System.out.println("4. Аудитория");
            System.out.println("5. Преподаватель");

        }
    }
}

interface IPrintable {
    void displayInfo();
}

abstract class BaseNumber {
    int number; // номер
}

abstract class BaseCodeWithNumber extends BaseNumber {
    String code; // код
}

class Group extends BaseCodeWithNumber implements IPrintable {
    public void displayInfo() {
        System.out.printf("Group code: %s \tNumber: %d\n", code, number);
    }
}

class Speciality extends BaseCodeWithNumber implements IPrintable {
    public void displayInfo() {
        System.out.printf("Speciality code: %s \tNumber: %d\n", code, number);
    }
}

class Discipline extends BaseCodeWithNumber implements IPrintable {
    int hours; // кол-во часов

    public void displayInfo() {
        System.out.printf("Discipline code: %s \tNumber: %d \tHours: %d\n", code, number, hours);
    }
}

class Audience extends BaseNumber implements IPrintable {
    public void displayInfo() {
        System.out.printf("Audience number: %d\n", number);
    }
}

class Teacher implements IPrintable {
    String name; // имя
    String surname; // фамилия
    String fatherName; // отчество
    String telephone; // телефон
    Date dateOfBirth; // дата рождения
    ArrayList<Discipline> disciplines;

    public void displayInfo() {
        System.out.printf("Teacher Name: %s \tSurname: %s \tFatherName: %s \tTelephone %s \tDateOfBirth: %F\n", name,
                surname, fatherName, telephone, dateOfBirth);
        System.out.println("Disciplines:" + disciplines);
    }
}

class Information implements IPrintable {
    public Information() {
        groups = new ArrayList<>();
        specialities = new ArrayList<>();
        disciplines = new ArrayList<>();
        audiences = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    ArrayList<Group> groups;
    ArrayList<Speciality> specialities;
    ArrayList<Discipline> disciplines;
    ArrayList<Audience> audiences;
    ArrayList<Teacher> teachers;

    public void displayInfo() {
        System.out.println("Groups:");
        groups.forEach(x -> x.displayInfo());
        System.out.println();

        System.out.println("Specialities:");
        specialities.forEach(x -> x.displayInfo());
        System.out.println();

        System.out.println("Disciplines:");
        disciplines.forEach(x -> x.displayInfo());
        System.out.println();

        System.out.println("Audiences:");
        audiences.forEach(x -> x.displayInfo());
        System.out.println();

        System.out.println("Teachers:");
        teachers.forEach(x -> x.displayInfo());
        System.out.println();
    }
}
