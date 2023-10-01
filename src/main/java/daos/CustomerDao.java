package daos;

import business.Customer;
import business.Order;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author michelle
 */
// THIS CLASS CONTAINS MULTIPLE LOGIC ERRORS
public class CustomerDao extends Dao implements CustomerDaoInterface {
    public CustomerDao(String databaseName) {
        super(databaseName);
    }

    // This method contains 3 logic errors
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Get a connection to the database
            conn = getConnection();

            // Set up the SQL and compile it for the database
            String query = "SELECT * FROM customers";
            ps = conn.prepareStatement(query);

            //Run query and get results
            rs = ps.executeQuery();

            // Load next result from resultset and process it
            while (rs.next()) {
                Customer c = new Customer();

                c.setCustomerNumber(rs.getInt("customerNumber"));
                c.setCustomerName(rs.getString("customerName"));
                c.setContactFirstName(rs.getString("contactFirstName"));
                c.setContactLastName(rs.getString("contactLastName"));
                c.setPhone(rs.getString("phone"));
                c.setAddressLine1(rs.getString("addressLine1"));
                c.setAddressLine2(rs.getString("addressLine2"));
                c.setCity(rs.getString("city"));
                c.setState(rs.getString("state"));
                c.setPostalCode(rs.getString("postalCode"));
                c.setCountry(rs.getString("country"));
                c.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
                c.setCreditLimit(rs.getDouble("creditLimit"));
            }
        } catch (SQLException e) {
            System.out.println("An exception occurred in the getAllCustomers(): " + e.getMessage());
        } finally {
            // Close resultset
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the ResultSet of the getAllCustomers(): " + e.getMessage());
            }
            // Close prepared statement
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the getAllCustomers(): " + e.getMessage());
            }
            // Close connection
            freeConnection(conn);
        }
        // Return results
        return customers;
    }

    // This method contains 4 logic errors
    @Override
    public int updateCustomerCreditLimit(int id, double amount) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rowsUpdated = 0;

        try {
            // Get a connection to the database
            conn = getConnection();

            // Set up the SQL and compile it for the database
            String query = "UPDATE customers SET creditLimit = creditLimit + ? WHERE customerNumber = ?";
            ps = conn.prepareStatement(query);

            // Fill in the blanks/parameters (?s)
            ps.setInt(1, id);
            ps.setDouble(2, amount);

            // Run SQL on database and get result
            rowsUpdated = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An exception occurred in the getAllCustomers(): " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the getAllCustomers(): " + e.getMessage());
            }
        }

        // Return if customer was updated
        return rowsUpdated;
    }

    // This method contains 1 logic error
    @Override
    public List<Customer> getCustomersByName(String name) {
        List<Customer> customers = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Get a connection to the database
            conn = getConnection();

            // Set up the SQL and compile it for the database
            String query = "SELECT * FROM customers WHERE customername = ?";
            ps = conn.prepareStatement(query);

            // Fill in the blank/parameter (?s)
            ps.setString(1, name);

            //Run query and get results
            rs = ps.executeQuery();

            // Load next result from resultset and process it
            if (rs.next()) {
                Customer c = new Customer();

                c.setCustomerNumber(rs.getInt("customerNumber"));
                c.setCustomerName(rs.getString("customerName"));
                c.setContactFirstName(rs.getString("contactFirstName"));
                c.setContactLastName(rs.getString("contactLastName"));
                c.setPhone(rs.getString("phone"));
                c.setAddressLine1(rs.getString("addressLine1"));
                c.setAddressLine2(rs.getString("addressLine2"));
                c.setCity(rs.getString("city"));
                c.setState(rs.getString("state"));
                c.setPostalCode(rs.getString("postalCode"));
                c.setCountry(rs.getString("country"));
                c.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
                c.setCreditLimit(rs.getDouble("creditLimit"));

                customers.add(c);
            }
        } catch (SQLException e) {
            System.out.println("An exception occurred in the getCustomersByName(): " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the getCustomersByName(): " + e.getMessage());
            }
        }

        // Return results
        return customers;
    }

    // This method contains one logic error
    @Override
    public List<Customer> getCustomersContainingName(String name) {
        List<Customer> customers = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Get a connection to the database
            conn = getConnection();

            // Set up the SQL and compile it for the database
            String query = "SELECT * FROM customers WHERE customername = ?";
            ps = conn.prepareStatement(query);

            // Fill in the blank/parameter (?s)
            ps.setString(1, "%" + name + "%");

            //Run query and get results
            rs = ps.executeQuery();

            // Load next result from resultset and process it
            while (rs.next()) {
                Customer c = new Customer();

                c.setCustomerNumber(rs.getInt("customerNumber"));
                c.setCustomerName(rs.getString("customerName"));
                c.setContactFirstName(rs.getString("contactFirstName"));
                c.setContactLastName(rs.getString("contactLastName"));
                c.setPhone(rs.getString("phone"));
                c.setAddressLine1(rs.getString("addressLine1"));
                c.setAddressLine2(rs.getString("addressLine2"));
                c.setCity(rs.getString("city"));
                c.setState(rs.getString("state"));
                c.setPostalCode(rs.getString("postalCode"));
                c.setCountry(rs.getString("country"));
                c.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
                c.setCreditLimit(rs.getDouble("creditLimit"));

                customers.add(c);
            }
        } catch (SQLException e) {
            System.out.println("An exception occurred in the getCustomersByName(): " + e.getMessage());
        } finally {
            // Close resultset
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the getCustomersByName(): " + e.getMessage());
            }
        }

        // Return results
        return customers;
    }

    // This method contains one logic error
    @Override
    public int addCustomer(Customer c) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "INSERT INTO customers VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);
            ps.setInt(1, c.getCustomerNumber());
            ps.setString(2, c.getCustomerName());
            ps.setString(3, c.getContactLastName());
            ps.setString(4, c.getContactFirstName());
            ps.setString(5, c.getPhone());
            ps.setString(6, c.getAddressLine1());
            ps.setString(7, c.getAddressLine2());
            ps.setString(8, c.getCity());
            ps.setString(9, c.getState());
            ps.setString(10, c.getPostalCode());
            ps.setString(11, c.getCountry());
            ps.setInt(12, c.getSalesRepEmployeeNumber());
            ps.setDouble(13, c.getCreditLimit());

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occurred in the addCustomer() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the finally section of the addCustomer() method: \n\t" +  e.getMessage());
            }
        }

        return rowsAffected;
    }

    /**
     * Searches for a customer entry matching the customer number supplied as a parameter.
     *
     * @param custNum The number of the customer to be found in the database.
     * @return The {@code Customer} contained in the database matching the supplied
     * customer number, or {@code null} otherwise.
     */
    // There is one issue linked to this method
    public Customer getCustomerById(int custNum) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer c = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM Customers WHERE customerNumber = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, custNum);
            rs = ps.executeQuery();

            if (rs.next()) {
                c = new Customer();
                // Get the pieces of a customer from the resultset
                c.setCustomerNumber(rs.getInt("customerNumber"));
                c.setCustomerName(rs.getString("customerName"));
                c.setContactFirstName(rs.getString("contactFirstName"));
                c.setContactLastName(rs.getString("contactLastName"));
                c.setPhone(rs.getString("phone"));
                c.setAddressLine1(rs.getString("addressLine1"));
                c.setAddressLine2(rs.getString("addressLine2"));
                c.setCity(rs.getString("city"));
                c.setState(rs.getString("state"));
                c.setPostalCode(rs.getString("postalCode"));
                c.setCountry(rs.getString("country"));
                c.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
                c.setCreditLimit(rs.getDouble("creditLimit"));
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred in the getCustomerById() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the finally section of the getCustomerById() method: " + e.getMessage());
            }
        }
        return c;
    }

    // There is one logic error in this method. There is one ADDITIONAL issue linked to this method
    public List<Order> getCustomerOrders(int custNum) {
        List<Order> orders = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM orders WHERE customerNumber = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, custNum);
            rs = ps.executeQuery();

            while (rs.next()) {
                int orderNum = rs.getInt("orderNumber");
                LocalDate orderDate = rs.getDate("orderDate").toLocalDate();
                LocalDate reqDate = rs.getDate("requiredDate").toLocalDate();
                LocalDate shipDate = rs.getDate("requiredDate").toLocalDate();
                String status = rs.getString("status");
                String comments = rs.getString("comments");
                Order o = new Order(orderNum, orderDate, reqDate, shipDate, status, comments, custNum);
                orders.add(o);
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred in the getCustomerOrders() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occurred in the finally section of the getCustomerOrders() method: " + e.getMessage());
            }
        }
        return orders;
    }

    public static void main(String[] args) {
        CustomerDao dao = new CustomerDao("classicmodels");
        List<Order> orders = dao.getCustomerOrders(124);
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
