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
        MapDirection south_2 = east.next(east);
        MapDirection north_2 = west.next(west);
        MapDirection east_2 = north.next(north);
        MapDirection west_2 = south.next(south);

        //then
        assertEquals(MapDirection.SOUTH,south_2);
        assertEquals(MapDirection.NORTH,north_2);
        assertEquals(MapDirection.EAST,east_2);
        assertEquals(MapDirection.WEST,west_2);
    }

    @Test
    void previousMethodIsCorrect(){
        //given
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;

        //then
        MapDirection north_2 = east.previous(east);
        MapDirection south_2 = west.previous(west);
        MapDirection west_2 = north.previous(north);
        MapDirection east_2 = south.previous(south);

        //then
        assertEquals(MapDirection.NORTH,north_2);
        assertEquals(MapDirection.SOUTH,south_2);
        assertEquals(MapDirection.WEST,west_2);
        assertEquals(MapDirection.EAST,east_2);
    }
}