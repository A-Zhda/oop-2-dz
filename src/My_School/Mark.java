package My_School;

public class Mark {
   private int Mark;
   private String subject;

    public Mark(int mark, String subject) {
        if (mark > 5 || mark < 2){
            System.err.println("Оценка должна быть от 2 до 5");
            return;
        }
        Mark = mark;
        this.subject = subject;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int mark) {
        if (mark > 5 || mark < 2){
            System.err.println("Оценка должна быть от 2 до 5");
            return;
        }
        Mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
