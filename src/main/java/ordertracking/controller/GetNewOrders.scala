package ordertracking.controller
import ordertracking.business.CustomerOrdersService
import ordertracking.database.vo.Order

/**
 * @author BaldevGill
 */
/**
 * Retrieve a list of new orders from the database and print to console
 */
object GetNewOrders {
  def main(args: Array[String]): Unit = {

    val cos = new CustomerOrdersService
    val orders: Map[Int, Order] = cos.getNewOrders
    println()
    for ((key, order) <- orders) {
      val isPaidYesNo: String = if (order.getIsPaid) "Yes" else "No"
      println("OrderId = " + order.getId + ", HasBeenPaidFor = " + isPaidYesNo + ", OrderDate = " + order.getDatePlaced)
    }
  }
}