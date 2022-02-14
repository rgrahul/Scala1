package lectures.part2OOP
/*
rules:
  =====  pass in required constructor arguments if needed
  =====  implement all abstract field/methods
 */


object AnonymousClasses extends App {
  abstract class Animal{
    def eat :Unit
  }

  /*
  what compiler does

  class AnonymousClasses$$anon$1 extends Animal{
    override def eat: Unit = println("lololololol")
    }

    val fAnimal : Animal = new AnonymousClasses$$anon$1
   */
  //AnonymousClasses
  val fAnimal : Animal = new Animal {
    override def eat: Unit = println("lololololol")
  }

  println(fAnimal.getClass)  // class lectures.part2OOP.AnonymousClasses$$anon$1

  class Person(name: String){
    def SayHi = println(s"hi my name is ${name}, whats up")
  }

   val jim = new Person("jim") {
     override def SayHi: Unit = println("jinjinjionjij")
   }

  println(jim.getClass) // AnonymousClasses$$anon$2
}
