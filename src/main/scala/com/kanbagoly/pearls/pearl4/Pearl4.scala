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

  def smallest[A](k: Int, zs: List[A], ws: List[A])(implicit ordered: A => Ordered[A]): A = (zs, ws) match {
    case (zs, Nil) => zs(k)
    case (Nil, ws) => ws(k)
    case (zs, ws) =>
      val p = zs.size / 2
      val q = ws.size / 2
      val (xs, a::ys) = zs.splitAt(p)
      val (us, b::vs) = ws.splitAt(q)
      b
  }

}
