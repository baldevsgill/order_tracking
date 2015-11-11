package ordertracking.database.mongodb
import com.mongodb.casbah.Imports._
import ordertracking.database.vo.Item
import scala.collection.mutable.ListBuffer
import ordertracking.database.Properties

/**
 * @author BaldevGill
 */
object MongoDBDatabase extends Properties {

  val mongoClient: MongoClient = MongoClient("localhost", 27017)
  val database = mongoClient(mongoDatabaseName)

}
