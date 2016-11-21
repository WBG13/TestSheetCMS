package model.beans;

import core.IDocument;

import java.io.Serializable;

public class Organization implements Serializable, IDocument {
    private String name, address, registeredOffice, director;
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

    public String getRegisteredOffice() {
        return registeredOffice;
    }

    public void setRegisteredOffice(String registered_office) {
        this.registeredOffice = registered_office;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
