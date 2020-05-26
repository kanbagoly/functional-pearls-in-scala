package com.kanbagoly.pearls.pearl2

object Specification {

  def msc[A](xs: List[A])(implicit ordered: A => Ordered[A]): Int =
    xs.tails.map {
      case Nil => 0
      case x::xs => xs.count(_ > x)
    }.max

}

object DivideAndConquer {

  //TODO: Deviation from the book
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

  private def join[A](n: Int, txs: List[(A, Int)], tys: List[(A, Int)])(implicit ordered: A => Ordered[A]): List[(A, Int)] =
    (n, txs, tys) match {
      case (0, txs, Nil) => txs
      case (_, Nil, tys) => tys
      case (n, (x, c)::txs1, (y, _)::_) if x < y => (x , c + n) :: join(n, txs1, tys)
      case (n, _, (y, d)::tys1) => (y, d) :: join(n - 1, txs, tys1)
    }

}
