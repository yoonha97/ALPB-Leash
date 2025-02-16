package com.kt.mvc.controller;

import java.util.Scanner;

// import com.kt.mvc.view.ExamJsonView;
import com.kt.mvc.view.ExamJsonView;
import com.kt.mvc.model.Exam;
import com.kt.mvc.model.ExamModel;

public class ExamController {
  // 사용자입력IO
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    // 점수배열
    // ExamConsoleView view = new ExamConsoleView();
    ExamJsonView view = new ExamJsonView();
    ExamModel model = new ExamModel();

    int menu;
    boolean keepLoop = true;

    while (keepLoop) {
      // 메뉴 출력
      view.printMenu();
      menu = scan.nextInt();
      switch (menu) {
        case 1:
          // 점수 입력
          Exam exam = view.inputList();
          model.add(exam);
          // model.add(view.inputList());
          break;
        case 2:
          // 점수 출력
          view.printList(model);
          break;
        case 3:
          // 프로그램종료
          System.out.println("Bye~~");
          scan.close();
          keepLoop = false;
          break;
        default:
          System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
      }
    }
  }
}