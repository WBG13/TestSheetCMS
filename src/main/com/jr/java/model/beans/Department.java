package model.beans;

import core.IDocument;

import java.io.Serializable;

/**
 * Created by TH-221 on 08.11.2016.
 */
public class Department implements Serializable, IDocument {
    private String departmentName, contactDetails, director;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return departmentName;
    }

    public void setDepartment_name(String department_name) {
        this.departmentName = department_name;
    }

    public String getContact_details() {
        return contactDetails;
    }

    public void setContact_details(String contact_details) {
        this.contactDetails = contact_details;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
