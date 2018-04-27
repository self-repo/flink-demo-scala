package com.flink.demo

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.table.api.TableEnvironment
import org.apache.flink.api.scala._
import org.apache.flink.api.java.typeutils.TypeExtractor
import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.watermark.Watermark

object FromElementsDemo {

  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val tableEnv = TableEnvironment.getTableEnvironment(env)

    val datas = env.fromElements("cache", "tina", "bill", "abc")
    val dataStream = datas.map { x =>
      {
        print(x)
        var p = new Pojo
        p.name = x
        p.age = 1
        p
      }
    }
    dataStream.print()
  }

}

class Pojo {
  var name: String = _
  var age: Long = _

  def getName: String = this.name

  def getAge: Long = this.age

  def setName(name: String) = {
    this.name = name
  }

  def setAge(age: Long) = {
    this.age = age
  }

  override def toString(): String = {
    s"""(name: $name, age: $age)"""
  }
}