package exercises

/*
    head = first element of  the  list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
  */

trait MyPredictor[-T] {
  def test(ele : T): Boolean
}

trait MyTransformer[-A, B]{
  def myTransformer(ele : A) : B
}

abstract class MyList[+A]{
  def head : A
  def tail : MyList[A]
  def isEmpty :Boolean
  def Add[B >: A](ele: B) : MyList[B]
  def printElement : String
  //polymorphic
  override def toString: String = "[" + printElement + "]"
  def map[B](transformer: MyTransformer[A,B]) : MyList[B]
  def flatMap[B](transformer: MyTransformer[A,MyList[B]]) : MyList[B]
  def filter (predicate: MyPredictor[A]) : MyList[A]

  //cpncatmetod
  def ++[B >: A](list:MyList[B]) : MyList[B]
}

// nothing is super class of every type
case object EmptyList extends MyList[Nothing] {
  override def head: Nothing  = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def Add[B >: Nothing](ele: B): MyList[B] = new cons(ele, EmptyList)
  override def printElement: String = ""
  def map[B](transformer: MyTransformer[Nothing,B]) : MyList[B] = EmptyList
  def flatMap[B](transformer: MyTransformer[Nothing,MyList[B]]) : MyList[B] = EmptyList
  def filter (predicate: MyPredictor[Nothing]) : MyList[Nothing] = EmptyList
  def ++[B >: Nothing](list:MyList[B]) : MyList[B] = list
}

case class cons[+A]( h:A, t : MyList[A]) extends MyList[A]{
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def Add[B >: A](ele: B): MyList[B] = new cons(ele, this)

  override def printElement: String = {
    if (t.isEmpty) "" + h
    else  h +", " + t.printElement
  }

  def filter(predicate: MyPredictor[A]) : MyList[A] = {
    if(predicate.test(h)) cons[A](h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: MyTransformer[A,B]) : MyList[B] = {
    cons(transformer.myTransformer(h), t.map(transformer))
  }

  def flatMap[B](transformer: MyTransformer[A,MyList[B]]) : MyList[B] = {
    transformer.myTransformer(h) ++ t.flatMap(transformer)
  }

  def ++[B >: A](list:MyList[B]) : MyList[B] = {
    cons(h , t ++ list)
  }
}

object  ListTest extends App{
  val intList : MyList[Int] =  cons[Int](1, cons[Int](2, cons[Int](3, EmptyList)))
  val intList1 : MyList[Int] =  cons[Int](1, cons[Int](2, cons[Int](3, EmptyList)))
  val stringList : MyList[String] = cons[String]("hello", cons[String]("sder", EmptyList))
  println(intList == intList1)

  val list1 = stringList.Add(1)

  println(intList.toString)
  println(stringList.toString)
  println(list1.toString)

  val list2 = intList.Add("sds")
  println(list2.head.getClass())


  println(intList.map(new MyTransformer[Int,Int] {
    override def myTransformer(ele: Int): Int = ele * 2
  }))

  println(intList.filter(new MyPredictor[Int] {
    override def test(ele: Int): Boolean = (ele % 2) == 0
  }))

  println(intList.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def myTransformer (ele :Int) ={
      cons[Int](ele, cons[Int](ele + 1, EmptyList))
    }
  }).toString)
}
