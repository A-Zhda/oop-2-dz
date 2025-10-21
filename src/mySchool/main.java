package mySchool;

public class main {
    public enum Subjects{
        MATH("Математика"),
        HISTORY("История"),
        GEOGRAPHY("География"),
        ;

        private String name;

        public String getName() {
            return name;
        }
        Subjects(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        School NewSchool = new School("Школа1");

        Mark NewMark1 = new Mark(4,Subjects.MATH.name);
        Mark NewMark = new Mark(3,Subjects.MATH.name);

        Student Sidorov = new Student("Сидоров");
        Student Ivanov = new Student("Иванов");
        Student Urova = new Student("Юрова");
        Student Ivanova = new Student("Иванова");
        Student Musaev = new Student("Мусаев");

        Sidorov.addMark(3,Subjects.MATH.name);
        Sidorov.addMark(2,Subjects.HISTORY.name);
        Sidorov.addMark(5,Subjects.GEOGRAPHY.name);

        Ivanov.addMark(5,Subjects.HISTORY.name);
        Ivanov.addMark(NewMark);
        Ivanov.addMark(5,Subjects.GEOGRAPHY.name);

        Urova.addMark(4,Subjects.MATH.name);
        Urova.addMark(3,Subjects.HISTORY.name);
        Urova.addMark(5,Subjects.GEOGRAPHY.name);

        Ivanova.addMark(5,Subjects.MATH.name);
        Ivanova.addMark(5,Subjects.HISTORY.name);
        Ivanova.addMark(5,Subjects.GEOGRAPHY.name);

        Musaev.addMark(2,Subjects.MATH.name);
        Musaev.addMark(3,Subjects.HISTORY.name);
        Musaev.addMark(4,Subjects.GEOGRAPHY.name);

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

        System.out.println("Лучший студент класса: "+NewClass.bestStudent().getStudent());
        System.out.println("Лучший студент класса: "+NewClass2.bestStudent().getStudent());

        NewSchool.addSchoolClass(NewClass);
        NewSchool.addSchoolClass(NewClass2);

        System.out.println("Лучший студент школы: " +NewSchool.bestStudent().toString());
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
