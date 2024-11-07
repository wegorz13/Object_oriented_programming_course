package agh.ics.oop.model;

public class Animal {
    private MapDirection c_direction = MapDirection.NORTH;
    private Vector2d c_position;

    private static final Vector2d MAP_LL_CORNER = new Vector2d(0,0);
    private static final Vector2d MAP_UR_CORNER = new Vector2d(4,4);

    public Animal(){
        this.c_position = new Vector2d(2,2);
    }

    public Animal(Vector2d position){
        this.c_position = position;
    }

    public String toString() {
        return "current_direction=" + this.c_direction + ", position=" + this.c_position.toString();
    }

    public boolean isAt(Vector2d position){
        return this.c_position.equals(position);
    }

    public Vector2d getPosition() {
        return this.c_position;
    }

    public MapDirection getDirection() {
        return this.c_direction;
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.c_direction = this.c_direction.next(this.c_direction);
            case LEFT -> this.c_direction = this.c_direction.previous(this.c_direction);
            case FORWARD -> {
                Vector2d new_position = this.c_position.add(this.c_direction.toUnitVector());
                if (new_position.follows(MAP_LL_CORNER) && new_position.precedes(MAP_UR_CORNER)){
                    this.c_position = new_position;
                }
            }
            case BACKWARD -> {
                Vector2d new_position = this.c_position.subtract(this.c_direction.toUnitVector());
                if (new_position.follows(MAP_LL_CORNER) && new_position.precedes(MAP_UR_CORNER)) {
                    this.c_position = new_position;
                }
            }
        }
    }
}
