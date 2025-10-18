package mySchool;

public class Student {
    private Mark[] marks = new Mark[10];
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

    public void addMark(Mark newMark){
        MyArray myArray = new MyArray();
        Object[] newObject = myArray.addElement(marks,newMark);
        fillArray(newObject);

    }

    private void fillArray(Object[] recieveObject){
        for (int i = 0; i < recieveObject.length; i++) {
            if (recieveObject[i] == null) break;
            marks[i] = (Mark) recieveObject[i];
        }
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
            if (marks[i] == null) break;
            sum+=marks[i].getMark();
            count++;
        }

        return (count > 0 ? sum/count : 0.0);
    }

    public String toString(){
        StringBuilder FullString = new StringBuilder();
        for(Mark mark : marks){
            if (mark == null) break;
            FullString.append(mark.getSubject())
                      .append(":")
                      .append(mark.getMark())
                      .append("\n");
        }
        return "Студент "+student + " оценки: \n"+ FullString;
    }
}
