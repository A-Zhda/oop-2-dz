package mySchool;

public class Student {
    private MyArrayInterface marks;
    private String student;

    public Student(String student) {
        this.marks = new MyArray();
        this.student = student;
    }

    public MyArrayInterface getMarks() {
        return marks;
    }

    public void setMarks(MyArray marks) {
        this.marks = marks;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void addMark(Mark newMark){
                marks.add(newMark);
    }

    public void addMark(int value, String subject){
                addMark(new Mark(value,subject));
    }

    public double averageStudentMark(){
        if (marks.size() == 0){
            return 0.0;
        }

        double sum = 0;
        int count = 0;
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i) == null) break;
            Object obj = marks.get(i);
            if (obj instanceof Mark mark){
                sum+=mark.getMark();
                count++;
            }

        }

        return (count > 0 ? sum/count : 0.0);
    }

    public String toString(){
        StringBuilder FullString = new StringBuilder();
        for(Object obj : marks.getMyArray()){
            Mark mark = (Mark) obj;
            if (mark == null) break;
            FullString.append(mark.getSubject())
                      .append(":")
                      .append(mark.getMark())
                      .append("\n");
        }
        return "\nСтудент "+student + " оценки: \n"+ FullString;
    }
}
