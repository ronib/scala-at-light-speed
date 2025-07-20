package com.rockthejvm

object PatternMatch6 extends App {
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "seconds"
    case 3 => "third"
    case _ => anInteger + "th"
  }

  println(order)

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 32) // Person.apply(bob, 32)

  // case class decomposition
  val personGreeting = bob match {
    case Person(name, age) => s"Hi my name is $name and i'm $age years old"
    case _ => "something else"
  }

  println(personGreeting)

  val aTuple = ("Bon Jovi", "Rock")
  val aList = List(1,2,3,4,5)

  val listDesc = aList match {
    case List(_,_,3,_,_) => " 3 is in the middle"
    case _ => "unknow list"
  }
  // for no pattern match, it will throw <atchError.
  println(listDesc)
}
