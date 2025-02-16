package com.kt.di.view;

import java.util.Scanner;

import com.kt.di.model.Exam;
import com.kt.di.model.ExamModel;

public interface ExamViewInterface {
	Scanner scan = new Scanner(System.in);

	public void printMenu();

	public void printList(ExamModel model);

	public void printList(ExamModel model, int size);

	public Exam inputList();

}
