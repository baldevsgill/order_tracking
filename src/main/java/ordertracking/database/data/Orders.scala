package ordertracking.database.data

/**
 * @author BaldevGill
 */
class Orders {
  val orders: Set[Order] = Set()

  def addOrder(order: Order): Unit = {
    orders + order
  }

  def getOrders(): Set[Order] = {
    orders
  }
}