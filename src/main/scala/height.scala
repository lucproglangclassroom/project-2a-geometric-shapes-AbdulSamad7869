package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object height:
    // computes depth or height of a given shape //
    def apply(shape: Shape): Int =
        Logger.debug(s"Computing height for: $shape")
        val result = shape match
            case Rectangle(_, _) | Ellipse(_, _) => 1
            // locations wraps a single inner shape so add one level of depth //
            case Location(_, _, innerShape) => 1 + apply(innerShape)
            // group contains multiple shapes. take max depth and add one for the group itself //
            case Group(subShapes*) => if subShapes.isEmpty then 1 
                else 1 + subShapes.map(apply).max
        Logger.debug(s"Resulting height: $result")
        result
end height