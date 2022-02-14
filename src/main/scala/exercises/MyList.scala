package exercises

/*
    head = first element of  the  list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
  */

abstract class MyList[+A]{
  def head : A
  def tail : MyList[A]
  def isEmpty :Boolean
  def Add[B >: A](ele: B) : MyList[B]
  def printElement : String
  //polymorphic
  override def toString: String = "[" + printElement + "]"

}

// nothing is super class of every type
object EmptyList extends MyList[Nothing] {
  override def head: Nothing  = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def Add[B >: Nothing](ele: B): MyList[B] = new cons(ele, EmptyList)
  override def printElement: String = ""

}

class cons[+A]( h:A, t : MyList[A]) extends MyList[A]{
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def Add[B >: A](ele: B): MyList[B] = new cons(ele, this)

  override def printElement: String = {
    if (t.isEmpty) "" + h
    else  h +", " + t.printElement
  }
}

object  ListTest extends App{
  val intList : MyList[Int] =  new cons[Int](1, new cons[Int](2, new cons[Int](3, EmptyList)))
  val stringList : MyList[String] = new cons[String]("hello", new cons[String]("sder", EmptyList))

  val list1 = stringList.Add(1)

  println(intList.toString)
  println(stringList.toString)
  println(list1.toString)

  val list2 = intList.Add("sds")
  println(list2.head.getClass())
}
