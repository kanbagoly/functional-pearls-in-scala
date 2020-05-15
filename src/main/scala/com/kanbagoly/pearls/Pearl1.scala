package com.kanbagoly.pearls

object Naive {
  def minFree(xs: List[Int]): Int =
    LazyList.from(0).diff(xs).head

}

object Pearl1 {

}
