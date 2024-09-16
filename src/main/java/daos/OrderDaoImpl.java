package daos;

import business.Order;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
// THIS CLASS CONTAINS MULTIPLE SYNTAX ERRORS!
// Some of them repeat across methods
public class OrderDaoImpl implements OrderDao {
    // There are 7 syntax errors in this method
    @Override
    public Order getOrderById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM orders WHERE orderNumber = ?";
            ps = con.prepareStatement(query);
            ps.setInt(0, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                LocalDate orderDate = rs.getDate("orderDate");
                LocalDate reqDate = rs.getDate("requiredDate");
                LocalDate shipDate = rs.getDate("shippedDate");
                String status = rs.getString("status");
                String comments = rs.getString("comments");
                int custNum = rs.getInt("customerNumber");
                Order o = new Order(id, orderDate, reqDate, shipDate, status, comments, custNum);
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred in the getOrderById() method: " + e.getMessage());
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
                System.out.println("Exception occurred in the finally section of the getOrderById() method: " + e.getMessage());
            }
        }
        return o;
    }

    // There are 4 errors in this method
    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM orders";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderNum);
            rs = ps.executeQuery();

            while (rs.next()) {
                int orderNum = rs.getInt("orderNumber");
                LocalDate orderDate = rs.getDate("orderDate").toLocalDate();
                LocalDate reqDate = rs.getDate("requiredDate").toLocalDate();

                LocalDate shipDate = null;
                Date d = rs.getDate("shippedDate");
                if (d != null) {
                    shipDate = d.toLocalDate();
                }

                String status = rs.getString("status");
                String comments = rs.getInt("comments");
                int custNum = rs.getInt("customerNumber");
                Order o = new Order(orderNum, orderDate, reqDate, shipDate, status, comments, custNum);
                orders.add(o);
            }
        } catch (SQLException e) {
            System.out.println("Exception occurred in the getAllOrders() method: " + e.getMessage());
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
                System.out.println("Exception occurred in the finally section of the getAllOrders() method: " + e.getMessage());
            }
        }
        return orders;
    }

    // This is a mixed-error method, i.e. a combination of logic and syntax errors exist within this method.
    public boolean addOrder(Order o) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean added = false;

        try {
            con = getConnection();

            String query = "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(query);

            ps.setInt(1, o.getOrderNumber());
            ps.setDate(2, Date.valueOf(o.getOrderDate()));
            ps.setDate(3, Date.valueOf(o.getRequiredDate()));
            ps.setDate(4, o.getShippedDate());
            ps.setString(5, o.getStatus());
            ps.setString(6, o.getComments());
            ps.setInt(7, o.getCustomerNumber());

            rs = ps.executeUpdate();
            if(rs.next()){
                added = true;
            }

        } catch (SQLException e) {
            System.out.println("Exception occurred in the addOrder() method: " + e.getMessage());
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
                System.out.println("Exception occurred in the finally section of the addOrder() method: \n\t" +  e.getMessage());
            }
        }

        return added;
    }

    public static void main(String[] args) {
        OrderDaoImpl dao = new OrderDaoImpl("classicmodels");
        List<Order> orders = dao.getAllOrders();
        for(Order o: orders){
            System.out.println(o);
        }

        Order order = dao.getOrderById(10100);
        System.out.println("Located order: " + order);

        order = dao.getOrderById(101090);
        System.out.println("Located non-existent order: " + order);

        List<Order> custOrders = dao.getCustomerOrders(124);
        for(Order o: custOrders){
            System.out.println(o);
        }

        int orderNum = 10426;
        LocalDate orderDate = LocalDate.of(2023, Month.SEPTEMBER, 24);
        LocalDate requiredDate = LocalDate.of(2023, Month.OCTOBER, 10);
        LocalDate shippedDate = null;
        String status = "In Process";
        String comments = null;
        int custNum = 141;
        Order newOrder = new Order(orderNum, orderDate, requiredDate, shippedDate, status, comments, custNum);
        boolean added = dao.addOrder(newOrder);
        if(added){
            System.out.println("Order was added");}
        else{
            System.out.println("Order could not be added");
        }

        Order addedOrder = dao.getOrderById(orderNum);
        System.out.println("Added order: " + addedOrder);
    }
}
