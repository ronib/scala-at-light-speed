package com.rockthejvm

object ObjectOrient4 extends App {

  class Animal {
    private val age : Int = 0
    protected val age2 : Int = 0;
    val age3 : Int = 0;
    def eat() = println("i'm eating")
  }// this is cass
  val anAnimal = new Animal; // this is instance
  class Dog(val name : String) extends Animal {

  }
  val myDog = new Dog("chucha")
  //myDog.age // its private, only for animal class
  //myDog.age2
  myDog.age3
  myDog.eat();

   // interface - ultimate abstract
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodail extends Animal with Carnivore {

    override def eat(animal: Animal): Unit = println("I eat you!")
  }

  val aCrock = new Crocodail
  aCrock.eat(myDog)
  aCrock eat myDog  // in fix notation, object method argument

  val a = 5
  val answer = a.*(6)
  println(s"5*6= $answer") // + - * / are also methods on type int


  object MySingle {
    val myValue = 433231l
    def myMethod(): Int = 123
    def apply(x:Int) : Int = x+1
  }
  MySingle.myMethod()
  MySingle.apply(65)
  MySingle(65)


  object Animal {
    val isStaticCanLEeaveForever = false
  }
  val myStaticField = Animal.isStaticCanLEeaveForever

  abstract class MyList[T] {
    def head: T
    def rest: MyList[T]
  }

  val intList: List[Int] = List(1,2,3)
  println(intList.head)
  println(intList.tail)

  val aStringList: List[String] = List("a", "b","c")
  println(aStringList.head)
  println(aStringList.tail)

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 54)
  // without new, Person.apply("Bob", 54), pattern matching, data structures with equals and serialization


}
