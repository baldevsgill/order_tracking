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
import scalafx.geometry.VPos
import scalafx.scene.control.{ Button, CheckBox, Label, TextField }
import scalafx.scene.control.PasswordField
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.{ HBox, VBox }
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Text
import scalafx.scene.{ Group, Scene }
import scalafx.stage.{ Screen, StageStyle }
import ordertracking.database.dao.UserDAO
import ordertracking.database.vo.User
//import ordertracking.controller.gui.DisplayNewOrders

/**
 * @author BaldevGill
 */
object Login extends JFXApp {

  val userTextField = new TextField {
    text = ""
  }

  val passwordTextField = new PasswordField {
    text = ""
  }

  var testTextField = new TextField {
    text = ""
  }

  stage = new PrimaryStage {
    title = "New Orders"
    scene = new Scene(270, 370) {
      content = new Group {
        children = List(
          new VBox {
            layoutX = 30
            layoutY = 20
            spacing = 10
            children = List(
              new HBox {
                spacing = 10
                children = List(
                  new Label("Username:"),
                  userTextField)
              },
              new HBox {
                spacing = 10
                children = List(
                  new Label("Password:"),
                  passwordTextField)
              },
              new Button {
                text = "OK"
                onAction = handle {
                  if (validateUser(userTextField.text.value.toString(), passwordTextField.text.value.toString())) {
                    val dno2 = new DisplayNewOrders
                    //stage.hide()
                    stage = dno2.getNewOrdersStage()
                    //stage.show()

                  } else {
                    testTextField.text = "Invald usename / password"
                  }
                }
              },
              new Button {
                text = "Cancel"
                onAction = handle { stage.close() }
              },
              new HBox {
                spacing = 10
                children = List(
                  testTextField)
              })
          })
      }
    }
  }

  def validateUser(username: String, password: String): Boolean = {
    val userDao: UserDAO = new UserDAO();
    val user: User = userDao.getUser(username, password);
    if (user.getForename == null) { false } else { true }
  }

}