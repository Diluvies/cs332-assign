package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains intersecting elements") {
    new TestSets {
      val u1 = union(s1, s2)
      val u2 = union(s1, s3)
      val i = intersect(u1, u2)
      assert(contains(i, 1), "Intersect 1")
    }
  }

  test("diff contains different elements") {
    new TestSets {
      val u1 = union(s1, s2)
      val u2 = union(s1, s3)
      val d1 = diff(u1, u2)
      val d2 = diff(u2, u1)
      assert(contains(d1, 2), "Diff 2")
      assert(contains(d2, 3), "Diff 3")
    }
  }

  test("filter only selects predicate-satisfying elements") {
    new TestSets {
      val u = union(s1, s2)
      val filteredSet = filter(u, x => x % 2 == 0) // select even numbers
      assert(!contains(filteredSet, 1), "Filter 1")
      assert(contains(filteredSet, 2), "Filter 2")
    }
  }

  test("forall checks if all elements satisfy the predicate") {
    new TestSets {
      val s = union(union(s1, s2), s3)    // Set(1, 2, 3)
      assert(forall(s, x => x > 0), "All elements are greater than 0")
      assert(!forall(s, x => x % 2 == 0), "Not all elements are even")
    }
  }

  test("exists checks if there is at least one element that satisfies the predicate") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      assert(exists(s, x => x % 2 == 0), "There is at least one even element")
      assert(!exists(s, x => x > 3), "No element is greater than 3")
    }
  }

  test("map applies the given function to each element and returns the set") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      val mappedSet = map(s, x => x * 2)    // doubles each element
      assert(contains(mappedSet, 2), "Mapped set contains 2")
      assert(contains(mappedSet, 4), "Mapped set contains 4")
      assert(contains(mappedSet, 6), "Mapped set contains 6")
    }
  }
}
