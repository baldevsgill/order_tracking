package ordertracking.domain
import ordertracking.database.data._

/**
 * @author BaldevGill
 */
class CustomerOrder {
  
  def getNewOrders():Set[Orders] = {
    val sql:String = "select idCustomerOrder, isPaid, datePlaced from customerorder co, customerorderstatus cos where co.idcustomerorderstatus = cos.idcustomerorderstatus and cos.status = 'NEW'"
    
  }
  
}