package controller.managers;

import controller.errors.DocumentNotFoundException;
import controller.errors.DocumentStatusTransitionError;
import controller.errors.DocumentValidationError;
import core.OrderStatus;
import db.DocumentsDatabase;
import model.beans.Order;

import java.util.List;

public class OrderManager {
    private DocumentsDatabase documentsDatabase = new DocumentsDatabase();

    public void CreateOrder(Order order) throws DocumentValidationError {
        order.setOrderStatus(OrderStatus.Submitted);
        if (documentsDatabase.GetEmployeeById(order.getOrderAuthorId()) == null)
            throw new DocumentValidationError("invalid author id!");

        if (documentsDatabase.GetEmployeeById(order.getOrderExecutorId()) == null)
            throw new DocumentValidationError("invalid executor id!");

        documentsDatabase.CreateOrder(order);
    }

    public void UpdateOrder(Order order) throws DocumentNotFoundException, DocumentStatusTransitionError, DocumentValidationError {
        Order oldOrder = documentsDatabase.GetOrderById(Integer.toString(order.getId()));
        if (oldOrder == null) throw new DocumentNotFoundException();

        if (documentsDatabase.GetEmployeeById(order.getOrderAuthorId()) == null)
            throw new DocumentValidationError("invalid author id!");

        if (documentsDatabase.GetEmployeeById(order.getOrderExecutorId()) == null)
            throw new DocumentValidationError("invalid executor id!");

        OrderStatus oldStatus = oldOrder.getOrderStatus();
        if (oldStatus == OrderStatus.Executed || oldStatus == OrderStatus.Failed)
            throw new DocumentStatusTransitionError(
                    "Completed orders cannot be edited!"
            );
        documentsDatabase.UpdateOrder(order);
    }

    public List<Order> GetOrdersFor(String employeeId, int limit, int offset) {
        return documentsDatabase.GetOrdersForEmployyee(employeeId, limit, offset);
    }

    public List<Order> GetOrdersBy(String employeeId, int limit, int offset) {
        return documentsDatabase.GetOrdersByEmployee(employeeId, limit, offset);
    }

    public void DeleteOrder(String id) throws DocumentNotFoundException {
        if (documentsDatabase.GetOrderById(id) == null) {
            throw new DocumentNotFoundException();
        }
        documentsDatabase.DeleteOrder(id);
    }

}
