# functional-pearls-in-scala

Reimplementation of Richard Bird's 
[Richard Bird](https://en.wikipedia.org/wiki/Richard_Bird_(computer_scientist)) 's
[Pearls of Functional Algorithm Design](https://www.cambridge.org/core/books/pearls-of-functional-algorithm-design/B0CF0AC5A205AF9491298684113B088F)
in Scala.

Please let me know if you have better, more compact or more functional solution. Especially for
the known issues.

### known issues
#### Pearl 1 - The smallest free number
The array based solution in the book able to provide an _O(n)_ time complexity to create an array used by the algorithm.
I could not find such way to create an array In Scala. I needed to chose between pure functional programming with
increased time complexity or using mutation. I ended up using mutation to create the array:
```scala
val array = Array.fill(n + 1)(false)
xs.withFilter(_ <= n).foreach(array(_) = true)
```

### other implementations in Scala
https://github.com/qtamaki/pearls
https://github.com/robberthcz/ScalaPearls