package com.kanbagoly.pearls.pearl2

object Specification {

  def msc[A](xs: List[A])(implicit ordered: A => Ordered[A]): Int =
    xs.tails.map {
      case Nil => 0
      case x::xs => xs.count(_ > x)
    }.max

}

object DivideAndConquer {

  def msc[A](xs: List[A])(implicit ordered: A => Ordered[A]): Int =
    table(xs).map(_._2).max

  private def table[A](xs: List[A])(implicit ordered: A => Ordered[A]): List[(A, Int)] = ???

}
