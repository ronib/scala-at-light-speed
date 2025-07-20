package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced7  extends App {
  lazy val aLazyValue = 2

   val another1 = {
    println("not lazy")
    43
  }
  println("** break 1 **")
  lazy val another2 = {
    println("so lazy")
    43
  }
  println("** break 2 **")
  val eager = another2 + 1

  println("** break 3 **")

  // usefull in infinite collections

  // more collections, un-safe methods
  def methodWhichCanReturnNull() : String = "hello, Scala"
  val anOption = Option(methodWhichCanReturnNull())
  // Option - is a collection of one element at most
  //  If it contains the value, it will be Some
  //    Some, is a sub type of option
  //  if it's null, the value is None( which is a singleton object, null)
  // Option = "collection" which contains at most on element: Some(value) or None

  val stringProcess = anOption match {
    case Some(string) => s"I have a string $string"
    case None => "I obtain nothing"
  }
  // NO NULL CHECKS! + you can use map, flatMap filter on Option because it is collection

  def methodWhichCanThrowException() : String = throw new RuntimeException
  // try catch - makes code unreadble

  val aTry = Try(methodWhichCanThrowException()) // this is a try object, that contains a string or exception.
  // it swallow the exception and wrap it
  // it's a collection with either, a value or an exception

  val anotherProcess = aTry match {
    case Success(value) => s"I have valid string $value"
    case Failure(exception)=> s"problem $exception"

  }
  // avoid defensive programming, we process them like a collection

  // async
  import scala.concurrent.ExecutionContext.Implicits.global
  // collection of thread to schedule evalutation.
  val aFuture = Future( {  // this is Future.apply
    // evalluated in another thread
    println("Loading.....")
    Thread.sleep(3000) //block running thread
    println("I have complteted")
    77
  })

  Thread.sleep((3005))// if i add this, the future value has time to complete in the other thread
 // future is a collection, which contains a value, when it's evaluated,
 // future is composable, with map, flatMap, filter,

  // Monand - fututre, try and option types, typpe of collections, abstract

  // IMPLICITS
  // powerfull scala compiler, allow :
  // 1 - implicit arguments
  def aMthodWithImplicitArgs(implicit arg: Int) = arg + 1
  
  // SCALA 2, NOT 3
  //implicit val myImplicitInt = 46
  //println(aMthodWithImplicitArgs) // will look for the paramter and use it, return 47
  
  
  // 2 implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // compiler is kind enough, to make new MyRichInteger(32).isEven, because it don't compile, find implicit wrapper , and maybe it has isEven method
  // use it carefully
  // makes scala expressive




}
