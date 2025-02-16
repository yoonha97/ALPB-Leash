package com.kt.mvc.view;

import com.kt.mvc.model.Exam;
import com.kt.mvc.model.ExamModel;

public class ExamConsoleView implements ExamViewInterface {
	ExamModel list = new ExamModel();

	public void printMenu() {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│         메인 메뉴         │");
		System.out.println("└───────────────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
	}

	public void printList(ExamModel model) {
		this.printList(model, model.getCurrent());
	}

	public void printList(ExamModel model, int size) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│         성적 출력         │");
		System.out.println("└───────────────────────────┘");
		System.out.println();

		for (int i = 0; i < size; i++) {
			Exam exam = model.getExam(i);
			int total = 0;
			float avg;
			total = exam.getTotal();
			avg = exam.getAvg();
			System.out.printf("국어 : %3d\n", exam.getKor());
			System.out.printf("영어 : %3d\n", exam.getEng());
			System.out.printf("수학 : %3d\n", exam.getMath());
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("─────────────────────────────");
		}
	}

	public Exam inputList() {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│         성적 입력         │");
		System.out.println("└───────────────────────────┘");
		System.out.println();
		Exam exam = new Exam();
		do {
			System.out.print("국어 : ");
			exam.setKor(scan.nextInt());

			if (exam.getKor() < 0 || 100 < exam.getKor())
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (exam.getKor() < 0 || 100 < exam.getKor());
		do {
			System.out.print("영어 : ");
			exam.setEng(scan.nextInt());

			if (exam.getEng() < 0 || 100 < exam.getEng())
				System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (exam.getEng() < 0 || 100 < exam.getEng());
		do {
			System.out.print("수학 : ");
			exam.setMath(scan.nextInt());

			if (exam.getMath() < 0 || 100 < exam.getMath())
				System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (exam.getMath() < 0 || 100 < exam.getMath());
		System.out.println("─────────────────────────────");
		return exam;
	}
}
