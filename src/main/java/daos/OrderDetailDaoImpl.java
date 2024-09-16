package daos;

import business.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michelle
 */
public class OrderDetailDaoImpl extends Dao implements OrderDetailDao {
    public OrderDetailDaoImpl(String databaseName){
        super(databaseName);
    }
    
    @Override
    public List<OrderDetail> getProductOrders(String prodCode){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<OrderDetail> orderDetails = new ArrayList();
        
        try{
            con = getConnection();

            String query = "Select * from orderdetails WHERE productCode = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, prodCode);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                OrderDetail line = new OrderDetail();
                line.setOrderNumber(rs.getInt("orderNumber"));
                line.setOrderLineNumber(rs.getInt("orderLineNumber"));
                line.setPriceEach(rs.getDouble("priceEach"));
                line.setProductCode(rs.getString("productCode"));
                line.setQuantityOrdered(rs.getInt("quantityOrdered"));
                orderDetails.add(line);
            }
        }catch (SQLException e) {
            System.out.println("Exception occurred in the getProductOrders() method: " + e.getMessage());
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
                System.out.println("Exception occurred in the finally section of the getProductOrders() method: " + e.getMessage());
            }
        }
        
        return orderDetails;
    }
}
