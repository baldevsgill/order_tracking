package ordertracking.database.vo

/**
 * @author BaldevGill
 */
class User(idUser: Int, forename: String, surname: String, email: String, isEmployee: Boolean) {

  def getIdUser = {
    idUser
  }

  def getForename = {
    forename
  }

  def getSurname = {
    surname
  }

  def getEmail = {
    email
  }

  def getIsEmployee = {
    isEmployee
  }

}