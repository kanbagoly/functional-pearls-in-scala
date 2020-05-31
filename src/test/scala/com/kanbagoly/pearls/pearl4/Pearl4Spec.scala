package com.kanbagoly.pearls.pearl4

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Pearl4Spec extends AnyWordSpec with Matchers {

  "Specification" when {
    "First collection is empty and second contains only one element" should {
      "return the one element" in {
        Pearl4.smallest(0, Nil, List(1)) should be(1)
      }
    }
    "First collection contain only one element and and second is empty" should {
      "return the one element" in {
        Pearl4.smallest(0, List(1), Nil) should be(1)
      }
    }
    "Both collection contains many elements" should {
      "return the k th element" in {
        Pearl4.smallest(10, (0 to 20 by 2).toList, (1 to 21 by 2).toList) should be(10)
      }
    }
  }

  "DivideAndConquer algorithm" when {
    "First collection is empty and second contains only one element" should {
      "return the one element" in {
        DivideAndConquer.smallest(0, Nil, List(1)) should be(1)
      }
    }
    "First collection contain only one element and and second is empty" should {
      "return the one element" in {
        DivideAndConquer.smallest(0, List(1), Nil) should be(1)
      }
    }
    "Both collection contains many elements" should {
      "return the k th element" in {
        DivideAndConquer.smallest(10, (0 to 20 by 2).toList, (1 to 21 by 2).toList) should be(10)
      }
    }
  }

}
