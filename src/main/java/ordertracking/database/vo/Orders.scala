package ordertracking.database.vo
import scala.collection.mutable.LinkedHashSet
/**
 * @author BaldevGill
 * 
 * Value Object for holding a collection of Orders
 */
class Orders {
  val orders: LinkedHashSet[Order] = LinkedHashSet()

  def addOrder(order: Order): Unit = {
    orders += order
  }

  def getOrders(): LinkedHashSet[Order] = {
    orders
  }
}