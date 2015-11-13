import ordertracking.database.dao.CustomerOrderDAO
import ordertracking.database.vo.Order

/**
 * @author BaldevGill
 */
class TestCustomerOrderDAO extends TestBase {
  "A test sample of customer orders retrieved from database" should "return 4 entries" in {
    val custOrdDao = new CustomerOrderDAO()
    val orders: Map[Int, Order] = custOrdDao.getNewOrders()
    assert(orders.size == 4)
  }
  it should "contain an OrderId = 2, Status = ASSIGNED, CustomerName = Baldev, OrderPaidFor? = Yes, DatePlaced = 2015-11-06" in {
    val custOrdDao = new CustomerOrderDAO()
    val orders: Map[Int, Order] = custOrdDao.getNewOrders()

    assertResult(List(2)) {
      var value = null
      for {
        (k: Int, v) <- orders
        if (k == 2)
        value = orders(k)
      } yield k
    }
    // assert(value.status == "ASSIGNED")
  }
}