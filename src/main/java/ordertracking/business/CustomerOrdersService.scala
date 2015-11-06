package ordertracking.business
import ordertracking.database.dao.CustomerOrderDAO
import ordertracking.database.vo.Order
import ordertracking.database.vo.OrderLine
import scala.collection.mutable.Set

/**
 * @author BaldevGill
 *
 * This is the Business Service for dealing with Customer orders
 */
class CustomerOrdersService {

  def getNewOrders: Set[Order] = {
    val customerOrderDao = new CustomerOrderDAO
    customerOrderDao.getNewOrders()
  }

  def getOrderLines(orderNo: Int): Set[OrderLine] = {
    val customerOrderDao = new CustomerOrderDAO
    customerOrderDao.getOrderLineDetails(orderNo)
  }
}
