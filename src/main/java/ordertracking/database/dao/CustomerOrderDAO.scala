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
      "select co.idCustomerOrder, cos.status, u.forename AS customerName, co.isPaid, co.datePlaced from customerorder co, customerorderstatus cos, customer c, user u where co.idcustomerorderstatus = cos.idcustomerorderstatus  and co.idCustomer = c.idUser and c.idUser = u.idUser and cos.status IN ('NEW', 'ASSIGNED') order by idCustomerOrder";
    Database.connect()
    val rs: ResultSet = Database.executeQuery(sql)
    def loop(m: Map[Int, Order]): Map[Int, Order] = {
      if (rs.next) {
        val id = rs.getInt("idCustomerOrder")
        val status = rs.getString("status")
        val customerName = rs.getString("customerName")
        val isPaid = rs.getBoolean("isPaid")
        val datePlaced = rs.getDate("datePlaced")
        val order: Order = new Order(id, status, customerName, isPaid, datePlaced)
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
