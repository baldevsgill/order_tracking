package ordertracking.business
import ordertracking.database.dao.CustomerOrderDAO
import ordertracking.database.dao.CustomerOrderDetailsDAO
import ordertracking.database.vo.Order
import ordertracking.database.vo.OrderLine
import scala.collection.mutable.Set

/**
 * @author BaldevGill
 *
 * This is the Business Service for dealing with Customer orders
 */
class CustomerOrdersService {

  /**
   * Returns a list of all new orders
   */
  def getNewOrders: Map[Int, Order] = {
    val customerOrderDao = new CustomerOrderDAO
    customerOrderDao.getNewOrders()
  }

  /**
   * Returns order line details for a given order
   */
  def getOrderLines(orderNo: Int): Map[Int, OrderLine] = {
    val customerOrderDetailsDao = new CustomerOrderDetailsDAO
    customerOrderDetailsDao.getOrderLineDetails(orderNo)
  }
}
