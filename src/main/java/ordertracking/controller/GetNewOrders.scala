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
      val sb: StringBuilder = new StringBuilder()
      sb ++= "OrderId = " + order.idCustomerOrder.get + "\n"
      sb ++= "Status = " + order.status.get + "\n"
      sb ++= "CustomerName = " + order.customerName.get + "\n"
      val isPaidYesNo: String = if (order.isPaid.get) "Yes" else "No"
      sb ++= "OrderPaidFor? = " + isPaidYesNo + "\n"
      sb ++= "DatePlaced = " + order.datePlaced.get + "\n"
      println(sb)
    }
  }
}
    