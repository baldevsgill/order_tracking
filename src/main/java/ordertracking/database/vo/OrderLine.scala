package ordertracking.database.vo
import java.sql.Date

/**
 * @author BaldevGill
 *
 * Value Object for order line details
 */
class OrderLine(orderNo: Int, idItem: Int, quantity: Int, name: String, description: String, noinstock: Int) {

  def getOrderNo: Int = {
    orderNo
  }

  def getIdItem: Int = {
    idItem
  }

  def getQuantity: Int = {
    quantity
  }

  def getName: String = {
    name
  }

  def getDescription: String = {
    description
  }

  def getNoinstock: Int = {
    noinstock
  }

}