package com.kanbagoly.pearls.pearl1

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Pearl1Spec extends AnyWordSpec with Matchers with MinFreeBehavior {

  "Specification" should {
    behave like minFreeAlgorithm(Specification.minFree)
  }

  "Array based algorithm" should {
    behave like minFreeAlgorithm(ArrayBased.minFree)
  }

  "Divide and Conquer algorithm" should {
    behave like minFreeAlgorithm(DivideAndConquer.minFree)

    "not throw stack overflow exception" when {
      "executed with large input" in {
        val largeNumber = 1000000
        DivideAndConquer.minFree((0 to largeNumber).toList) should be(largeNumber + 1)
      }
    }
  }

}

trait MinFreeBehavior {
  this: AnyWordSpec with Matchers =>

  def minFreeAlgorithm(algorithm: List[Int] => Int): Unit = {
    "return first element" when {
      "called with empty list" in {
        algorithm(Nil) should be(0)
      }
      "called with 0" in {
        algorithm(List(0)) should be(1)
      }
      "called with 1" in {
        algorithm(List(1)) should be(0)
      }
      "called with the example from the book" in {
        val example = List(8, 23, 9, 0, 12, 11, 1, 10, 13, 7, 41, 4, 14, 21, 5, 17, 3, 19, 2, 6)
        algorithm(example) should be(15)
      }
    }
  }
}
