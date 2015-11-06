package ordertracking.database.dao
import ordertracking.database.vo._
import ordertracking.database.Database
import java.sql.ResultSet
import java.time.LocalDateTime
/**
 * @author BaldevGill
 * The DAO class for dealing with Customer Orders
 */
class CustomerOrderDetailsDAO {

  def getOrderLineDetails(orderNo: Int): Map[Int, OrderLine] = {

    val sql: String =
      "select col.iditem, col.quantity, item.name, item.description, item.noinstock from customerorderline col, item where col.iditem = item.idItem and col.idCustomerOrder = " + orderNo
    Database.connect()
    val rs: ResultSet = Database.executeQuery(sql)

    def loop(m: Map[Int, OrderLine]): Map[Int, OrderLine] = {
      if (rs.next) {
        val iditem = rs.getInt("iditem")
        val quantity = rs.getInt("quantity")
        val name = rs.getString("name")
        val description = rs.getString("description")
        val noinstock = rs.getInt("noinstock")
        val orderLine: OrderLine = new OrderLine(orderNo, iditem, quantity, name, description, noinstock)
        loop(m + (iditem -> orderLine))
      } else {
        rs.close()
        Database.disconnect()
        m
      }
    }
    loop(Map.empty)
  }
}
