package com.kanbagoly.pearls.pearl2

object Specification {

  def msc[T](xs: List[T])(implicit ordered: T => Ordered[T]): Int =
    xs.tails.map {
      case Nil => 0
      case x::xs => xs.count(_ > x)
    }.max

}

object DivideAndConquer {

}
