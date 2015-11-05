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

  def getNewOrders {
    val customerOrder = new CustomerOrderDAO
    val customerOrders: Set[Order] = customerOrder.getNewOrders()
    val it: Iterator[Order] = customerOrders.iterator
    while (it.hasNext) {
      val order: Order = it.next()
      println(order.getId + " " + order.getIsPaid + " " + order.getDatePlaced)
    }
  }

}

/**
 * Tester class for the Customer orders Business Service
 */
object CustomerOrdersService {

  def main(args: Array[String]): Unit = {
    val cos = new CustomerOrdersService
    cos.getNewOrders
  }
}