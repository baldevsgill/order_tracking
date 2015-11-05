package ordertracking.business
import ordertracking.database.dao.CustomerOrderDAO
import ordertracking.database.data.Order
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
}

/**
 * Tester class for the Customer orders Business Service
 */
object CustomerOrdersService {

  def main(args: Array[String]): Unit = {
    val cos = new CustomerOrdersService
    val orders: Set[Order] = cos.getNewOrders
    val it: Iterator[Order] = orders.iterator
    while (it.hasNext) {
      val order: Order = it.next()
      println("OrderId = " + order.getId + ", HasBeenPaidFor = " + order.getIsPaid + ", OrderDate = " + order.getDatePlaced)
    }
  }
}