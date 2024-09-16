package daos;

import business.OrderDetail;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michelle
 */
public class OrderDetailDaoTest {
    
    /**
     * Test of getProductOrders method, of class OrderDetailDao.
     */
    @Test
    public void testGetProductOrders()
    {
        System.out.println("getProductOrders");
        String prodCode = "S12_4473";
        OrderDetailDaoImpl instance = new OrderDetailDaoImpl("testDatabase");
        
        List<OrderDetail> expResult = new ArrayList();
        // (10100,'S12_4473',50,55.09,2),
        OrderDetail od1 = new OrderDetail(10100, "S12_4473", 50, 55.09, 2);
        // (10101,'S12_4473',25,108.06,4),
        OrderDetail od2 = new OrderDetail(10101, "S12_4473", 25, 108.06, 4);
        expResult.add(od1);
        expResult.add(od2);
        
        List<OrderDetail> result = instance.getProductOrders(prodCode);
        
        assertEquals(expResult, result);
    }
}
