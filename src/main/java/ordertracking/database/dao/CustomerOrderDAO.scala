package ordertracking.database.dao
import ordertracking.database.vo._
import ordertracking.database.Database
import java.sql.ResultSet
import java.time.LocalDateTime
import scala.collection.mutable.Set
/**
 * @author BaldevGill
 * The DAO class for dealing with Customer Orders
 */
class CustomerOrderDAO {

  def getNewOrders(): Set[Order] = {
    val sql: String =
      "select idCustomerOrder, isPaid, datePlaced from customerorder co, customerorderstatus cos where co.idcustomerorderstatus = cos.idcustomerorderstatus and cos.status = 'NEW' order by idCustomerOrder"
    Database.connect()

    //Instantiate our collections class
    val orders: Orders = new Orders

    //Get data from database
    val rs: ResultSet = Database.executeQuery(sql)

    //Iterate over data and populate the collection
    while (rs.next()) {
      val id = rs.getInt("idCustomerOrder")
      val isPaid = rs.getBoolean("isPaid")
      val datePlaced = rs.getDate("datePlaced")
      val order: Order = new Order(id, isPaid, datePlaced)
      orders.addOrder(order)
    }
    //Tidy up
    rs.close();
    Database.disconnect()

    //Return
    orders.getOrders()
  }

  def getOrderLineDetails(orderNo: Int): Set[OrderLine] = {

    val sql: String =
      "select col.iditem, col.quantity, item.name, item.description, item.noinstock from customerorderline col, item where col.iditem = item.idItem and col.idCustomerOrder = " + orderNo
    Database.connect()

    //Instantiate our collections class
    val orderLines: OrderLines = new OrderLines

    //Get data from database
    val rs: ResultSet = Database.executeQuery(sql)

    //Iterate over data and populate the collection
    while (rs.next()) {
      val iditem = rs.getInt("iditem")
      val quantity = rs.getInt("quantity")
      val name = rs.getString("name")
      val description = rs.getString("description")
      val noinstock = rs.getInt("noinstock")
      val orderLine: OrderLine = new OrderLine(iditem, quantity, name, description, noinstock)
      orderLines.addOrderLine(orderLine)
    }
    //Tidy up
    rs.close();
    Database.disconnect()

    //Return
    orderLines.getOrderLines()
  }
}