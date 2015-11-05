package ordertracking.database.data
import scala.collection.mutable.Set
/**
 * @author BaldevGill
 * 
 * Value Object for holding a collection of Orders
 */
class Orders {
  val orders: Set[Order] = Set()

  def addOrder(order: Order): Unit = {
    orders += order
  }

  def getOrders(): Set[Order] = {
    orders
  }
}