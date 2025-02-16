package com.kt.mvc.view;

import java.util.Scanner;

import com.kt.mvc.model.Exam;
import com.kt.mvc.model.ExamModel;

public interface ExamViewInterface {
	Scanner scan = new Scanner(System.in);

	public void printMenu();

	public void printList(ExamModel model);

	public void printList(ExamModel model, int size);

	public Exam inputList();

}
