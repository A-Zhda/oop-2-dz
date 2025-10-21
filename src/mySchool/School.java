package mySchool;

public class School {
    private MyArrayInterface schoolClasses;
    private String schoolName;
    private int classCount;

    public School( String schoolName) {
        this.schoolClasses = new MyArray();
        this.schoolName = schoolName;
        this.classCount = 0;
    }

    public MyArrayInterface getSchoolClasses() {
        return schoolClasses;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    public void addSchoolClass(SchoolClass newSchoolClass){
     schoolClasses.add(newSchoolClass);
    }

    //вернуть класс по индексу
    public SchoolClass getClass(int index){
        if (schoolClasses.size() == 0) return null;

        for (int i = 0; i < schoolClasses.size(); i++) {
            if(i == index){
                SchoolClass schoolClass = (SchoolClass) schoolClasses.get(i);
                if (schoolClass != null){
                    return schoolClass;
                }
            }
        }
        return null;
    }

    public SchoolClass findByName(String name){
        if (schoolClasses.size() == 0){
            return null;
        }
        for(Object obj: schoolClasses.getMyArray()){
            if (obj instanceof SchoolClass schoolClass){
                if (schoolClass.getName().equals(name)) {
                    return schoolClass;
                }
            }
        }

        return null;
    }

    public double averageSchoolMark(){
        if (schoolClasses.size() == 0){
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (int i = 0; i < schoolClasses.size(); i++) {
            SchoolClass schoolClass = (SchoolClass) schoolClasses.get(i);
            if (schoolClass != null){
                sum+=schoolClass.averageStudentsMark();
                count++;
            }

        }
        return (count > 0 ? sum/count : 0.0);
    }

    public Student bestStudent(){
        if (schoolClasses.size() == 0){
            return null;
        }

        double bestAverage = 0;
        Student bestStudent = null;
        for (Object obj : schoolClasses.getMyArray()){
            SchoolClass schoolClass = (SchoolClass) obj;
            if (schoolClass == null) break;
            for (Object objStudent : schoolClass.getStudents().getMyArray()) {
                Student student = (Student) objStudent;
                if (student == null) break;
                if (bestAverage < student.averageStudentMark()) {
                    bestStudent = student;
                    bestAverage = student.averageStudentMark();
                }
            }

        }
        return bestStudent;
    }


    public String toString(){
        StringBuilder FullString = new StringBuilder();
        for(Object obj : schoolClasses.getMyArray()){
            SchoolClass schoolClass = (SchoolClass) obj;
            if (schoolClass == null) break;
            FullString.append(schoolClass.getName()).append("\n");
        }
        return "Классов в школе:  "+schoolClasses.size()+ "\nКлассы: \n"+ FullString;
    }


}
