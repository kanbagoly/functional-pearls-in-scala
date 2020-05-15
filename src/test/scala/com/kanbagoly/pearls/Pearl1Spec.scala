package com.kanbagoly.pearls

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Pearl1Spec extends AnyWordSpec with Matchers {

  "Naive minFree" should {
    "return first element" when {
      "called with empty list" in {
        Naive.minFree(Nil) should be(0)
      }
      "called with 0" in {
        Naive.minFree(List(0)) should be(1)
      }
      "called with 1" in {
        Naive.minFree(List(1)) should be(0)
      }
      "called with an example from the book" in {
        val example = List(8, 23, 9, 0, 12, 11, 1, 10, 13, 7, 41, 4, 14, 21, 5, 17, 3, 19, 2, 6)
        Naive.minFree(example) should be (15)
      }
    }
  }

}
