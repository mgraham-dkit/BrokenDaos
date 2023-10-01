package business;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author michelle
 */
public class OrderDetail implements Serializable {
    /*
        CREATE TABLE orderdetails (
            orderNumber int(11) NOT NULL,
            productCode varchar(15) NOT NULL,
            quantityOrdered int(11) NOT NULL,
            priceEach double NOT NULL,
            orderLineNumber smallint(6) NOT NULL,
            PRIMARY KEY  (orderNumber,productCode),
            FOREIGN KEY (orderNumber) REFERENCES orders(orderNumber),
            FOREIGN KEY (productCode) REFERENCES products(productCode)
        );
    */
    
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;

    public OrderDetail(){
        
    }
    
    public OrderDetail(int OrderNumber, String ProductCode, int QuantityOrdered, double priceEach, int orderLineNumber)
    {
        this.orderNumber = OrderNumber;
        this.productCode = ProductCode;
        this.quantityOrdered = QuantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public int getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(int OrderNumber)
    {
        this.orderNumber = OrderNumber;
    }

    public String getProductCode()
    {
        return productCode;
    }

    public void setProductCode(String ProductCode)
    {
        this.productCode = ProductCode;
    }

    public int getQuantityOrdered()
    {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int QuantityOrdered)
    {
        this.quantityOrdered = QuantityOrdered;
    }

    public double getPriceEach()
    {
        return priceEach;
    }

    public void setPriceEach(double priceEach)
    {
        this.priceEach = priceEach;
    }

    public int getOrderLineNumber()
    {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber)
    {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 67 * hash + this.orderNumber;
        hash = 67 * hash + Objects.hashCode(this.productCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final OrderDetail other = (OrderDetail) obj;
        if (this.orderNumber != other.orderNumber)
        {
            return false;
        }
        if (!Objects.equals(this.productCode, other.productCode))
        {
            return false;
        }
        return true;
    }



    @Override
    public String toString()
    {
        return "OrderDetail{" + "OrderNumber=" + orderNumber + ", ProductCode=" + productCode + ", QuantityOrdered=" + quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber=" + orderLineNumber + '}';
    }
}
