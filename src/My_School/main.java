package My_School;

public class main {
    public static void main(String[] args) {

        School NewSchool = new School("Школа1");

        Mark NewMark = new Mark(3,"Математика");

        Student Sidorov = new Student("Сидоров");
        Student Ivanov = new Student("Иванов");
        Student Urova = new Student("Юрова");
        Student Ivanova = new Student("Иванова");
        Student Musaev = new Student("Мусаев");

        Sidorov.addMark(3,"Математика");
        Sidorov.addMark(2,"История");
        Sidorov.addMark(5,"Геометрия");

        Ivanov.addMark(5,"История");
        Ivanov.addMark(NewMark);
        Ivanov.addMark(5,"Геометрия");

        Urova.addMark(4,"Математика");
        Urova.addMark(3,"История");
        Urova.addMark(5,"Геометрия");

        Ivanova.addMark(5,"Математика");
        Ivanova.addMark(5,"История");
        Ivanova.addMark(5,"Геометрия");

        Musaev.addMark(2,"Математика");
        Musaev.addMark(3,"История");
        Musaev.addMark(4,"Геометрия");

        System.out.println(Ivanov.toString());

        SchoolClass NewClass = new SchoolClass("1A");
        SchoolClass NewClass2 = new SchoolClass("2Б");
        NewClass.addStudent(Sidorov);
        NewClass.addStudent(Ivanov);
        NewClass.addStudent(Urova);

        NewClass2.addStudent(Ivanova);
        NewClass2.addStudent(Musaev);

        System.out.println(NewClass.averageStudentsMark());
        System.out.println(NewClass2.averageStudentsMark());

        System.out.println(NewClass.bestStudent().getStudent());
        System.out.println(NewClass2.bestStudent().getStudent());

        NewSchool.addSchoolClass(NewClass);
        NewSchool.addSchoolClass(NewClass2);

        System.out.println(NewSchool.bestStudent().toString());
        System.out.println(NewSchool.averageSchoolMark());

        System.out.println(NewSchool.getClass(1) == null ?
                "Не найден класс" :
                NewSchool.getClass(1).getName());

        System.out.println(NewSchool.toString());

        String StudentSurname = "Юрова";
        if (NewClass.findByName(StudentSurname) == null){
            System.out.println("Не найдено");
        } else {
            System.out.println(NewClass.findByName(StudentSurname).getStudent());
        }


    }
}
