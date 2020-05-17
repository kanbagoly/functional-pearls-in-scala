package com.kanbagoly.pearls

import scala.annotation.tailrec

object Naive {

  def minFree(xs: List[Int]): Int =
    LazyList.from(0).diff(xs).head

}

object ArrayBased {

  def minFree(xs: List[Int]): Int =
    search(checkList(xs))

  def search(xs: Array[Boolean]): Int =
    xs.takeWhile(identity).length

  def checkList(xs: List[Int]): Array[Boolean] = {
    val n = xs.length
    val array = Array.fill(n + 1)(false)
    xs.withFilter(_ <= n).foreach(array(_) = true)
    array
  }

}

object DivideAndConquer {

  def minFree(xs: List[Int]): Int = minFrom(0)(xs, xs.length)

  @tailrec
  def minFrom(a: Int)(xs: List[Int], n: Int): Int =
    if (n == 0) a
    else {
      val b = a + 1 + n / 2
      val (us, vs) = xs.partition(_ < b)
      val m = us.length
      if (m == b - a) minFrom(b)(vs, n - m)
      else minFrom(a)(us, m)
    }

}