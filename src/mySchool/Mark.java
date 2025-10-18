package mySchool;

public class Mark {
   private int mark;
   private String subject;

    public Mark(int mark, String subject) {
        if(checkMark(mark)) return;
        this.mark = mark;
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if(checkMark(mark)) return;
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean checkMark(int mark){
        if (mark > 5 || mark < 2){
            System.err.println("Оценка должна быть от 2 до 5");
            return true;
        }
        return false;
    }
}
