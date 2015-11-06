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

  def getNewOrders(): Map[Int, Order] = {
    val sql: String =
      "select idCustomerOrder, isPaid, datePlaced from customerorder co, customerorderstatus cos where co.idcustomerorderstatus = cos.idcustomerorderstatus and cos.status = 'NEW' order by idCustomerOrder"
    Database.connect()
    val rs: ResultSet = Database.executeQuery(sql)
    def loop(m: Map[Int, Order]): Map[Int, Order] = {
      if (rs.next) {
        val id = rs.getInt("idCustomerOrder")
        val isPaid = rs.getBoolean("isPaid")
        val datePlaced = rs.getDate("datePlaced")
        val order: Order = new Order(id, isPaid, datePlaced)
        loop(m + (id -> order))
      } else {
        rs.close()
        Database.disconnect()
        m
      }
    }
    loop(Map.empty)
  }
}
