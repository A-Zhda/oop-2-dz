package mySchool;

public class School {
    private SchoolClass[] schoolClasses;
    private String schoolName;
    private int classCount;

    public School( String schoolName) {
        schoolClasses = new SchoolClass[10];
        this.schoolName = schoolName;
        this.classCount = 0;
    }

    public SchoolClass[] getSchoolClasses() {
        return schoolClasses;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    public void addSchoolClass(SchoolClass newSchoolClass){
        MyArray myArray = new MyArray();
        Object[] newObject = myArray.addElement(schoolClasses,newSchoolClass);
        fillArray(newObject);
    }

    //вернуть класс по индексу
    public SchoolClass getClass(int index){
        if (schoolClasses.length == 0) return null;

        for (int i = 0; i < schoolClasses.length; i++) {
            if(i == index) return schoolClasses[i];
        }
        return null;
    }

    public SchoolClass findByName(String name){
        if (schoolClasses.length == 0){
            return null;
        }
        for(SchoolClass thisSchoolClass : schoolClasses){
            if (thisSchoolClass.getName().equals(name)) {
                return thisSchoolClass;
            }
        }

        return null;
    }

    public double averageSchoolMark(){
        if (schoolClasses.length == 0){
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (int i = 0; i < schoolClasses.length; i++) {
            if(schoolClasses[i] == null) break;
            sum+=schoolClasses[i].averageStudentsMark();
            count++;
        }
        return (count > 0 ? sum/count : 0.0);
    }

    public Student bestStudent(){
        if (schoolClasses.length == 0){
            return null;
        }

        double bestAverage = 0;
        Student bestStudent = null;
        for (SchoolClass thisSchoolClass : schoolClasses){
            if (thisSchoolClass == null) break;
            for (Student Student : thisSchoolClass.getStudents()){
                if (Student == null) break;
                if (bestAverage < Student.averageStudentMark()){
                    bestStudent = Student;
                    bestAverage = Student.averageStudentMark();
                }
            }
        }
        return bestStudent;
    }

    private void fillArray(Object[] recieveObject){
        for (int i = 0; i < recieveObject.length; i++) {
            if (recieveObject[i] == null) break;
            schoolClasses[i] = (SchoolClass) recieveObject[i];
        }
    }

    public String toString(){
        StringBuilder FullString = new StringBuilder();
        for(SchoolClass schoolClass : schoolClasses){
            if (schoolClass == null) break;
            FullString.append(schoolClass.getName()).append("\n");
        }
        return "Классов в школе:  "+schoolClasses.length+ "\nКлассы: \n"+ FullString;
    }


}
