# functional-pearls-in-scala

Reimplementation of
[Richard Bird](https://en.wikipedia.org/wiki/Richard_Bird_(computer_scientist)) 's
[Pearls of Functional Algorithm Design](https://www.cambridge.org/core/books/pearls-of-functional-algorithm-design/B0CF0AC5A205AF9491298684113B088F)
in Scala.

Please let me know if you have better, more compact or more functional solution.

### deviation from the Haskell solutions in the book
#### Pearl 1 - The smallest free number
The array based solution in the book is able to build an array with _O(n)_ time complexity.
I could not find such way to create it in Scala. I needed to choose between pure functional programming with
increased time complexity or using mutation. I ended up using mutation to create the array:
```scala
val array = Array.fill(n + 1)(false)
xs.withFilter(_ <= n).foreach(array(_) = true)
```
The Divide and Conquer algorithm in the book works faster than the array based one. In this solution the opposite is 
true. The Divide and Conquer solution is much slower even if it made sure to use tail recursive function. 
#### Pearl 2 - A surpassing problem
The Divide and Conquer solution needed to be changed to be tail recursive. For large inputs without this change it died
with stack overflow error.  
The solution accepts empty list opposite to the book, as it was easy to implement.

### other implementations in Scala
https://github.com/qtamaki/pearls  
https://github.com/robberthcz/ScalaPearls  