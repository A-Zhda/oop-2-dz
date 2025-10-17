package My_School;

public class SchoolClass {
    private Student Students[];
    private String name;
    private int size;

    public SchoolClass(String name) {
        this.name = name;
        this.size = 0;
        this.Students = new Student[0];
    }

    public Student[] getStudents() {
        return Students;
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
    public void addStudent(Student S){
        Student[] NewArrayStudents = new Student[Students.length + 1];
        size = 0;
        for (int i = 0; i < Students.length; i++) {
            NewArrayStudents[i] = Students[i];
            size++;
        }
        NewArrayStudents[NewArrayStudents.length - 1] = S;
        size++;
        Students = NewArrayStudents;
    }

    //находим среднюю оценку по всем студикам
    public double averageStudentsMark(){
        if (Students.length == 0){
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (int i = 0; i < Students.length; i++) {
            sum+=Students[i].averageStudentMark();
            count++;
        }
        return (count > 0 ? sum/count : 0.0);
    }

    //ищу по имени обхожу массив студиков
    public Student findByName(String fullName){
        if (Students.length == 0){
            return null;
        }
        for(Student S : Students){
            if (S.getStudent().equals(fullName)) {
                return S;
            }
        }

        return null;
    }

    //ищу лучшего студента по ни=аивысшему баллу среднйе оценки
    public Student bestStudent(){
        if (Students.length == 0){
            return null;
        }

        double bestAverage = 0;
        Student bestStudent = null;
        for (Student S : Students){
            if (bestAverage < S.averageStudentMark()){
                bestStudent = S;
                bestAverage = S.averageStudentMark();
            }
        }
        return bestStudent;
    }

    public String toString(){
        String FullString = "\n";
        for(Student m : Students){
            FullString += m.getStudent()+ "\n";
        }
        return "Студентов в классе "+size+ "\n Студенты: "+ FullString;
    }


}
