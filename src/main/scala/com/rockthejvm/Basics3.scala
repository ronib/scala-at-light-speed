package com.rockthejvm

object Basics3 extends App {
  val meaningOfLife: Int = 42 // define a value, like Java const
 // error - meaningOfLife  = 2
  val aBoolean = true //, type is optional
  println(meaningOfLife);
  //aBoolean = true

  val aString = "roni rioni roni"
  val aComposed =aString + " wow " + aBoolean + " " + "anohter"
  println(aComposed);
  val x3 = s"The meaning is $meaningOfLife + $aString";

  val expressions = 2+3 // structures that can be reduced to a value. expression.

  val ifExp = if (meaningOfLife > 43) 56 else 999 //

  // composed If

  val newExp = {
    if (meaningOfLife < 42) 566
    else if (meaningOfLife > 0) -2
    else if (meaningOfLife < 15) 78
    else 0 // assign value by condition, it's not and instruction

  }

  val codeBlock = {
    // defintiions

    val localval1 = 1
    val localval2 = 2

    localval2 + localval1 // value of the block
  }



  def myFunction(x:Int, y: String): String = y+ " " + x

  println(myFunction(3, "wow"))

  def factorial(n:Int): Int =
    if (n>33) 1
    else n*factorial(n-1)
  println("1" + factorial(56))

  import scala.annotation.tailrec

  try {
    println("222" + factorial(5000))
  } catch {
    case e: StackOverflowError => println("Stack overflow!")
  }

  def factoria2(n: Int): BigInt = {
    @tailrec
    def loop(x: Int, acc: BigInt): BigInt =
      if (x > 200000) acc
      else loop(x - 1, acc * x)

    loop(n, 1)
  }

  println("333" + factoria2(50000000))

    // no loops or iteratiopns, we use RECURSION. iteration is heavility discourage ,


  def myUnit(x: Int): Unit = {
    val a = 1
    val b = 2
    a+b+x
  }

  println(myUnit(5)); // return () which means void
}

