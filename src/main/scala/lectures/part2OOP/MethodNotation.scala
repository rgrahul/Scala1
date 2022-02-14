package lectures.part2OOP

import scala.language.postfixOps

/*
  Novel and a Writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

object MethodNotation extends App {

  class Person( val name : String, fmovie : String, val age :Int = 0) {
    def Likes(movie : String) : Boolean = movie == fmovie
    def hangoutWith(person: Person) = s"${this.name} is hangingout with ${person.name}"
    def unary_! : String = s"$name, what abouls hack"
    def isAlive : Boolean = false
    def apply() : String = s"hi , my name is $name"
    //exercise
    def +(str : String) : Person = new Person(s"$name ($str)", fmovie, age)
    def unary_+ : Person =  new Person(name, fmovie, age + 1)
    def learns(sub: String) : String = s"$name learns $sub"
    //def learnScala : String = learns("scala")
    def learnScala : String = this learns "scala"
    def apply(x: Int) : String = s"$name watched $fmovie $x times"
  }

  val mary = new Person("Mary", "Inception", 28)
  println(mary.Likes("Inception"))

  // equivalent
  // infix notation = operator notation, only valid for method with one parameter (syntatic sugar)
  println(mary Likes "Inception" ) // equivalent

  val tom = new Person("Tom", "War", 30)
  println(mary hangoutWith tom)

  // All operator are Method
  // operator =  hangoutWith Likes
  println(1 + 2)
  println(1.+(2))


  // prefix notation = unary operator only works for - + ~ !
  //unary_ prefix used in defining function.
  val x = -1
  val y = 1.unary_-

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary())  //equivalent it used with object as function and it will call apply method in that class.

  //exercise
  println((mary + "kindle")())
  println((+mary).age)

  println(mary learns "c#")
  println(mary learnScala)
  println(mary(10))



}

