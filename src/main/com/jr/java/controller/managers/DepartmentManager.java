package controller.managers;

import controller.errors.DocumentNotFoundException;
import db.DocumentsDatabase;
import model.beans.Department;

import java.util.List;

public class DepartmentManager {
    private DocumentsDatabase documentsDatabase = new DocumentsDatabase();

    public void CreateDepartment(Department department) {
        documentsDatabase.CreateDepartment(department);
    }

    public List<Department> GetDepartments(String organizationId, int limit, int offset) {
        return documentsDatabase.GetAllDepartments(organizationId, limit, offset);
    }

    public void UpdateDepartment(Department department) throws DocumentNotFoundException {
        if (documentsDatabase.GetDepartmentById(Integer.toString(department.getId())) == null) {
            throw new DocumentNotFoundException();
        }

        documentsDatabase.UpdateDepartment(department);
    }

    public void DeleteDepartment(String id) throws DocumentNotFoundException {
        if (documentsDatabase.GetDepartmentById(id) == null) {
            throw new DocumentNotFoundException();
        }
        documentsDatabase.DeleteDepartment(id);
    }
}
