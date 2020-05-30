package com.kanbagoly.pearls.pearl4

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Pearl4Spec extends AnyWordSpec with Matchers {

  "Algorithm" when {
    "First collection is empty and second contains only one element" should {
      "return the one element" in {
        Pearl4.smallest(0, Nil, List(1)) should be(1)
      }
    }
  }

}
