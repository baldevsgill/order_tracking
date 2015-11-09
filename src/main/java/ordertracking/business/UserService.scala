package ordertracking.business
import ordertracking.database.dao.UserDAO
import ordertracking.database.vo.User

/**
 * @author BaldevGill
 *
 * This is the Business Service for dealing with Customer orders
 */
class UserService {

  /**
   * Returns details for logged in user
   */
  def getUser(forename: String, password: String): User = {
    val userDao = new UserDAO
    userDao.getUser(forename, password)
  }
}