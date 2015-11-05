package ordertracking.database.data
import java.sql.Date

/**
 * @author BaldevGill
 * 
 * Value Object for individual orders
 */
class Order(id: Int, isPaid: Boolean, datePlaced: Date) {

  def getId: Int = {
    id
  }

  def getIsPaid: Boolean = {
    isPaid
  }

  def getDatePlaced: Date = {
    datePlaced
  }
}