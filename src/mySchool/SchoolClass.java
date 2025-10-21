package mySchool;

public class SchoolClass {
    private MyArrayInterface students;
    private String name;
    private int size;

    public SchoolClass(String name) {
        this.name = name;
        this.size = 0;
        this.students = new MyArray();
    }

    public MyArrayInterface getStudents() {
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


    //дбавляю студента в массив, мой массив это новый класс наследуемый из интерфейса
    public void addStudent(Student Student){
        students.add(Student);
    }

    //находим среднюю оценку по всем студикам
    public double averageStudentsMark(){
        if (students.size() == 0){
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            Object obj = students.get(i);
            if(obj instanceof Student student){
                sum+=student.averageStudentMark();
                count++;
            }
        }
        return (count > 0 ? sum/count : 0.0);
    }

    //ищу по имени обхожу массив студиков
    public Student findByName(String fullName){
        if (students.size() == 0){
            return null;
        }
        for(Object obj : students.getMyArray()){
            Student student = (Student) obj;
            if (student.getStudent().equals(fullName)) {
                return student;
            }
        }

        return null;
    }

    //ищу лучшего студента по ни=аивысшему баллу среднйе оценки
    public Student bestStudent(){
        if (students.size() == 0){
            return null;
        }

        double bestAverage = 0;
        Student bestStudent = null;
        for (Object obj : students.getMyArray()){
            Student student = (Student) obj;
            if (student == null) break;
            if (bestAverage < student.averageStudentMark()){
                bestStudent = student;
                bestAverage = student.averageStudentMark();
            }
        }
        return bestStudent;
    }


    public String toString(){
        StringBuilder FullString = new StringBuilder();
        for(Object obj : students.getMyArray()){
            Student student = (Student) obj;
            if (student == null) break;
            FullString.append(student.getStudent()).append("\n");
        }
        return "Студентов в классе "+size+ "\n Студенты: \n"+ FullString;
    }


}
