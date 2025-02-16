package com.kt.di.controller;

import java.util.Scanner;

// import com.kt.di.view.ExamJsonView;
import com.kt.di.view.ExamConsoleView;
import com.kt.di.view.ExamViewInterface;
import com.kt.di.model.Exam;
import com.kt.di.model.ExamModel;

public class ExamController {
  // 사용자입력IO
  private Scanner scan = new Scanner(System.in);
  // 점수배열
  private ExamViewInterface view;
  private ExamModel model;

  public ExamController() {
    view = new ExamConsoleView();
    model = new ExamModel();
  }

  public ExamController(ExamViewInterface view, ExamModel model) {
    this.view = view;
    this.model = model;
  }

  public void setView(ExamViewInterface view) {
    this.view = view;
  }

  public void setModel(ExamModel model) {
    this.model = model;
  }

  public void service() {

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