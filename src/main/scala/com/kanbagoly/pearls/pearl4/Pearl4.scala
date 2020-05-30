package com.kanbagoly.pearls.pearl4

// TODO: use generics
object Pearl4 {

  def smallest(k: Int, xs: List[Int], ys:List[Int]): Int =
    union(xs, ys)(k)

  private def union(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (xs, Nil) => xs
    case (Nil, ys) => ys
    case (x::xs, y::_) if x < y => x :: union(xs, ys)
    case (_, y::ys) => y :: union(xs, ys)
  }

}
