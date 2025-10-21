package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object size:
    // computes total number of shapes contained in a given shape structure //
    def apply(shape: Shape): Int =
        Logger.debug(s"Computing size for: $shape")
        val result = shape match
            case Rectangle(_, _) => 1
            case Ellipse(_, _) => 1
            // locations wraps another shape //
            case Location(_, _, innerShape) => apply(innerShape)
            // group contains multiple shapes. compute the size of each and sum //
            case Group(subShapes*) => subShapes.map(apply).sum
        Logger.debug(s"Resulting size: $result")
        result
end size