package com.scala

object Iterators {

  def main(args: Array[String]): Unit = {

    val it = Iterator("Baidu", "Google", "Runoob", "Taobao")

    while (it.hasNext) {
      println(it.next())
    }

  }

}