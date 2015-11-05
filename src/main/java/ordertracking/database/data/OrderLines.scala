package ordertracking.database.data
import scala.collection.mutable.Set
/**
 * @author BaldevGill
 *
 * Value Object for holding a collection of Order Line details
 */
class OrderLines {
  val orderLines: Set[OrderLine] = Set()

  def addOrderLine(orderLine: OrderLine): Unit = {
    orderLines += orderLine
  }

  def getOrderLines(): Set[OrderLine] = {
    orderLines
  }
}