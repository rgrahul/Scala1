package lectures.part2OOP


/*
1 Scala doesnot have static value / method
2 scala object
  are in their own class
  are the only instance
  singleton pattern in one line

 3 Scala Companions
  can access each other's private member
  Scala is nor OO than Java

 */


object Object extends App {

  // Scala doesnot have class level functionality ("static")


  object  Person {
    // static class level function
    val N_eyes = 2
    def canFly :Boolean =  false

    //design pattern for companion and factory method

    def apply(mother :Person, father :Person) : Person = new Person("bob")

    def printype(person: Person) = println(person.eye)
  }

  class Person(name : String ){
    // instance level function
    val eye = Person.N_eyes
    val test = 10
  }

  //COMPANIONS

  println(Person.N_eyes)
  println(Person.canFly)

  // object are singleton instance by definition
  val mary = new Person("mary")
  val tom = new Person("tom")
  println(mary == tom)

  val p1 = Person
  val p2 = Person
  println(p1 == p2)


  val bob = Person(mary, tom)
  Person.printype(bob)

  //scala Application = scala object with
  //def main (argr: Array[String]): unit

}


