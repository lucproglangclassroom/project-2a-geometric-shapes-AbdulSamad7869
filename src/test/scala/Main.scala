package edu.luc.cs.laufer.cs371.shapes

import TestFixtures.*
import Shape.Rectangle

object Main:
  def main(args: Array[String]): Unit =
    Logger.enabled = true
    println(boundingBox(simpleLocation))
    println(Rectangle(2, 3) == Rectangle(2, 3))
end Main