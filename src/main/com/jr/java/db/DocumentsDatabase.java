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
            return DocumentType.Department;
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
        return departmentDAOManager.ReadAll(String.format("organizationId = %1$s", organizationId), limit, offset);
    }

    public Department GetDepartmentById(String id) {
        return departmentDAOManager.Read(id, "department");
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
        return employeeDAOManager.ReadAll(String.format("organizationId = %1$s", organizationId), limit, offset);
    }

    public Employee GetEmployeeById(String id) {
        return employeeDAOManager.Read(id, "employee");
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
        return organizationDAOManager.Read(id, "organization");
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
        return orderDAOManager.ReadAll(String.format("orderExecutorId = %1$s OR orderAuthorId = %1$s", employeeId), limit, offset);
    }

    public List<Order> GetOrdersForEmployyee(String employeeId, int limit, int offset) {
        return orderDAOManager.ReadAll(String.format("orderExecutorId = %1$s", employeeId), limit, offset);
    }

    public List<Order> GetOrdersByEmployee(String employeeId, int limit, int offset) {
        return orderDAOManager.ReadAll(String.format("orderAuthorId = %1$s", employeeId), limit, offset);
    }

    public Order GetOrderById(String orderId) {
        return orderDAOManager.Read(orderId, "order");
    }

    public void UpdateOrder(Order order) {
        orderDAOManager.Update(order);
    }

    public void DeleteOrder(String id) {
        orderDAOManager.Delete(id);
    }
}


