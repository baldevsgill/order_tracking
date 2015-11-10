package ordertracking.database.vo
import java.sql.Date
import scalafx.beans.property.{ ObjectProperty, StringProperty }


/**
 * @author BaldevGill
 *
 * Value Object for order line details
 */
class OrderLine(orderNo_ : Int, idItem_ : Int, quantity_ : Int, name_ : String, description_ : String, noinstock_ : Int) {

  val orderNo = new ObjectProperty(this, "orderNo", orderNo_)
  val idItem = new ObjectProperty(this, "idItem", idItem_)
  val quantity = new ObjectProperty(this, "quantity", quantity_)
  val name = new StringProperty(this, "name", name_)
  val description = new StringProperty(this, "description", description_)
  val noinstock = new ObjectProperty(this, "noinstock", noinstock_)

//  def getOrderNo: Int = {
//    orderNo
//  }
//
//  def getIdItem: Int = {
//    idItem
//  }
//
//  def getQuantity: Int = {
//    quantity
//  }
//
//  def getName: String = {
//    name
//  }
//
//  def getDescription: String = {
//    description
//  }
//
//  def getNoinstock: Int = {
//    noinstock
//  }

}