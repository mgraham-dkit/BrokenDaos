package daos;

import business.OrderDetail;
import java.util.List;

/**
 *
 * @author michelle
 */
public interface OrderDetailDaoInterface {
    public List<OrderDetail> getProductOrders(String prodCode);
}
