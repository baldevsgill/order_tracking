package ordertracking.database.dao
import ordertracking.database.vo.User
import ordertracking.database.Database
import java.sql.ResultSet

/**
 * @author BaldevGill
 */
class UserDAO {

  def getUser(forename: String, password: String): User = {
    var user: User = null
    val sql: String =
      "select * from user, employee, role where user.idUser = employee.idEmployee and employee.role_idRole = role.idRole and user.forename = '" + forename + "' and  user.password = '" + password + "'";

    Database.connect()
    val rs: ResultSet = Database.executeQuery(sql)
    if (!rs.next()) {
      user = new User(0, null, null, null, false)
    } else {
      user = new User(rs.getInt("idUser"), rs.getString("forename"), rs.getString("surname"), rs.getString("email"), rs.getBoolean("isEmployee"))
    }
    rs.close()
    Database.disconnect()
    user
  }
}