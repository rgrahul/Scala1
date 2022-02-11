package lectures.part1basics

object Functions extends App {

  def aFunction (a: String , b : Int) : String = {
    a + " " + b
  }

   println(aFunction("hello", 6))

  def aFunctionWithPara() : Int = 45

  println(aFunctionWithPara())
  println(aFunctionWithPara)

  // In Scala use recursion instead of loop

  // recursion function need return type always
  def aRepeatFunction(a: String, n :Int):String = {
    if (n == 1) a else a + aRepeatFunction(a,n-1)
  }

  println(aRepeatFunction("rahul ", 5))


  //function with Side affect
}
