package com.kt.di.model;

public class ExamModel {
    private Exam[] exams;
    private int current;

    public ExamModel() {
        this(new Exam[3], 0);
    }

    public ExamModel(Exam[] exams, int current) {
        this.exams = exams;
        this.current = current;
    }

    public void init(Exam[] exams, int current) {
        this.exams = exams;
        this.current = current;
    }

    public void add(Exam exam) {
        this.exams[this.current] = exam;

        // 배열 자동 증가 로직
        this.current++;
        if (this.exams.length >= this.current) {
            Exam[] temp = new Exam[this.current + 3];
            for (int i = 0; i < this.current; i++) {
                temp[i] = this.exams[i];
            }
            this.exams = temp;
        }
    }

    public Exam getExam(int i) {
        return this.exams[i];
    }

    public int getCurrent() {
        return this.current;
    }
}
