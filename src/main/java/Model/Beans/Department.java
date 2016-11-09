package Model.Beans;

import java.io.Serializable;

/**
 * Created by TH-221 on 08.11.2016.
 */
public class Department implements Serializable {
    private String department_name, contact_details, director;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getContact_details() {
        return contact_details;
    }

    public void setContact_details(String contact_details) {
        this.contact_details = contact_details;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
