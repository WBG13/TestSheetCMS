package db;

import core.DocumentType;
import model.beans.Department;
import model.beans.Employee;
import model.beans.Order;
import model.beans.Organization;

import java.util.List;

public class DocumentsDatabase {

    private DAOManager<Employee> employeeDAOManager = new DAOManager<Employee>() {
        @Override
        public DocumentType GetQueryPrefix() {
            return DocumentType.Employee;
        }
    };

    private DAOManager<Organization> organizationDAOManager = new DAOManager<Organization>() {
        @Override
        public DocumentType GetQueryPrefix() {
            return DocumentType.Organization;
        }
    };

    private DAOManager<Department> departmentDAOManager = new DAOManager<Department>() {
        @Override
        public DocumentType GetQueryPrefix() {
            return DocumentType.Departament;
        }
    };

    private DAOManager<Order> orderDAOManager = new DAOManager<Order>() {
        @Override
        public DocumentType GetQueryPrefix() {
            return DocumentType.Order;
        }
    };

    /* Deparment */
    public void CreateDepartment(Department department) {
        departmentDAOManager.Create(department);
    }

    public List<Department> GetAllDepartments(String organizationId, int limit, int offset) {
        return departmentDAOManager.ReadAll(String.format("organizationId = {0}", organizationId), limit, offset);
    }

    public Department GetDepartmentById(String id) {
        return departmentDAOManager.Read(id);
    }

    public void UpdateDepartment(Department department) {
        departmentDAOManager.Update(department);
    }

    public void DeleteDepartment(String id) {
        departmentDAOManager.Delete(id);
    }

    /* Employee */
    public void CreateEmployee(Employee Employee) {
        employeeDAOManager.Create(Employee);
    }

    public List<Employee> GetAllEmployees(String organizationId, int limit, int offset) {
        return employeeDAOManager.ReadAll(String.format("organizationId = {0}", organizationId), limit, offset);
    }

    public Employee GetEmployeeById(String id) {
        return employeeDAOManager.Read(id);
    }

    public void UpdateEmployee(Employee Employee) {
        employeeDAOManager.Update(Employee);
    }

    public void DeleteEmployee(String id) {
        employeeDAOManager.Delete(id);
    }

    /* Organization */
    public void CreateOrganization(Organization Organization) {
        organizationDAOManager.Create(Organization);
    }

    public List<Organization> GetAllOrganizations(int limit, int offset) {
        return organizationDAOManager.ReadAll("", limit, offset);
    }

    public Organization GetOrganizationById(String id) {
        return organizationDAOManager.Read(id);
    }

    public void UpdateOrganization(Organization Organization) {
        organizationDAOManager.Update(Organization);
    }

    public void DeleteOrganization(String id) {
        organizationDAOManager.Delete(id);
    }

    /* Order */
    public void CreateOrder(Order order) {
        orderDAOManager.Create(order);
    }

    public List<Order> GetOrdersRelatedToEmployee(String employeeId, int limit, int offset) {
        return orderDAOManager.ReadAll(String.format("orderExecutorId = {0} OR orderAuthorId = {0}", employeeId), limit, offset);
    }

    public List<Order> GetOrdersForEmployyee(String employeeId, int limit, int offset) {
        return orderDAOManager.ReadAll(String.format("orderExecutorId = {0}", employeeId), limit, offset);
    }

    public List<Order> GetOrdersByEmployee(String employeeId, int limit, int offset) {
        return orderDAOManager.ReadAll(String.format("orderAuthorId = {0}", employeeId), limit, offset);
    }

    public Order GetOrderById(String orderId) {
        return orderDAOManager.Read(orderId);
    }

    public void UpdateOrder(Order order) {
        orderDAOManager.Update(order);
    }

    public void DeleteOrder(String id) {
        orderDAOManager.Delete(id);
    }
}


