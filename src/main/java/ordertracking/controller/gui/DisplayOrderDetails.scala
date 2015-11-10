package ordertracking.controller.gui
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{ TableColumn, TableView }
import ordertracking.database.vo.OrderLine
import ordertracking.business.CustomerOrdersService
import scalafx.Includes._

/**
 * @author BaldevGill
 */
//object DisplayOrderDetails(orderNo: Int) extends JFXApp {
class DisplayOrderDetails(orderNo:Int) extends JFXApp {

  def getOrderDetailsStage(): PrimaryStage = {
    stage = new PrimaryStage {
      title = "Order Item Details"
      scene = new Scene {
        val data: ObservableBuffer[OrderLine] = getData()
        content = new TableView[OrderLine](data) {
          columns ++= List(
            new TableColumn[OrderLine, Int] {
              text = "Order Id"
              cellValueFactory = { _.value.orderNo }
              prefWidth = 80
            },
            new TableColumn[OrderLine, Int] {
              text = "Item Id"
              cellValueFactory = { _.value.idItem }
              prefWidth = 80
            },
            new TableColumn[OrderLine, String] {
              text = "Item"
              cellValueFactory = { _.value.name }
              prefWidth = 200
            },
            new TableColumn[OrderLine, String] {
              text = "description"
              cellValueFactory = { _.value.description }
              prefWidth = 200
            },
            new TableColumn[OrderLine, Int] {
              text = "Quantity Required"
              cellValueFactory = { _.value.quantity }
              prefWidth = 120
            },
            new TableColumn[OrderLine, Int] {
              text = "No in stock"
              cellValueFactory = { _.value.noinstock }
              prefWidth = 100
            })
        }
      }
    }
    stage
  }

  def getData(): ObservableBuffer[OrderLine] = {

    val obOrderLines = new ObservableBuffer[OrderLine]
    val cos = new CustomerOrdersService
    val orderLines: Map[Int, OrderLine] = cos.getOrderLines(orderNo)
    for ((key, orderLine) <- orderLines) {
      obOrderLines.append(orderLine)
    }
    obOrderLines
  }
}
 
