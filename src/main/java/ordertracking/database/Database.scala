package ordertracking.database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

/**
 * @author BaldevGill
 */
object Database extends Properties {

  var connection: Connection = null

  def connect() = {
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/mydb"

    // there's probably a better way to do this
    // var connection: Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
    } catch {
      case e: Throwable =>
        e.printStackTrace
        throw e;
    }
  }

  def disconnect() {
    if (!connection.isClosed()) {
      connection.close()
    }
  }

  def executeQuery(sql: String): ResultSet = {
    val statement = connection.createStatement()
    statement.executeQuery(sql)
  }

  def executeUpdate(sql:String) = {
     val statement = connection.createStatement()
     statement.executeUpdate(sql)
     statement.close();
  }
}