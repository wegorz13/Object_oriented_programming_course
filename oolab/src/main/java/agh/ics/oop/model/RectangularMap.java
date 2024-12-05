package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d upperRightCorner;
    private final Vector2d lowerLeftCorner;
    private final Boundary boundary;

    public RectangularMap(int width, int height) {
        this.upperRightCorner = new Vector2d(width-1,height-1);
        this.lowerLeftCorner = new Vector2d(0,0);
        this.boundary = new Boundary(this.lowerLeftCorner,this.upperRightCorner);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (super.canMoveTo(position) && (position.follows(this.lowerLeftCorner) && position.precedes(this.upperRightCorner))) ;
    }

    @Override
    public Boundary getCurrentBounds() {
        return this.boundary;
    }

}




