package lectures.part2OOP


// traits vs abstract classes
// 1 - traits do not have constructor parameters
// 2 - multiple traits may be inherited by the same class
// 3 - traits = behavior, abstract class = "thing"

object AbstractDatatype extends App {

  // abstract class with member not implement
  abstract class Animal{
    val cType: String = "wild"
    def eat : Unit
  }

  class Dog extends Animal {
    // override is not necesary bcoz since no member is define then complier take it as overriding itself for both field and method
    override val cType = "K9"
     def eat = println("bhau bhau")
  }

  // Traits

  trait Carnivore {
    def eat (animal: Animal) : Unit
  }

  trait coldBlooded

  class Lion extends Animal with Carnivore with coldBlooded{
    override val cType: String = "Lion"

    override def eat: Unit = println("nananana")

    override def eat(animal: Animal): Unit = println(s"I'm a lion and I'm eating ${animal.cType}")
  }

  val dog = new Dog
  val lion = new Lion

  lion.eat(dog)
}

