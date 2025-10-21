package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(xOffset: Int, yOffset: Int, shape: Shape)
  case Ellipse(horizontalRadius: Int, verticalRadius: Int)
  case Group(shapes: Shape*)

  // makes sure that the shape's dimensions are not negative //
  private def valid: Boolean = this match
    case Rectangle(width, height) => width >= 0 && height >= 0
    case Location(_, _, innerShape) => innerShape.valid
    case Ellipse(horizontalRadius, verticalRadius) => horizontalRadius >= 0 && verticalRadius >= 0
    case Group(shapeList*) => shapeList.forall(_.valid)
end Shape