package agh.ics.oop.model;

public class Animal implements WorldElement{
    private MapDirection currentDirection = MapDirection.NORTH;
    private Vector2d currentPosition;

    private static final Vector2d MAP_LL_CORNER = new Vector2d(0,0);
    private static final Vector2d MAP_UR_CORNER = new Vector2d(4,4);

    public Animal(){
        this.currentPosition = new Vector2d(2,2);
    }

    public Animal(Vector2d position){
        this.currentPosition = position;
    }

    public String toString() {
        return switch (this.currentDirection){
            case NORTH -> "N";
            case WEST -> "W";
            case SOUTH -> "S";
            case EAST -> "E";
        };
    }

    public boolean isAt(Vector2d position){
        return this.currentPosition.equals(position);
    }

    public Vector2d getPosition() {
        return this.currentPosition;
    }

    public MapDirection getDirection() {
        return this.currentDirection;
    }

    public void move(MoveValidator validator, MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.currentDirection = this.currentDirection.next(this.currentDirection);
            case LEFT -> this.currentDirection = this.currentDirection.previous(this.currentDirection);
            case FORWARD -> {
                Vector2d newPosition = this.currentPosition.add(this.currentDirection.toUnitVector());
                if (validator.canMoveTo(newPosition)){
                    this.currentPosition = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.currentPosition.subtract(this.currentDirection.toUnitVector());
                if (validator.canMoveTo(newPosition )) {
                    this.currentPosition = newPosition;
                }
            }
        }
    }
}
