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
  def aFunctionWithSideEffect(a: String):Unit = println(a)

  def aBigFunction(n : Int): Int = {
    def aSmallFunction(a: Int, b:Int) : Int = a + b

    aSmallFunction(n, n-1)
  }
  // Exersise
  def NameGenerator(name:String, age : Int) : String =
    {
      "Hi, my name is " + name + " and I am " + age + " year old."
    }

  def Factorial(n: Int) : Int = {
    if (n <= 0) 1 else n * Factorial(n-1)
  }

  def Fibonacci(n: Int):Int = {
    if(n <= 2) 1
    else Fibonacci(n-1) + Fibonacci(n-2)
  }

  def isPrime(num : Int) :Boolean = {

    /*if(num == 0 || num == 1) false

    if( num == i) true

    if (num % i == 0) false
    i+=1
    isPrime(num)*/

    def isPrimeUntill( t: Int) : Boolean = {
      if(t <= 1) true
      else num % t != 0 && isPrimeUntill((t-1))
    }

    isPrimeUntill(num / 2)
  }

  println(Factorial(5))
  println(Fibonacci(8))
  println(NameGenerator("rahul" , 28))
  println(isPrime(7))






}
