package com.kt.di;

import com.kt.di.controller.ExamController;
import com.kt.di.model.ExamModel;
import com.kt.di.view.ExamJsonView;
import com.kt.di.view.ExamViewInterface;

public class Main {
    public static void main(String[] args) {
        ExamController controller = new ExamController();
        ExamModel model = new ExamModel();
        ExamViewInterface view = new ExamJsonView();

        controller.setModel(model);
        controller.setView(view);

        controller.service();
    }
}