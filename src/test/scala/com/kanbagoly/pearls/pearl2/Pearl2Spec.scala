package com.kanbagoly.pearls.pearl2

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Pearl2Spec extends AnyWordSpec with Matchers {

  "Maximum Surpasser Count Specification" should {
    "return 0" when {
      "called with empty list" in {
        Specification.msc[Char](Nil) should be(0)
      }
      "called with list with one item" in {
        Specification.msc(List('a')) should be(0)
      }
      "called with elements in descending order" in {
        Specification.msc(List('b', 'a')) should be(0)
      }
    }
    "return positive value" when {
      "called with elements in ascending order" in {
        Specification.msc(List('a', 'b')) should be(1)
      }
      "called with the example from the book" in {
        Specification.msc("GENERATING".toList) should be(6)
      }
    }
  }

}
