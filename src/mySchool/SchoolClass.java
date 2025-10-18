package mySchool;

public class SchoolClass {
    private Student[] students;
    private String name;
    private int size;

    public SchoolClass(String name) {
        this.name = name;
        this.size = 0;
        this.students = new Student[10];
    }

    public Student[] getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }


    //дбавляю студента в массив, создаю новый массив добавляю + 1 элемент, в конц передаю студента
    public void addStudent(Student Student){
        MyArray myArray = new MyArray();
        Object[] newObject = myArray.addElement(students,Student);
        fillArray(newObject);
    }

    //находим среднюю оценку по всем студикам
    public double averageStudentsMark(){
        if (students.length == 0){
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null) break;
            sum+=students[i].averageStudentMark();
            count++;
        }
        return (count > 0 ? sum/count : 0.0);
    }

    //ищу по имени обхожу массив студиков
    public Student findByName(String fullName){
        if (students.length == 0){
            return null;
        }
        for(Student student : students){
            if (student.getStudent().equals(fullName)) {
                return student;
            }
        }

        return null;
    }

    //ищу лучшего студента по ни=аивысшему баллу среднйе оценки
    public Student bestStudent(){
        if (students.length == 0){
            return null;
        }

        double bestAverage = 0;
        Student bestStudent = null;
        for (Student student : students){
            if (student == null) break;
            if (bestAverage < student.averageStudentMark()){
                bestStudent = student;
                bestAverage = student.averageStudentMark();
            }
        }
        return bestStudent;
    }

    private void fillArray(Object[] recieveObject){
        for (int i = 0; i < recieveObject.length; i++) {
            if (recieveObject[i] == null) break;
            students[i] = (Student) recieveObject[i];
        }
    }

    public String toString(){
        StringBuilder FullString = new StringBuilder();
        for(Student student : students){
            if (student == null) break;
            FullString.append(student.getStudent()).append("\n");
        }
        return "Студентов в классе "+size+ "\n Студенты: \n"+ FullString;
    }


}
