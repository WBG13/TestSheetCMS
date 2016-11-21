package controller.managers;

import controller.errors.DocumentNotFoundException;
import db.DocumentsDatabase;
import model.beans.Employee;

import java.util.List;

public class EmployeeManager {
    private DocumentsDatabase documentsDatabase = new DocumentsDatabase();

    public void CreateEmployee(Employee employee) {
        documentsDatabase.CreateEmployee(employee);
    }

    public List<Employee> GetEmployees(String organizationId, int limit, int offset) {
        return documentsDatabase.GetAllEmployees(organizationId, limit, offset);
    }

    public void UpdateEmployee(Employee Employee) throws DocumentNotFoundException {
        if (documentsDatabase.GetEmployeeById("1") == null) {
            throw new DocumentNotFoundException();
        }

        documentsDatabase.UpdateEmployee(Employee);

    }

    public void DeleteEmployee(String id) throws DocumentNotFoundException {
        if (documentsDatabase.GetEmployeeById(id) == null) {
            throw new DocumentNotFoundException();
        }
        documentsDatabase.DeleteEmployee(id);
    }

}
