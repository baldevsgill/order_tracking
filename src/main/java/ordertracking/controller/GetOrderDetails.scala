package ordertracking.controller
import ordertracking.business.CustomerOrdersService
import ordertracking.database.vo.OrderLine
import scala.collection.mutable.Set

/**
 * @author BaldevGill
 */
/**
 * Retrieve order details for a specified order. Print details to console.
 */
object GetOrderDetails {

  def main(args: Array[String]): Unit = {

    val orderNo: Int = 1

    val cos = new CustomerOrdersService
    val orderLines: Set[OrderLine] = cos.getOrderLines(orderNo)
    val it: Iterator[OrderLine] = orderLines.iterator
    println()
    println("Items for OrderNo:" + orderNo + " :-")
    while (it.hasNext) {
      val orderLine: OrderLine = it.next()
      println("idItem = " + orderLine.getIdItem + ", name = " + orderLine.getName + ", description = " + orderLine.getDescription + ", Quantity required = " + orderLine.getQuantity + ", Number in stock = " + orderLine.getNoinstock)
    }
  }
}

