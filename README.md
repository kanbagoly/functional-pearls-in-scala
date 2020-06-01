# functional-pearls-in-scala

Reimplementation of
[Richard Bird](https://en.wikipedia.org/wiki/Richard_Bird_(computer_scientist)) 's
[Pearls of Functional Algorithm Design](https://www.cambridge.org/core/books/pearls-of-functional-algorithm-design/B0CF0AC5A205AF9491298684113B088F)
solutions in Scala.

Please let me know if you have better, more compact or more functional solutions.

### deviation from the Haskell solutions in the book
Recursive functions which work fine in Haskell require change (if possible) to be explicitly tail recursive
in Scala. Without these changes the execution which does a lot of recursive calls throws a stack overflow exception.  

#### pearl 1 - The smallest free number
The array based solution in the book is able to build an array with _O(n)_ time complexity.
I could not find such way to create it in Scala. I needed to choose between pure functional programming with
increased time complexity or using mutation. I ended up using mutation to create the array:
```scala
val array = Array.fill(n + 1)(false)
xs.withFilter(_ <= n).foreach(array(_) = true)
```
#### pearl 2 - A surpassing problem
The solution accepts empty list opposite to the book, as it was easy to implement.  

#### pearl 4 - A selection problem
In the array based divide and conquer solution probably has some typo with the indices in the book (7ht printing 2014).
The solution in the book:
```haskell
smallest :: Int -> (Array Int a, Array Int a) -> a
smallest k (xa, ya) = search k (0, m + 1) (0, n + 1)
                      where (0, m) = bounds xa
                            (0, n) = bounds ya

search k (lx, rx) (ly, ry)
  | lx == rx  = ya ! k
  | ly == ry  = xa ! k
  | otherwise = case (xa ! mx < ya ! my, k <= mx + my) of
                (True, True)   -> search k (lx , rx) (ly, my)
                (True, False)  -> search (k - mx - 1) (mx, rx) (ly, ry)
                (False, True)  -> search k (lx , mx) (ly, ry)
                (False, False) -> search (k - my - 1) (lx, rx) (my, ry)
                where mx = (lx+rx ) `div` 2; my = (ly + ry) `div` 2
```
I believe the indices in the `search` function should be changed to:
```haskell
search k (lx, rx) (ly, ry)
  | lx == rx  = ya ! (ly + k)
  | ly == ry  = xa ! (lx + k)
  | otherwise = case (xa ! mx < ya ! my, k <= mx - lx + my - ly) of
                (True, True)   -> search k (lx , rx) (ly, my)
                (True, False)  -> search (k - (mx - lx) - 1) (mx + 1, rx) (ly, ry)
                (False, True)  -> search k (lx , mx) (ly, ry)
                (False, False) -> search (k - (my - ly) - 1) (lx, rx) (my + 1, ry)
                where mx = (lx+rx ) `div` 2; my = (ly + ry) `div` 2
```
### other implementations in Scala
https://github.com/qtamaki/pearls  
https://github.com/robberthcz/ScalaPearls  