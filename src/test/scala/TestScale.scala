package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  test("scale rectangle") {
    val scaled = scale(Rectangle(10, 20), 2.0)
    assert(scaled == Rectangle(20, 40))
  }

  test("scale ellipse") {
    val scaled = scale(Ellipse(10, 15), 0.5)
    assert(scaled == Ellipse(5, 7))
  }

  test("scale location") {
    val scaled = scale(Location(10, 20, Rectangle(5, 10)), 2.0)
    assert(scaled == Location(20, 40, Rectangle(10, 20)))
  }

  test("scale group") {
    val originalGroup = Group(Rectangle(10, 10), Ellipse(20, 10))
    val scaled = scale(originalGroup, 2.0)
    scaled match
      case Group(Rectangle(scaledWidth, scaledHeight), Ellipse(scaledRadiusX, scaledRadiusY)) =>
        assert(scaledWidth == 20)
        assert(scaledHeight == 20)
        assert(scaledRadiusX == 40)
        assert(scaledRadiusY == 20)
      case _ => fail("Unexpected shape")
  }
