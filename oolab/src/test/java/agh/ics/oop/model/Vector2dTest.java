package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    void equalsIsCorrect() {
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        Vector2d v3 = new Vector2d(3,2);

        //then
        assertTrue(v1.equals(v2));
        assertTrue(v1.equals(v1));
        assertFalse(v1.equals(v3));
        assertFalse(v1.equals(null));
    }

    @Test
    void toStringIsCorrect() {
        //given
        Vector2d v1 = new Vector2d(1,2);

        //then
        assertEquals("(1,2)" , v1.toString());
    }

    @Test
    void precedesIsCorrect(){
        //given
        Vector2d v1 = new Vector2d(2,2);
        Vector2d v2 = new Vector2d(3,3);
        Vector2d v3 = new Vector2d(1,3);
        Vector2d v4 = new Vector2d(3,1);
        Vector2d v5 = new Vector2d(1,1);


        //then
        assertTrue(v1.precedes(v1));
        assertTrue(v1.precedes(v2));
        assertFalse(v1.precedes(v3));
        assertFalse(v1.precedes(v4));
        assertFalse(v1.precedes(v5));
    }

    @Test
    void followsIsCorrect(){
        //given
        Vector2d v1 = new Vector2d(3,3);
        Vector2d v2 = new Vector2d(4,4);
        Vector2d v3 = new Vector2d(1,4);
        Vector2d v4 = new Vector2d(4,1);
        Vector2d v5 = new Vector2d(1,1);


        //then
        assertTrue(v1.follows(v1));
        assertFalse(v1.follows(v2));
        assertFalse(v1.follows(v3));
        assertFalse(v1.follows(v4));
        assertTrue(v1.follows(v5));
    }

    @Test
    void upperRightIsCorrect(){
        //given
        Vector2d v1 = new Vector2d(2,2);
        Vector2d v2 = new Vector2d(3,3);
        Vector2d v3 = new Vector2d(1,1);

        //when
        Vector2d v4 = v1.upperRight(v2);
        Vector2d v5 = v1.upperRight(v3);
        Vector2d v6 = v1.upperRight(v1);

        //then
        assertEquals(new Vector2d(3,3),v4);
        assertEquals(new Vector2d(2,2),v5);
        assertEquals(new Vector2d(2,2),v6);
    }

    @Test
    void lowerLeftIsCorrect(){
        //given
        Vector2d v1 = new Vector2d(2,2);
        Vector2d v2 = new Vector2d(3,3);
        Vector2d v3 = new Vector2d(1,1);

        //when
        Vector2d v4 = v1.lowerLeft(v2);
        Vector2d v5 = v1.lowerLeft(v3);
        Vector2d v6 = v1.lowerLeft(v1);

        //then
        assertEquals(new Vector2d(2,2),v4);
        assertEquals(new Vector2d(1,1),v5);
        assertEquals(new Vector2d(2,2),v6);
    }

    @Test
    void addIsCorrect(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);

        //when
        Vector2d v3 = v1.add(v2);

        //then
        assertEquals(new Vector2d(4,6),v3);
    }

    @Test
    void subtractIsCorrect(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);

        //when
        Vector2d v3 = v1.subtract(v2);

        //then
        assertEquals(new Vector2d(-2,-2),v3);
    }

    @Test
    void oppositeIsCorrect(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(-3,-4);
        Vector2d v3 = new Vector2d(0,0);

        //when
        Vector2d v4 = v1.opposite();
        Vector2d v5 = v2.opposite();
        Vector2d v6 = v3.opposite();

        //then
        assertEquals(new Vector2d(-1,-2),v4);
        assertEquals(new Vector2d(3,4),v5);
        assertEquals(new Vector2d(0,0),v6);
    }
}