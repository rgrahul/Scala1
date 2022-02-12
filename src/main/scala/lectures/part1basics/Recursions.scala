package lectures.part1basics

import scala.annotation.tailrec

object Recursions extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }
    println(factorial(5))


  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    Breakdown:

    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
    = 1 * 2 * 3 * 4 * ... * 10
   */

  //println(anotherFactorial(20000))

 def stringConCat(s: String, n : Int) : String = {
   def concatHelper(x:Int, ac: String) : String = {
     if (x == 0) ac
     else concatHelper(x - 1, s + ac)
   }
     concatHelper(n, "")

 }
 println(stringConCat("rahul ", 5))

  def isPrime(num : Int) :Boolean = {
  /*if(num == 0 || num == 1) false

  if( num == i) true

  if (num % i == 0) false
  i+=1
  isPrime(num)*/

  @tailrec
  def isPrimeUntill(t: Int, stillprime :Boolean) : Boolean = {
    if(!stillprime) false
    else if(t <= 1) true
    else  isPrimeUntill(t-1, num % t != 0 && stillprime)
  }

  isPrimeUntill(num /2, true)
}
  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8))
}
