package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  
  def apply(shape: Shape): Location =
    Logger.debug(s"Computing boundingBox for: $shape")
    val result: Location = shape match
      // rectangle's bounding box is itself at (0,0) //
      case Rectangle(width,height) => Location(0,0,Rectangle(width,height))

      // bounding box of ellipse is rectangle that spans its full diameter in both directions
      case Ellipse(horizontalRadius, verticalRadius) => Location(-horizontalRadius, -verticalRadius, Rectangle(2 * horizontalRadius, 2 * verticalRadius))

      // for a shape, find the inner bounding box and shift by offset //
      case Location(xOffset,yOffset,innerShape) =>
        val Location(innerX, innerY, Rectangle(innerWidth, innerHeight)) = apply(innerShape)
        Location(innerX + xOffset, innerY + yOffset, Rectangle(innerWidth, innerHeight))

      // for a group of shapes, combine the bounding boxes of all child shapes //
      case Group(shapeList*) => 
        val boundingBoxes: Seq[Location] = shapeList.map(apply)

        // get the positions and dimensions from each resulting bounding box //
        val allXPositions = boundingBoxes.map { case Location(x, _, _) => x}
        val allYPositions = boundingBoxes.map { case Location(_, y, _) => y}
        val allWidths = boundingBoxes.map {case Location(_, _, Rectangle(w, _)) => w }
        val allHeights = boundingBoxes.map { case Location(_, _, Rectangle(_, h)) => h }

        // compute min and max coordinates covered by all shapes //
        val minX = allXPositions.min
        val minY = allYPositions.min
        val maxX = (allXPositions zip allWidths).map { case (x, w) => x + w }.max
        val maxY = (allYPositions zip allHeights).map { case (y, h) => y + h }.max

        // make a bounding box that spans from the min to max //
        Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
    
    Logger.debug(s"Resulting boundingBox: $result")
    result
end boundingBox
