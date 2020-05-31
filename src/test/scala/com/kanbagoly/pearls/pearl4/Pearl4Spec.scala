package com.kanbagoly.pearls.pearl4

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Pearl4Spec extends AnyWordSpec with Matchers with SmallestBehavior {

  "Specification" should {
    behave like smallestAlgorithm(Specification.smallest)
  }

  "Divide and Conquer on list" should {
    behave like smallestAlgorithm(DivideAndConquerOnList.smallest)
  }

  "Divide and Conquer on array" should {
    behave like smallestAlgorithm(
      (k: Int, xs: List[Int], ys: List[Int]) => DivideAndConquerOnArray.smallest(k, xs.toArray, ys.toArray)
    )
  }

}

trait SmallestBehavior {
  this: AnyWordSpec with Matchers =>

  def smallestAlgorithm(algorithm: (Int, List[Int], List[Int]) => Int): Unit =
    "return the k th element" when {
      "first is empty and second contains only one element" in {
        algorithm(0, Nil, List(1)) should be(1)
      }
      "first contain only one element and second is empty" in {
        algorithm(0, List(1), Nil) should be(1)
      }
      "both contains more elements" in {
        algorithm(10, (0 to 20 by 2).toList, (1 to 21 by 2).toList) should be(10)
      }
      "input is large" in {
        val limit = 200000
        val mean = limit / 2
        DivideAndConquerOnList.smallest(mean, (0 to limit by 2).toList, (1 to limit + 1 by 2).toList) should be(mean)
      }
    }

}