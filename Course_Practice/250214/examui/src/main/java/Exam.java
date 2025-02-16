import java.sql.Date;

public class Exam {
    private Subject subject;

    public Exam() {
        this.subject = new Subject();
    }

    private int seq; // 시퀀스
    private String title; // 중간, 기말....
    private Date regDate; // 시험일

    public int getKor() {
        return subject.getKor();
    }

    public void setKor(int kor) {
        this.subject.setKor(kor);
    }

    public int getEng() {
        return subject.getEng();
    }

    public void setEng(int eng) {
        this.subject.setEng(eng);
    }

    public int getMath() {
        return subject.getMath();
    }

    public void setMath(int math) {
        this.subject.setMath(math);
    }

    public int getTotal() {
        return this.subject.getKor() + subject.getEng() + subject.getMath();
    }

    public float getAvg() {
        return this.getTotal() / 3.0f;
    }
}
