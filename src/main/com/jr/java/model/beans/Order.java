package model.beans;

import core.IDocument;

import java.io.Serializable;

/**
 * Created by TH-221 on 08.11.2016.
 */
public class Order implements Serializable, IDocument {
    private String orderSubject, orderAuthor, orderExecutor;
    private String periodOfExecution, signOfTheControl, signOfExecution, orderText;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderSubject() {
        return orderSubject;
    }

    public void setOrderSubject(String subject_of_the_order) {
        this.orderSubject = subject_of_the_order;
    }

    public String getOrderAuthor() {
        return orderAuthor;
    }

    public void setOrderAuthor(String author_of_the_order) {
        this.orderAuthor = author_of_the_order;
    }

    public String getOrderExecutor() {
        return orderExecutor;
    }

    public void setOrderExecutor(String executors_of_the_order) {
        this.orderExecutor = executors_of_the_order;
    }

    public String getPeriodOfExecution() {
        return periodOfExecution;
    }

    public void setPeriodOfExecution(String period_of_execution) {
        this.periodOfExecution = period_of_execution;
    }

    public String getSignOfTheControl() {
        return signOfTheControl;
    }

    public void setSignOfTheControl(String sign_of_the_control) {
        this.signOfTheControl = sign_of_the_control;
    }

    public String getSignOfExecution() {
        return signOfExecution;
    }

    public void setSignOfExecution(String sign_the_execution) {
        this.signOfExecution = sign_the_execution;
    }

    public String getOrderText() {
        return orderText;
    }

    public void setOrderText(String text_of_the_order) {
        this.orderText = text_of_the_order;
    }
}
