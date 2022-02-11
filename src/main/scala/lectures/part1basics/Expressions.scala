package lectures.part1basics

object Expressions extends App{

  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

 val ac = true
  val acv = if(ac) 5 else 3
  println(acv)

// NEVER USER BELOW CODE
  var i = 0;
  while(i < 10) {
    println(i)
    i += 1
  }

  val awv = (i = 9)
  println(awv)

 val cb = {
   val y = 3
   val z =  y+ 2
   if(z > 4 ) "hello" else " bye"
 }
  println(cb)
}
