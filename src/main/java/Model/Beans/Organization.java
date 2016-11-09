package Model.Beans;

import java.io.Serializable;

/**
 * Created by TH-221 on 08.11.2016.
 */
public class Organization implements Serializable {
    private String name, address, registered_office, director;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistered_office() {
        return registered_office;
    }

    public void setRegistered_office(String registered_office) {
        this.registered_office = registered_office;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
