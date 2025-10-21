package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object scale: 

    // scales all dimensions and positions in a shape by a given factor //
    def apply(shape: Shape, scaleFactor: Double): Shape =
        Logger.debug(s"Scaling shape: $shape by factor: $scaleFactor")
        val result = shape match
            // scale rectangle width and height //
            case Rectangle(width, height) => Rectangle((width * scaleFactor).toInt, (height * scaleFactor).toInt)
            // scale ellipse radii //
            case Ellipse(horizontalRadius, verticalRadius) => Ellipse((horizontalRadius * scaleFactor).toInt, (verticalRadius * scaleFactor).toInt)
            // scale both the position and inner shape // 
            case Location(xOffset, yOffset, innerShape) => Location((xOffset * scaleFactor).toInt, (yOffset * scaleFactor).toInt, apply(innerShape, scaleFactor))
            // scale every shape inside recursively // 
            case Group(subShapes*) => Group(subShapes.map(apply(_, scaleFactor))*)
        Logger.debug(s"Resulting scaled shape: $result")
        result
end scale