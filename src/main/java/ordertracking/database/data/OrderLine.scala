package ordertracking.database.data
import java.sql.Date

/**
 * @author BaldevGill
 *
 * Value Object for order line details
 */
class OrderLine(idItem: Int, quantity: Int, name: String, description: String, noinstock: Int) {

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