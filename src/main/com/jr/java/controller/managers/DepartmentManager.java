package controller.managers;

import db.DocumentsDatabase;
import model.beans.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentManager {
    private DocumentsDatabase documentsDatabase = new DocumentsDatabase();

    public void CreateDeparment( String organizationId, String name, String details, String director ) {
        Department department = new Department();
        department.setDepartment_name( name );
        department.setContact_details( details );
        department.setDirector( director );

        documentsDatabase.CreateDepartment( department );
    }

    public List< Department > GetDepartments( String orgranizationId ) {
        // for testting
        final Department department = new Department();
        department.setDepartment_name( "ddd" );
        department.setContact_details( "xxx" );
        department.setDirector( "XxX" );

        return new ArrayList<Department>() { { add( department ); }};
    }
}
