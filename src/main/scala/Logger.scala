package edu.luc.cs.laufer.cs371.shapes

object Logger:
  // Set this to true to enable debug output
  var enabled: Boolean = false

  def debug(msg: String): Unit =
    if enabled then println(msg)
