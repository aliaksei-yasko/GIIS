package giis.labs.model.shape

import giis.labs.model.{ShapeType, Point}
import giis.labs.graphics.render.RenderFactory

/**
 * Abstract class for all shapes.
 *
 * @author Q-YAA
 */
abstract class Shape extends RenderFactory {

    /**
     * Returns point list that define the shape.
     *
     * @return List[Point] point list
     */
    def getPointList: List[Point]

    /**
     * Determines belong the given point to the shape or not.
     *
     * @param point point to determine
     * @return true if the point belong to the shape, false in other case
     */
    def isPointBelongsTo(point: Point): Boolean = getPointList.contains(point)

    /**
     * Move point from one position to another.
     *
     * @param from origin position
     * @param to new position
     */
    def movePoint(from: Point, to: Point)
}

/**
 * Companion object for the shape class. Contains all types of the possible shapes.
 */
object Shape {

    case object LineDda extends ShapeType {
        val name = "LineDda"
        val definingPointQuantity = 2
    }

    case object LineBrezenhem extends ShapeType {
        val name = "LineBrezenhem"
        val definingPointQuantity = 2
    }

    case object Circle extends ShapeType {
        val name = "Circle"
        val definingPointQuantity = 2
    }

    case object Bezier extends ShapeType {
        val name = "Bezier"
        val definingPointQuantity = 4
    }

    case object Ermit extends ShapeType {
        val name = "Ermit"
        val definingPointQuantity = 4
    }
}