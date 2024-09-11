package recfun
import common._

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    @tailrec
    def pascalTail(col: Int, row: Int, prevRowNumbs: Array[Int], currRowNumbs: Array[Int]): Int = {
      val left = {
        if (col > 0)
          prevRowNumbs(col - 1)
        else
          0
      }
      val right = {
        if (col < row)
          prevRowNumbs(col)
        else
          0
      }
      currRowNumbs(col) = left + right

      if (col == c && row == r)
        currRowNumbs(col)
      else if (col < row)
        pascalTail(col + 1, row, prevRowNumbs, currRowNumbs)
      else  // reached end of that row -> start from col = 0, row = row + 1
        pascalTail(0, row + 1, currRowNumbs, new Array(_length = row + 2))
    }

    if (c == 0 || c == r)   // edges
      1
    else
      pascalTail(0, 1, Array(1), new Array(_length = 2))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def isBalanced(chars: List[Char], openCount: Int): Boolean = {
      if (chars.isEmpty)
        openCount == 0
      else if (chars.head == '(')
        isBalanced(chars.tail, openCount + 1)
      else if (chars.head == ')')
        (openCount > 0) && isBalanced(chars.tail, openCount - 1)
      else
        isBalanced(chars.tail, openCount)
    }

    // check each char to see if parenthesis, from beginning
    isBalanced(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 || coins.isEmpty)
      0
    else if (money == 0)
      1
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
