package daos;

import business.Customer;
import business.Order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michelle
 */
public interface CustomerDaoInterface 
{
    public List<Customer> getAllCustomers();
    public List<Customer> getCustomersByName(String name);
    public List<Customer> getCustomersContainingName(String name);
    public int updateCustomerCreditLimit(int id, double amount);
    public int addCustomer(Customer c);
    public List<Order> getCustomerOrders(int custNum);
}
