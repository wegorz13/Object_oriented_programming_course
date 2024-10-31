package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void nextMethodIsCorrect(){
        //given
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;

        //when
        east = east.next(east);
        west = west.next(west);
        north = north.next(north);
        south = south.next(south);

        //then
        assertEquals(MapDirection.SOUTH,east);
        assertEquals(MapDirection.NORTH,west);
        assertEquals(MapDirection.EAST,north);
        assertEquals(MapDirection.WEST,south);
    }

    @Test
    void previousMethodIsCorrect(){
        //given
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;

        //then
        east = east.previous(east);
        west = west.previous(west);
        north = north.previous(north);
        south = south.previous(south);

        //then
        assertEquals(MapDirection.NORTH,east);
        assertEquals(MapDirection.SOUTH,west);
        assertEquals(MapDirection.WEST,north);
        assertEquals(MapDirection.EAST,south);
    }
}