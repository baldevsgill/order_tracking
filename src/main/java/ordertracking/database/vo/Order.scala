package ordertracking.database.vo
import java.sql.Date
import scalafx.beans.property.{ ObjectProperty, StringProperty }

/**
 * @author BaldevGill
 *
 * Value Object for individual orders
 */
class Order(idCustomerOrder_ : Int, status_ : String, customerName_ : String, isPaid_ : Boolean, datePlaced_ : String) {

  val idCustomerOrder = new ObjectProperty(this, "idCustomerOrder", idCustomerOrder_)
  val status = new StringProperty(this, "status", status_)
  val customerName = new StringProperty(this, "customerName", customerName_)
  val isPaid = new ObjectProperty(this, "isPaid", isPaid_)
  val datePlaced = new StringProperty(this, "datePlaced", datePlaced_)

}



