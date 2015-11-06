package ordertracking.controller
import ordertracking.business.CustomerOrdersService
import ordertracking.database.vo.Order
import scala.collection.mutable.Set

/**
 * @author BaldevGill
 */
/**
 * Retrieve a list of new orders from the database and print to console
 */
object GetNewOrders {
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