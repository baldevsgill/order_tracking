package ordertracking.database.vo
import scala.collection.mutable.LinkedHashSet
/**
 * @author BaldevGill
 *
 * Value Object for holding a collection of Order Line details
 */
class OrderLines {
  val orderLines: LinkedHashSet[OrderLine] = LinkedHashSet()

  def addOrderLine(orderLine: OrderLine): Unit = {
    orderLines += orderLine
  }

  def getOrderLines(): LinkedHashSet[OrderLine] = {
    orderLines
  }
}