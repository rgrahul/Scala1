package lectures.part2OOP
/*
1 scala support inheritance of single.
2 only accessiable member

 */
object InheritanceAndTraits extends  App {

  class Animal {
    val ctype = "wild"
    def eat = println("nom nom")
  }

  class Cat extends Animal {
    def monmon = eat
  }

  val cat = new Cat
  cat.monmon

  /*// constructor
  class Person (name: String, age : Int)

  // super class need actual constructor define
  class Adult (name:String, age: Int, idCard : String) extends Person(name, age)*/

  // constructor
  class Person (name: String, age : Int) {
    def this(name: String) = this(name, 0)
  }

  // super class need actual constructor define
  class Adult (name:String, age: Int, idCard : String) extends Person(name)

    //overidding
    class Dog (override val ctype : String) extends  Animal {
      //override val ctype ="pet"
      override def eat = {
        super.eat  // method from base class ---
        println(" bhau bhau")
      }
    }

    val dog = new Dog("twst")
    dog.eat


  //type substitution or polymorphism
  val unAnimal : Animal = new Dog("kt9")
  unAnimal.eat

  //super

  //preventing overrides or inheritance
  // final on member or class itself
  // seal the class = can extend class in this file but prevent extend in other file.


}
