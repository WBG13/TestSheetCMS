package Model.Beans;

import java.io.Serializable;

/**
 * Created by TH-221 on 08.11.2016.
 */
public class Order implements Serializable {
    private String subject_of_the_order, author_of_the_order, executors_of_the_order;
    private String period_of_execution, sign_of_the_control, sign_the_execution, text_of_the_order;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject_of_the_order() {
        return subject_of_the_order;
    }

    public void setSubject_of_the_order(String subject_of_the_order) {
        this.subject_of_the_order = subject_of_the_order;
    }

    public String getAuthor_of_the_order() {
        return author_of_the_order;
    }

    public void setAuthor_of_the_order(String author_of_the_order) {
        this.author_of_the_order = author_of_the_order;
    }

    public String getExecutors_of_the_order() {
        return executors_of_the_order;
    }

    public void setExecutors_of_the_order(String executors_of_the_order) {
        this.executors_of_the_order = executors_of_the_order;
    }

    public String getPeriod_of_execution() {
        return period_of_execution;
    }

    public void setPeriod_of_execution(String period_of_execution) {
        this.period_of_execution = period_of_execution;
    }

    public String getSign_of_the_control() {
        return sign_of_the_control;
    }

    public void setSign_of_the_control(String sign_of_the_control) {
        this.sign_of_the_control = sign_of_the_control;
    }

    public String getSign_the_execution() {
        return sign_the_execution;
    }

    public void setSign_the_execution(String sign_the_execution) {
        this.sign_the_execution = sign_the_execution;
    }

    public String getText_of_the_order() {
        return text_of_the_order;
    }

    public void setText_of_the_order(String text_of_the_order) {
        this.text_of_the_order = text_of_the_order;
    }
}
