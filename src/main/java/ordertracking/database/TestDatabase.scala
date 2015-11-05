package ordertracking.database

import java.sql.ResultSet

/**
 * @author BaldevGill
 */
object TestDatabase {

  def main(args: Array[String]): Unit = {
    Database.connect()
    val rs: ResultSet = Database.executeQuery("SELECT forename, surname, email FROM user")
    val pm = new PrintModule()
    pm.printResultSet(rs)
    rs.close()
    //Database.executeUpdate("update user set email = 'Baldev.gill@coldmail.com' where upper(forename) = 'BALDEV'")
    Database.disconnect()
  }
}