package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

// tests for the height or depth of shapes //
class TestHeight extends AnyFunSuite:

  test("height of simple rectangle") {
    assert(height(simpleRectangle) == 1)
  }

  test("height of simple location") {
    assert(height(simpleLocation) == 2)
  }

  test("height of basic group") {
    assert(height(basicGroup) == 2)
  }

  test("height of complex group") {
    assert(height(complexGroup) >= 4)
  }
