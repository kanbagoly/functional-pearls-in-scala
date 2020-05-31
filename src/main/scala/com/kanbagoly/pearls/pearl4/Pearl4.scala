package com.kanbagoly.pearls.pearl4

import scala.annotation.tailrec

object Pearl4 {

  def smallest[A](k: Int, xs: List[A], ys: List[A])(implicit ordered: A => Ordered[A]): A = {
    @tailrec def union(xs: List[A], ys: List[A], acc: List[A] = Nil): List[A] = (xs, ys) match {
      case (xs, Nil) => acc.reverse:::xs
      case (Nil, ys) => acc.reverse:::ys
      case (x::xs, y::_) if x < y => union(xs, ys, x::acc)
      case (_, y::ys) => union(xs, ys, y::acc)
    }
    union(xs, ys)(k)
  }

}

object DivideAndConquer {

  def smallest[A](k: Int, xs: List[A], ys: List[A])(implicit ordered: A => Ordered[A]): A =
    xs.head

}
