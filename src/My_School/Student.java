package My_School;

public class Student {
    private Mark[] marks = new Mark[0];
    private String student;

    public Student(String student) {
        this.marks = marks;
        this.student = student;
    }

    public Mark[] getMarks() {
        return marks;
    }

    public void setMarks(Mark[] marks) {
        this.marks = marks;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void addMark(Mark m){
        Mark[] NewMark = new Mark[marks.length + 1];

        for (int i = 0; i < marks.length; i++) {
            NewMark[i] = marks[i];
        }
            NewMark[NewMark.length - 1] = m;

            marks = NewMark;
    }

    public void addMark(int value, String subject){
                addMark(new Mark(value,subject));
    }

    public double averageStudentMark(){
        if (marks.length == 0){
            return 0.0;
        }

        double sum = 0;
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            sum+=marks[i].getMark();
            count++;
        }

        return (count > 0 ? sum/count : 0.0);
    }

    public String toString(){
        String FullString = "\n";
        for(Mark m : marks){
            FullString += m.getSubject()+ ":" + m.getMark() + "\n";
        }
        return "Студент "+student + " оценки: "+ FullString;
    }
}
