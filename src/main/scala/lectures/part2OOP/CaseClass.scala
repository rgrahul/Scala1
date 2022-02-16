package lectures.part2OOP

object CaseClass extends App {

  case class Person( name: String, age : Int)

  // 1 = class parameter are fields
  val jim = new Person("jim", 35)
  println(jim.name)

  //2 = toString sensible string
  //println(instance) = println(instance.totoString)
  println(jim.toString) // Person(jim,35) not as instance reference in case of normal class.

  //3 equal and hashcode implemented OOTB
  val jim2 = new Person("jim", 35)
  println(jim == jim2)


  //4 case classes has copy method
  val jim3 =jim.copy(age=56)
  println(jim3)

  //5 ccs has companion object
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6 ccs are serializable
  //Akka

  //7 ccs have extractor patterns = ccs can be used in pattern matching


  case object UK{
    def name : String = s"uk uk uk uk"
  }

}
