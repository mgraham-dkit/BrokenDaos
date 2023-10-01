package business;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author michelle
 */
public class Order implements Serializable {
    private int orderNumber;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private String status;
    private String comments;
    private int customerNumber;

    public Order()
    {
    }

    public Order(int orderNumber, LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate, String status,
                 String comments, int customerNumber)
    {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    public int getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate)
    {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate()
    {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate)
    {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate()
    {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate)
    {
        this.shippedDate = shippedDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public int getCustomerNumber()
    {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 89 * hash + this.orderNumber;
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
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Order{" + "orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate + ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customerNumber=" + customerNumber + '}';
    }

    
}
