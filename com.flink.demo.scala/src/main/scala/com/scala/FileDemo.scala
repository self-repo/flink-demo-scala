package com.scala

import java.io.PrintWriter
import java.io.File
import scala.io.Source

object FileDemo {

  def main(args: Array[String]): Unit = {

    val writer = new PrintWriter(new File("test.txt"))
    writer.write("hello-world!!!")
    writer.close()

    Source.fromFile("test.txt").foreach {
      print
    }

  }

}