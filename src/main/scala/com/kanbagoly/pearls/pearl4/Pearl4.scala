package com.kanbagoly.pearls.pearl4

object Pearl4 {

  // TODO: be tail recursive
  def smallest[A](k: Int, xs: List[A], ys: List[A])(implicit ordered: A => Ordered[A]): A = {
    def union(xs: List[A], ys: List[A]): List[A] = (xs, ys) match {
      case (xs, Nil) => xs
      case (Nil, ys) => ys
      case (x::xs, y::_) if x < y => x :: union(xs, ys)
      case (_, y::ys) => y :: union(xs, ys)
    }
    union(xs, ys)(k)
  }

}
