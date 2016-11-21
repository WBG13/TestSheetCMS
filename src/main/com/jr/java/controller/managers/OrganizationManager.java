package controller.managers;

import controller.errors.DocumentNotFoundException;
import db.DocumentsDatabase;
import model.beans.Organization;

import java.util.List;

public class OrganizationManager {
    private DocumentsDatabase documentsDatabase = new DocumentsDatabase();

    public void CreateOrganization(Organization Organization) {
        documentsDatabase.CreateOrganization(Organization);
    }

    public List<Organization> GetOrganizations(int limit, int offset) {
        return documentsDatabase.GetAllOrganizations(limit, offset);
    }

    public void UpdateOrganization(Organization Organization) throws DocumentNotFoundException {
        if (documentsDatabase.GetOrganizationById(Integer.toString(Organization.getId())) == null) {
            throw new DocumentNotFoundException();
        }

        documentsDatabase.UpdateOrganization(Organization);
    }

    public void DeleteOrganization(String id) throws DocumentNotFoundException {
        if (documentsDatabase.GetOrganizationById(id) == null) {
            throw new DocumentNotFoundException();
        }
        documentsDatabase.DeleteOrganization(id);
    }
}
