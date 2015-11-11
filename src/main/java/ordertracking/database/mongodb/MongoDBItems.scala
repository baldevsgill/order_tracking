package ordertracking.database.mongodb
import com.mongodb.casbah.Imports._
import scala.collection.mutable.ListBuffer
import ordertracking.database.vo.Item

/**
 * @author BaldevGill
 */
class MongoDBItems(database: MongoDB) {

  //Get pointer to ItemsCollection collection of the database
  val itemsCollection = database("ItemsCollection")

  /**
   * load some Item documents into the Mongo database
   */
  def loadItems {
    val items: ListBuffer[Item] = new ListBuffer()
    items += new Item(1, "GreenSmallKnome", "Green small Knome", 31)
    items += new Item(2, "YellowSmallKnome", "Yellow Small Knome", 32)
    items += new Item(3, "RedSmallKnome", "Red Small Knome", 33)
    items += new Item(4, "BrownSmallKnome", "Brown Small Knome", 34)
    items += new Item(5, "PinkSmallKnome", "Pink Small Knome", 35)
    items += new Item(6, "GreenLargeKnome", "Green Large Knome", 36)
    items += new Item(7, "YellowLargeKnome", "Yellow Large Knome", 37)
    items += new Item(8, "RedLargeKnome", "Red Large Knome", 38)
    items += new Item(9, "BrownLargeKnome", "Brown Large Knome", 39)
    items += new Item(10, "PinkLargeKnome", "Pink Large Knome", 40)

    addItemsToMongoDB(items)
  }

  /**
   * Iterate over List and add items to database
   */
  def addItemsToMongoDB(items: ListBuffer[Item]) {
    for (item <- items) {
      val itemObject = MongoDBObject("idItem" -> item.idItem, "name" -> item.name, "description" -> item.description, "noinstock" -> item.noinstock);
      itemsCollection.insert(itemObject)
    }
  }

  /**
   * returns an Item entity from the MongoDB corresponding to the passed item ID
   */
  def getItem(idItem: Int): Item = {
    val queryObject = MongoDBObject("idItem" -> idItem)
    val itemDoc = itemsCollection.findOne(queryObject)
    if (itemDoc.isEmpty) { null } else { makeItemEntityFromMongoDBObject(itemDoc.get) }
  }

  /**
   * Deletes an Item entity from the MongoDB corresponding to the passed item ID
   */

  def deleteItem(idItem: Int): Unit = {
    val itemObject = MongoDBObject("idItem" -> idItem)

    if (!itemsCollection.findOne(itemObject).isEmpty) {
      itemsCollection.remove(itemObject)
      println("Item: " + idItem + " deleted")

    } else {
      println("Could not find item: " + idItem + ". Nothing deleted.")
    }

  }

  /**
   * returns an Item Entity from a mongo object
   */
  private def makeItemEntityFromMongoDBObject(itemObj: MongoDBObject): Item = {
    //val itemAttributes: Map[String, String] = itemObj.getAs[Map[String, String]]("ItemAttributes").get
    Item(itemObj.getAs[Int]("idItem").get,
      itemObj.getAs[String]("name").get,
      itemObj.getAs[String]("description").get,
      itemObj.getAs[Int]("noinstock").get)
  }
}

/**
 * Tester class
 */
object Test {
  def main(args: Array[String]): Unit = {
    val mongoDBItems = new MongoDBItems(MongoDBDatabase.database)
    //mongoDBItems.loadItems

    //def item: Item = mongoDBItems.getItem(2)
    //println(item)

    mongoDBItems.deleteItem(5)

  }
}