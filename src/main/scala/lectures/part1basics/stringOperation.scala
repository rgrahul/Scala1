package lectures.part1basics

object stringOperation extends App
{
 val str : String = "hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

 val aNS = "45"
  val aN = aNS.toInt
  println('a' +: aNS :+ 'z')

  // Scala - specfic: String Interpolater
  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
