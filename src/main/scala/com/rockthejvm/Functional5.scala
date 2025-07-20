package com.rockthejvm

object Functional5 extends App {
// Scala is OO
  class Person(name: String) {
  def apply(age: Int) = println(s"my is a $age years old")
  }
  val bob = new Person("Bob")
  bob.apply(43)
  bob(42)
    // The presence of apply method, allows an instance of a class, to be INVOKE like a FUNCTION

    val simpleInc = new Function[Int, Int] {
      override def apply(arg: Int): Int = arg+1
    }

  simpleInc.apply(23) // 24
  simpleInc(24) // we defined an object instance, of Function1, but this object can be invoked as function,
  //// it can only do it. it act's like a function, and the only thing it can do is act like a function

  // all scala functions are instances of these functionX type
  val aNewList = List(1,2,3,4).map(x=>x+1)
  println(aNewList)
  val filtered = aNewList.filter(_ <3 ) // .filter(x=>x<3)
  println(filtered)

  val flatMapList = aNewList.flatMap(x=>List(x,2*x))
  println(flatMapList)

  val collectionList = List(1,2,3,4,5)
  val first = collectionList.head
  val rest = collectionList.tail
  val anotherList = 0 :: collectionList
  val another2 = anotherList :+ 6
  println(another2)

  val aSequence : Seq[Int] = Seq(1,2,3,4)
  println(aSequence(1))
  val onceSet = Set(1,2,3,4,3,2,1) // 21,2,3,4, // no duplicated
  val setWithFive = onceSet+5

  // ranges
  val aRange = 1 to 1000
  println(aRange)
  val aPhoneBook : Map[String, Int] = Map(("a", 123), "b" -> 333)
  println(aPhoneBook)
}
