package ordertracking.database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

/**
 * @author BaldevGill
 *
 * Class that deals with database connections and executing simple queries
 */
object Database extends Properties {

  var connection: Connection = null

  /**
   * Connects to the local database
   */
  def connect() = {
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/mydb"

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

  /**
   * Closes the database connection
   */
  def disconnect() {
    if (!connection.isClosed()) {
      connection.close()
    }
  }

  /**
   * Executes a query against the database and returns a ResultSet object
   */
  def executeQuery(sql: String): ResultSet = {
    val statement: Statement = connection.createStatement()
    statement.executeQuery(sql)
  }

  /**
   * Executes an update statement against the database
   */
  def executeUpdate(sql: String) = {
    val statement: Statement = connection.createStatement()
    statement.executeUpdate(sql)
    statement.close();
  }
}