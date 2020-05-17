package com.kanbagoly.pearls

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