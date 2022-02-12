package lectures.part1basics

object CBNvsCBV extends App {
  def calledByValue(x:Long):Unit ={
    println("byvalue = " + x)
    println("byvalue = " + x)
  }

  def calledByName(x: => Long):Unit ={  // lazy evalutation
    println("byvalue = " + x)
    println("byvalue = " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())


  def Infinite() : Int = 1 + Infinite()
  def PrintFirst(x: Int, y: => Int) = println(x)



  //PrintFirst(Infinite,34 )
  PrintFirst(34,Infinite)
}
