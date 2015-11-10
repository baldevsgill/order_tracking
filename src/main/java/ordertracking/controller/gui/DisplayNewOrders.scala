package ordertracking.controller.gui
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{ TableColumn, TableView }
import ordertracking.database.vo.Order
import ordertracking.business.CustomerOrdersService
import scalafx.Includes._
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

/**
 * @author BaldevGill
 */
class DisplayNewOrders extends JFXApp {

  def getNewOrdersStage(): PrimaryStage = {
    stage = new PrimaryStage {
      title = "New Orders"
      scene = new Scene {
        val data: ObservableBuffer[Order] = getData()
        content = new TableView[Order](data) {
          columns ++= List(
            new TableColumn[Order, Int] {
              text = "OrderId"
              cellValueFactory = { _.value.idCustomerOrder }
              prefWidth = 50
            },
            new TableColumn[Order, String]() {
              text = "Status"
              cellValueFactory = { _.value.status }
              prefWidth = 100
            },
            new TableColumn[Order, String] {
              text = "Customer"
              cellValueFactory = { _.value.customerName }
              prefWidth = 180
            },
            new TableColumn[Order, Boolean]() {
              text = "Already Paid?"
              cellValueFactory = { _.value.isPaid }
              prefWidth = 100
            },
            new TableColumn[Order, String]() {
              text = "Order Date"
              cellValueFactory = { _.value.datePlaced }
              prefWidth = 100
            })
          onMouseClicked = new EventHandler[MouseEvent] {
            override def handle(event: MouseEvent) {

              if (event.getClickCount == 2) {
                var orderId: Int = getData().apply(selectionModel.value.getFocusedIndex).idCustomerOrder.value
                val dod = new DisplayOrderDetails(orderId)
                stage = dod.getOrderDetailsStage
                event.consume
              }
            }
          }

        }
      }
    }
    stage
  }

  def getData(): ObservableBuffer[Order] = {

    val obOrders = new ObservableBuffer[Order]
    val cos = new CustomerOrdersService
    val orders: Map[Int, Order] = cos.getNewOrders
    for ((key, order) <- orders) {
      obOrders.append(order)
    }
    obOrders
  }
}
 
