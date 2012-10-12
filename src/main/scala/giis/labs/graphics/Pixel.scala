package giis.labs.graphics

import giis.labs.model.Point
import java.awt.Color

/**
 * Class that represent the pixel. Pixels directly displays in the grid.
 *
 * @author Q-YAA
 */
class Pixel(pixelPoint: Point, context: DrawingContext) {

    /**
     * Point of the pixel placement.
     */
    val point = pixelPoint

    private var pixelColor = context.color

    /**
     * Get pixel color.
     *
     * @return
     */
    def color = pixelColor

    /**
     * Set pixel color.
     *
     * @param color pixel color
     */
    def color_=(color: Color) {
        pixelColor = color
    }

    override def toString = "point {" + pixelPoint.toString + ", " + pixelColor.toString + "}"

    override def hashCode() = point.hashCode()

    override def equals(other: Any) = other match {
        case that: Pixel => this.point == that.point
        case _ => false
    }
}

/**
 * Companion object for the pixel class. Contains utility methods.
 */
object Pixel {

    /**
     * Creates pixel from the coordinates and drawing context.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @param drawingContext drawing context for the pixel
     * @return created pixel
     */
    def createPixel(x: Int, y: Int, drawingContext: DrawingContext): Pixel = new Pixel(new Point(x, y), drawingContext)

    /**
     * Creates pixel from the point and drawing context.
     *
     * @param point placement point
     * @param drawingContext drawing context for the pixel
     * @return created pixel
     */
    def createPixel(point: Point, drawingContext: DrawingContext): Pixel = new Pixel(point, drawingContext)

    /**
     * Creates pixel list from the point list and drawing context.
     *
     * @param pointList list of the points
     * @param drawingContext drawing context for the pixel list
     * @return created pixel list
     */
    def createPixelList(pointList: List[Point], drawingContext: DrawingContext) = for (point <- pointList) yield {
        createPixel(point, drawingContext)
    }

    /**
     * Appends pixel to the pixel list, if the given pixel doesn't contains in the given list.
     * @param pixel pixel to append
     * @param pixelList list of pixels
     * @return result list
     */
    def appendPixelToListIfItNotInList(pixel: Pixel, pixelList: List[Pixel]): List[Pixel] = {
        if (!pixelList.contains(pixel)) {
            pixel :: pixelList
        }
        else {
            pixelList
        }
    }
}

