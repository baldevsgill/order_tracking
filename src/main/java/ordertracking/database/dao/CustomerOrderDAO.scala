package ordertracking.database.dao
import ordertracking.database.data._
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
      "select idCustomerOrder, isPaid, datePlaced from customerorder co, customerorderstatus cos where co.idcustomerorderstatus = cos.idcustomerorderstatus and cos.status = 'NEW'"
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

}