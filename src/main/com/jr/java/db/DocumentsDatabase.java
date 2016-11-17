package db;

import core.DocumentType;
import core.IDocument;
import db.DAOManager;
import model.beans.Department;
import model.beans.Employee;
import model.beans.Order;
import model.beans.Organization;

public class DocumentsDatabase {

    private DAOManager< Employee > employeeDAOManager = new DAOManager< Employee >() {
        @Override
        public DocumentType GetQueryPrefix() { return DocumentType.Employee; }
    };

    private DAOManager< Organization > organizationDAOManager = new DAOManager< Organization >() {
        @Override
        public DocumentType GetQueryPrefix() { return DocumentType.Organization; }
    };
    
    private DAOManager< Department > departmentDAOManager = new DAOManager< Department >() {
        @Override
        public DocumentType GetQueryPrefix() { return DocumentType.Departament; }
    };

    private DAOManager< Order > orderDAOManager = new DAOManager< Order >() {
        @Override
        public DocumentType GetQueryPrefix() { return DocumentType.Order; }
    };

    /* Deparment */
    public void CreateDepartment( Department department ) {
        departmentDAOManager.Create( department );
    }
    public void GetAllDepartments( int limit, int offset ) {
        departmentDAOManager.ReadAll("n/a", limit, offset);
    }
    public Department GetDepartmentById( String id ) { return departmentDAOManager.Read( "where Id = {}"); }
    public void UpdateDepartment( Department department ) { departmentDAOManager.Update( department ); }
    public void DeleteDepartment( Department department ) { departmentDAOManager.Delete( department );}

    /* Employee */

}


