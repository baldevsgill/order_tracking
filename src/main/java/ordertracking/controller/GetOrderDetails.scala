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
    val orderLines: Map[Int, OrderLine] = cos.getOrderLines(orderNo)
    println()
    println("Items for OrderNo:" + orderNo + " :-")
    for ((key, orderLine) <- orderLines) {
      println("OrderID: " + orderLine.getOrderNo + " -> " + "idItem = " + orderLine.getIdItem + ", name = " + orderLine.getName + ", description = " + orderLine.getDescription + ", Quantity required = " + orderLine.getQuantity + ", Number in stock = " + orderLine.getNoinstock)
    }
  }
}