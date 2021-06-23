import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Information information = new Information();
        while (true) {
            System.out.println("Insert action to do");
            System.out.println("1. Remove");
            System.out.println("2. Create");
            System.out.println("3. ShowAll");
            System.out.println("4. Exit");

            var option = Integer.parseInt(System.console().readLine());
            switch (option) {
                case 1:
                    System.out.println("Set entity to work with");
                    System.out.println("1. Академическая группа");
                    System.out.println("2. Специальность");
                    System.out.println("3. Дисциплина");
                    System.out.println("4. Аудитория");
                    System.out.println("5. Преподаватель");
                    var entity = Integer.parseInt(System.console().readLine());

                    System.out.println("Set id");
                    var id = Integer.parseInt(System.console().readLine());

                    information.getArrayByOption(entity).removeIf(obj -> obj.id == id);
                    break;
                case 2:
                    var group1 = new Group(1, 145666, "14-aa-group");
                    var group2 = new Group(2, 145656, "14-bb-group");
                    var group3 = new Group(3, 135666, "15-aa-group");
                    information.setGroups(new ArrayList<>(List.of(group1, group2, group3)));

                    var speciality1 = new Speciality(1, 116677, "ПОИТ");
                    var speciality2 = new Speciality(2, 115577, "ИПОИТ");
                    var speciality3 = new Speciality(3, 115578, "ФМО");
                    information.setSpecialities(new ArrayList<>(List.of(speciality1, speciality2, speciality3)));

                    var discipline1 = new Discipline(1, "Математическая статистика", 133);
                    var discipline2 = new Discipline(2, "Инженерная графика", 50);
                    var discipline3 = new Discipline(3, "История Беларуси", 150);
                    information.setDisciplines(new ArrayList<>(List.of(discipline1, discipline2, discipline3)));

                    var audience1 = new Audience(1, 125);
                    var audience2 = new Audience(2, 110);
                    var audience3 = new Audience(3, 130);
                    information.setAudiences(new ArrayList<>(List.of(audience1, audience2, audience3)));

                    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                    var teacher1 = new Teacher(1, "Иван", "Иванов", "Иванович", "+375-29-319-44-99",
                            ft.parse("2000-01-01"), new ArrayList<>(List.of(discipline1, discipline2)));
                    var teacher2 = new Teacher(1, "Агния", "Старовойтова", "Кирилловна", "+375-29-333-00-96",
                            ft.parse("1990-01-01"), new ArrayList<>(List.of(discipline3)));
                    information.setTeachers(new ArrayList<>(List.of(teacher1, teacher2)));
                    break;

                case 3:
                    information.displayInfo();
                    break;
                case 4:
                    return;
            }

        }
    }
}

interface IPrintable {
    void displayInfo();
}

abstract class BaseId {
    public BaseId(int id) {
        this.id = id;
    }

    int id;
}

abstract class BaseNumber extends BaseId {
    public BaseNumber(int id, int number) {
        super(id);
        this.number = number;
    }

    int number; // номер
}

abstract class BaseTitleWithId extends BaseId {
    String title; // название

    public BaseTitleWithId(int id, String title) {
        super(id);
        this.title = title;
    }
}

abstract class BaseCodeWithNumber extends BaseNumber {
    String code; // код

    public BaseCodeWithNumber(int id, int number, String code) {
        super(id, number);
        this.code = code;
    }
}

class Group extends BaseCodeWithNumber implements IPrintable {
    public Group(int id, int number, String code) {
        super(id, number, code);
    }

    public void displayInfo() {
        System.out.printf("Group code: %s \tNumber: %d\n", code, number);
    }
}

class Speciality extends BaseCodeWithNumber implements IPrintable {
    public Speciality(int id, int number, String code) {
        super(id, number, code);
    }

    public void displayInfo() {
        System.out.printf("Speciality code: %s \tNumber: %d\n", code, number);
    }
}

class Discipline extends BaseTitleWithId implements IPrintable {
    public Discipline(int id, String title, int hours) {
        super(id, title);
        this.hours = hours;
    }

    int hours; // кол-во часов

    public void displayInfo() {
        System.out.printf("Discipline title: %s \tHours: %d\n", title, hours);
    }
}

class Audience extends BaseNumber implements IPrintable {
    public Audience(int id, int number) {
        super(id, number);
    }

    public void displayInfo() {
        System.out.printf("Audience number: %d\n", number);
    }
}

class Teacher extends BaseId implements IPrintable {
    public Teacher(int id, String name, String surname, String fatherName, String telephone, Date dateOfBirth,
            ArrayList<Discipline> disciplines) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.telephone = telephone;
        this.dateOfBirth = dateOfBirth;
        this.disciplines = disciplines;
    }

    String name; // имя
    String surname; // фамилия
    String fatherName; // отчество
    String telephone; // телефон
    Date dateOfBirth; // дата рождения
    ArrayList<Discipline> disciplines;

    public void displayInfo() {
        System.out.printf("Teacher Name: %s \tSurname: %s \tFatherName: %s \tTelephone %s \tDateOfBirth: %tc\n", name,
                surname, fatherName, telephone, dateOfBirth);

        System.out.println("Disciplines for teacher:");
        disciplines.forEach(x -> x.displayInfo());
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

    public ArrayList<? extends BaseId> getArrayByOption(int option) throws Exception {
        switch (option) {
            case 1:
                return groups;
            case 2:
                return specialities;
            case 3:
                return disciplines;
            case 4:
                return audiences;
            case 5:
                return teachers;
            default:
                throw new Exception("Option is incorrect");
        }
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<Speciality> specialities) {
        this.specialities = specialities;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public ArrayList<Audience> getAudiences() {
        return audiences;
    }

    public void setAudiences(ArrayList<Audience> audiences) {
        this.audiences = audiences;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void displayInfo() {
        print("Groups", groups);
        print("Specialities", specialities);
        print("Disciplines", disciplines);
        print("Audiences", audiences);
        print("Teachers", teachers);
    }

    private static void print(String text, ArrayList<? extends IPrintable> list) {
        System.out.println(text);
        list.forEach(x -> x.displayInfo());
        System.out.println("------------------");
        System.out.println();
    }
}
