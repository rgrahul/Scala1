package lectures.part2OOP

object Generics extends App {

  class MyList[+A] {
    // use the type A in class definition
    //use in trait also
    def add[B >: A](element: B) : MyList[B] = ???
    /*
    A = cat
    B =Dog =  Animal ===== Animal
     */

  }

  class MyMap[Key, Value]

    val listOfInt = new MyList[Int]
    val listOfString = new MyList[String]

    //generic methods
    object MyList {
      def empty[A] : MyList[A] =  ???
    }

  val emptyListOfInt = MyList.empty[Int]


  //variance Problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[cat] extends List[Animal] = covariance
  class CovarianceList[+A]
  val animal:Animal = new Cat
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]

  //animalList.add(new Dog) ??? -doubt => return list of animal

  //2. No = Invariance
  class InvarianceList[A]
  val invarianceAnimalList : InvarianceList[Animal] = new InvarianceList[Animal]
  //val invarianceAnimalList : InvarianceList[Animal] = new InvarianceList[Cat]  -- no

  // 3 hell no Contravariance
  class ContravarianceList[-A]
  val contravarianceList: ContravarianceList[Cat] = new ContravarianceList[Animal]

  class Trainer[-A]
  val trainer : Trainer[Cat] = new Trainer[Animal]

  //bounded type = bound class to be of specific type

  //upper bounded class = accept only sun type of animal
  class Cage[A <: Animal] (animal: A)
  val cage = new Cage(new Dog)

  // Below code will give run time exception
  /*class Car
  val newCage = new Cage(new Car)*/

  //lower bounded accept some thing which is super type of Animal
  class Cage1[A >: Animal] (animal: A)
  val cage1 = new Cage(new Dog)


}
