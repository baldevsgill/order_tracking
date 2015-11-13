import org.scalatest.FlatSpec
import org.scalatest._

/**
 * @author BaldevGill
 */
class MySuite extends Suites(
  new ExampleSpec,
  new SetSpec,
  new StackSpec)