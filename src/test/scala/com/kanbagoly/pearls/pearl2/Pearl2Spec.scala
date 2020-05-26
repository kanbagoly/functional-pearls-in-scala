package com.kanbagoly.pearls.pearl2

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Pearl2Spec extends AnyWordSpec with Matchers with MaximumSurpasserCountBehavior {

  "Specification" should {
    behave like maxSurpasserCountAlgorithm(Specification.msc)
  }

  "Divide and Conquer algorithm" should {
    behave like maxSurpasserCountAlgorithm(DivideAndConquer.msc)

    "able to work with large input" in {
      DivideAndConquer.msc(List.fill(1000000)('a')) should be(0)
    }
  }

}

trait MaximumSurpasserCountBehavior {
  this: AnyWordSpec with Matchers =>

  def maxSurpasserCountAlgorithm(algorithm: List[Char] => Int): Unit = {
    "return 0" when {
      "called with empty list" in {
        algorithm(Nil) should be(0)
      }
      "called with list with one item" in {
        algorithm(List('a')) should be(0)
      }
      "called with elements in descending order" in {
        algorithm(List('b', 'a')) should be(0)
      }
    }
    "return positive value" when {
      "called with elements in ascending order" in {
        algorithm(List('a', 'b')) should be(1)
      }
      "called with the example from the book" in {
        algorithm("GENERATING".toList) should be(6)
      }
    }
  }
}
