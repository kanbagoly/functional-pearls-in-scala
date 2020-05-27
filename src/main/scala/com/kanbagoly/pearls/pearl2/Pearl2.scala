package com.kanbagoly.pearls.pearl2

import scala.annotation.tailrec

object Specification {

  def msc[A](xs: List[A])(implicit ordered: A => Ordered[A]): Int =
    xs.tails.map {
      case Nil => 0
      case x::xs => xs.count(_ > x)
    }.max

}

object DivideAndConquer {

  def msc[A](xs: List[A])(implicit ordered: A => Ordered[A]): Int = xs match {
    case Nil => 0
    case xs => table(xs).map(_._2).max
  }

  private def table[A](xs: List[A])(implicit ordered: A => Ordered[A]): List[(A, Int)] = xs match {
    case x::Nil => List((x, 0))
    case xs =>
      val m = xs.length
      val n = m / 2
      val (ys, zs) = xs splitAt n
      join(m - n, table(ys), table(zs))
  }

  @tailrec
  private def join[A](n: Int,
                      txs: List[(A, Int)],
                      tys: List[(A, Int)],
                      acc: List[(A, Int)] = Nil)(implicit ordered: A => Ordered[A]): List[(A, Int)] =
    (txs, tys) match {
      case (txs, Nil) if n == 0 => acc.reverse ::: txs
      case (Nil, tys) => acc.reverse ::: tys
      case ((x, c)::txs1, (y, _)::_) if x < y => join(n, txs1, tys, (x, c + n) :: acc)
      case (_, (y, d)::tys1) => join(n - 1, txs, tys1, (y, d) :: acc)
    }

}
