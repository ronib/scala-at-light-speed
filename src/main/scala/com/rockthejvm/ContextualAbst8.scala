package com.rockthejvm

object ContextualAbst8 {
  // context parameters
  val aList = List(2,1,5,6,3,1,6,8,4)
  val anOrderedList = aList.sorted // implicit parameter

  // comparision object, tell runtime which element is less then,
  // Ordering - glorified 2 elements function
  //given descendingOrdering : Ordering[Int] = Ordering.fromLessThan(_>_)
  // (a,b) => a>b, a should stay before b, if first is greater than b. defined your logic to compare numbers
  // Given , is fetch by the compiler for every simngle method that thakes ordering(3), use my defined Ordering,
  // the list is magically sorte backward
  // it's contextual argument, depending on the context in the sorted method being called, scala will fetch the instance
  // given - is like implicit value.
  // do you want behaviour depandant the will take context beahvour.



  trait Combinator[A] {
    def combine(x: A, y: A) : A
  }

  // collapse all the values in the list, into the same value, using a particular combinator
  def combineAll[A](list : List[A])(combinator: Combinator[A]): A = {
    list.reduce((a, b) => combinator.combine(a, b))
  }
  // it will be cumbersome to use it + better combineAll and not care what the combination logic will be, for the call side,
//  def combineAll2[A](list : List[A])(using combinator: Combinator[A]): A = {
//    list.reduce((a,b) => combinator.combine(a,b))
//  }
//
//  given intCombinator: Combinator[Int] = new Combinator[Int] {
//    override def combine(x: Int, y: Int): Int = x+y
//  }
 // val theSum = combineAll2(aList)



  // compiler look at local scope, imported scope, the compainions (singleton instances of the types in the method call)

  // context bound
  // you can all also mark for the compiler, to use a Combinator
  //def combinaAll_version3[A:Combinator](list: List[A]):A = {1}
  def main(args: Array[String]): Unit = {
    println(anOrderedList)
   // println(s"the sum is $theSum")

  }


}
