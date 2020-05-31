package com.kanbagoly.pearls.pearl4

import scala.annotation.tailrec

object Specification {

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

object DivideAndConquerOnList {

  @tailrec
  def smallest[A](k: Int, zs: List[A], ws: List[A])(implicit ordered: A => Ordered[A]): A = (zs, ws) match {
    case (zs, Nil) => zs(k)
    case (Nil, ws) => ws(k)
    case (zs, ws) =>
      val p = zs.size / 2
      val q = ws.size / 2
      val (xs, a::ys) = zs.splitAt(p)
      val (us, b::vs) = ws.splitAt(q)
      (a < b, k <= p + q) match {
        case (true, true) => smallest(k, zs, us)
        case (true, false) => smallest(k - p - 1 , ys, ws)
        case (false, true) => smallest(k, xs, ws)
        case (false, false) => smallest(k - q - 1, zs, vs)
      }
  }

}

object DivideAndConquerOnArray {

  def smallest[A](k: Int, xa: Array[A], ya: Array[A])(implicit ordered: A => Ordered[A]): A = {
    @tailrec def search(k: Int)(lx: Int, rx: Int)(ly: Int, ry: Int): A =
      if (lx == rx) ya(k)
      else if (ly == ry) xa(k)
      else {
        val mx = (lx + rx) / 2
        val my = (ly + ry) / 2
        (xa(mx) < ya(my), k <= mx + my) match {
          case (true, true) => search(k)(lx, rx)(ly, my)
          case (true, false) => search(k - mx - 1)(mx, rx)(ly, ry)
          case (false, true) => search(k)(lx , mx)(ly, ry)
          case (false, false) => search(k - my - 1)(lx , rx)(my, ry)
        }
      }
    search(k)(0, xa.length)(0, ya.length)
  }

}