package lectures.part2OOP

object ObjectBasic extends App {

val person = new Person("rahul", 28)
  println(person.age)
  person.greet("Chiku")
  person.greet()

  val author = new Writer("Charles", "tom",  1888)
  val authortest = new Writer("Charles", "tom",  1888)
  val novel = new Novel("testing boook", 1900, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(authortest))

  val counter = new Counter()
  counter.decrement.print
  counter.increment.print
  counter.increment(10).print
  counter.decrement(5).print


}
//constructor
//class parameter are not  lass field field
//class Person (name : String,  age: Int) => has class parameter
//class Person (name : String, val age: Int) => has class field which is age after adding val to parameter.
class Person (name : String, val age: Int) {
  val x = 2 // field
  println(1+3)

  //method
  def greet(name: String) : Unit = println(s"${this.name} says : Hi, $name") //rahul says : Hi, rashi
  // overloading
  def greet() : Unit = println(s"Hi, $name") //Hi, rahul


  //multiple constructor //
  def this(name:String) = this(name, 0)
  def this() = this("jhon")

}

class Writer (firstName: String, surName: String, val year: Int)
{
  def FullName() : String = s"$firstName $surName"
}

class Novel(name: String, yearOfRelease : Int,  writer : Writer)
{
  val authorAge = yearOfRelease - writer.year

  def isWrittenBy(writer: Writer) : Boolean = this.writer == writer

  def copy(newYearOfRelease: Int) : Novel = new Novel(name, newYearOfRelease, writer)
}

class Counter(val count : Int = 0) {

  def increment = {
    println("incrementing")
    new Counter(count + 1) //immutability return instance a lots in functional programing.

  }
  def decrement = {
    println("decrementing")
    new Counter(count - 1)
  }

  def increment(am : Int): Counter = {
    if (am <= 0) this
    else increment.increment(am-1)
  }
  def decrement(am : Int): Counter = {
    if(am <= 0 ) this
    else decrement.decrement(am -1)
  }

  def print = println(count)

}




