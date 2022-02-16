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

/*
   Exercises:
   1.  Generic trait MyPredicate[-T] with a little method test(T) => Boolean
   2.  Generic trait MyTransformer[-A, B] with a method transform(A) => B
   3.  MyList:
       - map(transformer) => MyList
       - filter(predicate) => MyList
       - flatMap(transformer from A to MyList[B]) => MyList[B]

       class EvenPredicate extends MyPredicate[Int]
       class StringToIntTransformer extends MyTransformer[String, Int]

       [1,2,3].map(n * 2) = [2,4,6]
       [1,2,3,4].filter(n % 2) = [2,4]
       [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
  */
