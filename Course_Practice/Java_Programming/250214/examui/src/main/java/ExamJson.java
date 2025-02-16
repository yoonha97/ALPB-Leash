import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExamJson {
    Scanner scan = new Scanner(System.in);
    ExamList list = new ExamList();

    // 점수 출력 메소드
    public void printList() {
        printList(list.getCurrent());
    }

    public void printList(int size) {
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        object.addProperty("title", "성적 출력");
        for (int i = 0; i < size; i++) {
            Exam exam = list.getExam(i);
            int kor = exam.getKor();
            int eng = exam.getEng();
            int math = exam.getMath();

            int total = exam.getTotal();
            float avg = exam.getAvg();

            object.addProperty("국어", kor);
            object.addProperty("영어", eng);
            object.addProperty("수학", math);
            object.addProperty("총점", total);
            object.addProperty("평균", avg);
        }
        String json = gson.toJson(object);
        System.out.println(json);
    }

    // 점수 입력 메소드
    public void inputList() {
        System.out.println("┌───────────────────────────┐");
        System.out.println("│         성적 입력         │");
        System.out.println("└───────────────────────────┘");
        System.out.println();

        Exam exam = new Exam();
        do {
            System.out.printf("국어%d : ", list.getCurrent() + 1);
            exam.setKor(scan.nextInt());

            if (exam.getKor() < 0 || 100 < exam.getKor())
                System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");

        } while (exam.getKor() < 0 || 100 < exam.getKor());
        do {
            System.out.printf("영어%d : ", list.getCurrent() + 1);
            exam.setEng(scan.nextInt());

            if (exam.getEng() < 0 || 100 < exam.getEng())
                System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");

        } while (exam.getEng() < 0 || 100 < exam.getEng());
        do {
            System.out.printf("수학%d : ", list.getCurrent() + 1);
            exam.setMath(scan.nextInt());

            if (exam.getMath() < 0 || 100 < exam.getMath())
                System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");

        } while (exam.getMath() < 0 || 100 < exam.getMath());
        /* -------------------------------------------------- */
        list.add(exam);
        System.out.println("─────────────────────────────");
    }

    // 메뉴 출력 메소드
    public int printMenu() {
        System.out.println("┌───────────────────────────┐");
        System.out.println("│         메인 메뉴         │");
        System.out.println("└───────────────────────────┘");
        System.out.println("\t1. 성적입력 ");
        System.out.println("\t2. 성적출력 ");
        System.out.println("\t3. 종료 ");
        System.out.print("\t선택> ");
        int menu = scan.nextInt();
        return menu;
    }

    public void bye() {
        System.out.println("Bye~~");
    }

    public void getMsg() {
        System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
    }
}