package My_School;

public class School {
    private SchoolClass SchoolClasses[];
    private String schoolName;
    private int classCount;

    public School( String schoolName) {
        SchoolClasses = new SchoolClass[0];
        this.schoolName = schoolName;
        this.classCount = 0;
    }

    public SchoolClass[] getSchoolClasses() {
        return SchoolClasses;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getClassCount() {
        return classCount;
    }

    public void addSchoolClass(SchoolClass S){
        SchoolClass[] NewArraySchoolClass = new SchoolClass[SchoolClasses.length + 1];
        classCount = 0;
        for (int i = 0; i < SchoolClasses.length; i++) {
            NewArraySchoolClass[i] = SchoolClasses[i];
            classCount++;
        }
        NewArraySchoolClass[NewArraySchoolClass.length - 1] = S;
        classCount++;
        SchoolClasses = NewArraySchoolClass;
    }

    //вернуть класс по индексу
    public SchoolClass getClass(int index){
        if (SchoolClasses.length == 0) return null;

        for (int i = 0; i < SchoolClasses.length; i++) {
            if(i == index) return SchoolClasses[i];
        }
        return null;
    }

    public SchoolClass findByName(String name){
        if (SchoolClasses.length == 0){
            return null;
        }
        for(SchoolClass S : SchoolClasses){
            if (S.getName().equals(name)) {
                return S;
            }
        }

        return null;
    }

    public double averageSchoolMark(){
        if (SchoolClasses.length == 0){
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (int i = 0; i < SchoolClasses.length; i++) {
            sum+=SchoolClasses[i].averageStudentsMark();
            count++;
        }
        return (count > 0 ? sum/count : 0.0);
    }

    public Student bestStudent(){
        if (SchoolClasses.length == 0){
            return null;
        }

        double bestAverage = 0;
        Student bestStudent = null;
        for (SchoolClass SC : SchoolClasses){
            for (Student S : SC.getStudents()){
                if (bestAverage < S.averageStudentMark()){
                    bestStudent = S;
                    bestAverage = S.averageStudentMark();
                }
            }
        }
        return bestStudent;
    }

    public String toString(){
        String FullString = "\n";
        for(SchoolClass m : SchoolClasses){
            FullString += m.getName()+ "\n";
        }
        return "Классов в школе:  "+classCount+ "\n Классы: "+ FullString;
    }


}
