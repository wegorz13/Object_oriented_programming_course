package agh.ics.oop.model;

public enum MapDirection {
    NORTH(new Vector2d(0,1)),
    SOUTH(new Vector2d(0,-1)),
    WEST(new Vector2d(-1,0)),
    EAST(new Vector2d(1,0));

    private final Vector2d unitVector;

    MapDirection(Vector2d unitVector) {
        this.unitVector = unitVector;
    }

    public String toString(MapDirection direction) {
        return switch (direction){
            case NORTH -> "Północ";
            case WEST -> "Zachód";
            case SOUTH -> "Południe";
            case EAST -> "Wschód";
        };
    }

    public MapDirection next(MapDirection direction){
        return switch (direction){
            case NORTH ->  MapDirection.EAST;
            case WEST ->  MapDirection.NORTH;
            case SOUTH ->  MapDirection.WEST;
            case EAST ->  MapDirection.SOUTH;
        };
    }

    public MapDirection previous(MapDirection direction){
        return switch (direction){
            case NORTH ->MapDirection.WEST;
            case WEST ->  MapDirection.SOUTH;
            case SOUTH -> MapDirection.EAST;
            case EAST ->  MapDirection.NORTH;
        };

    }

    public Vector2d toUnitVector(MapDirection direction) {
        return switch (direction){
            case NORTH -> this.unitVector;
            case WEST -> this.unitVector;
            case SOUTH -> this.unitVector;
            case EAST -> this.unitVector;
        };
    }
}
