package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

// Unit tests for the size object //
class TestSize extends AnyFunSuite:

    test("size of simple ellipse") {
        assert(size(simpleEllipse) == 1)
    }

    test("size of simple rectangle") {
        assert(size(simpleRectangle) == 1)
    }

    test("size of simple location") {
        assert(size(simpleLocation) == 1)
    }

    test("size of basic group") {
        assert(size(basicGroup) == 2)
    }

    test("size of complex group") {
        assert(size(complexGroup) == 5)
    }