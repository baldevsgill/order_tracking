import org.scalatest._

/**
 * Pulls in all the Traits required for testing the OrderTracking system
 * @author BaldevGill
 */
abstract class TestBase extends FlatSpec with Matchers with OptionValues with Inside with Inspectors {

}