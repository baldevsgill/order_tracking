package ordertracking.controller
import ordertracking.database.dao.UserDAO
import ordertracking.business.UserService
import ordertracking.database.vo.User

/**
 * @author BaldevGill
 */
/**
 * Retrieve a User details for logged in user print to console
 */
object ValidateUser {
  def main(args: Array[String]): Unit = {

    val testUser = "Baldev"
    val testPassword = "mypass"

    val userDao = new UserDAO
    val user = userDao.getUser(testUser, testPassword)
    println()

    if (user.getIdUser == 0) println("Invalid username / password supplied")
    val sb: StringBuilder = new StringBuilder()
    sb ++= "idUser = " + user.getIdUser + "\n"
    sb ++= "forename = " + user.getForename + "\n"
    sb ++= "surname = " + user.getSurname + "\n"
    sb ++= "email = " + user.getEmail + "\n"
    val isemployee: String = if (user.getIsEmployee) "Yes" else "No"
    sb ++= "isEmployee = " + isemployee + "\n"
    println(sb)
  }
}


