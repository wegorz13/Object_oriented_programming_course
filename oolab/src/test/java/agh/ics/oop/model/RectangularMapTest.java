package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {


    @Test
    void isOccupied(){
        RectangularMap map = new RectangularMap(4,4);

        Vector2d vec1 = new Vector2d(1,3);

        assertFalse(map.isOccupied(vec1));
        map.place(new Animal(vec1));
        assertTrue(map.isOccupied(vec1));
    }

    @Test
    void placeIsCorrect(){
        RectangularMap map = new RectangularMap(4,4);

        Vector2d vec1 = new Vector2d(1,5);
        Vector2d vec2 = new Vector2d(5,1);
        Vector2d vec3 = new Vector2d(0,1);
        Vector2d vec4 = new Vector2d(0,1);

        //zły y
        Animal animal1 = new Animal(vec1);
        assertFalse(map.place(animal1));
        //zły x
        Animal animal2 = new Animal(vec2);
        assertFalse(map.place(animal2));
        //ok
        Animal animal3 = new Animal(vec3);
        assertTrue(map.place(animal3));
        //zajęta pozycja
        Animal animal4 = new Animal(vec4);
        assertFalse(map.place(animal4));

    }

    @Test
    void objectAtIsCorrect(){
        RectangularMap map = new RectangularMap(4,4);

        Vector2d vec = new Vector2d(2,3);
        Animal animal = new Animal(vec);

        map.place(animal);

        assertEquals(animal,map.objectAt(vec));
        assertNull(map.objectAt(new Vector2d(2, 2)));
    }

    @Test
    void canMoveToIsCorrect(){
        RectangularMap map = new RectangularMap(4,4);

        Vector2d vec1 = new Vector2d(1,5);
        Vector2d vec2 = new Vector2d(5,1);
        Vector2d vec3 = new Vector2d(1,-5);
        Vector2d vec4 = new Vector2d(-5,1);
        Vector2d vec5 = new Vector2d(1,3);

        assertFalse(map.canMoveTo(vec1));
        assertFalse(map.canMoveTo(vec2));
        assertFalse(map.canMoveTo(vec3));
        assertFalse(map.canMoveTo(vec4));
        assertTrue(map.canMoveTo(vec5));

        Animal animal = new Animal(vec5);
        map.place(animal);

        assertFalse(map.canMoveTo(vec5));
    }

    @Test
    void moveIsCorrect(){
        RectangularMap map = new RectangularMap(5,5);

        Vector2d vec1 = new Vector2d(1,4);
        Vector2d vec2 = new Vector2d(4,1);
        Vector2d vec3 = new Vector2d(0,1);
        Vector2d vec4 = new Vector2d(1,0);

        Animal animal1 = new Animal(vec1);
        map.place(animal1);
        Animal animal2 = new Animal(vec2);
        map.place(animal2);
        Animal animal3 = new Animal(vec3);
        map.place(animal3);
        Animal animal4 = new Animal(vec4);
        map.place(animal4);
        Animal animal5 = new Animal();
        map.place(animal5);

        //KIERUNKI

        //w prawo/ wschód
        map.move(animal2, MoveDirection.RIGHT);
        //w lewo/ zachód
        map.move(animal3,MoveDirection.LEFT);
        //w dol/ południe
        map.move(animal4,MoveDirection.RIGHT);
        map.move(animal4,MoveDirection.RIGHT);

        assertEquals(animal2.getDirection(),MapDirection.EAST);
        assertEquals(animal3.getDirection(),MapDirection.WEST);
        assertEquals(animal4.getDirection(),MapDirection.SOUTH);


        //KRAWĘDZIE

        //górna
        map.move(animal1,MoveDirection.FORWARD);
        //prawa
        map.move(animal2,MoveDirection.FORWARD);
        //lewa
        map.move(animal3,MoveDirection.FORWARD);
        //dolna
        map.move(animal4,MoveDirection.FORWARD);

        assertTrue(animal1.isAt(vec1));
        assertEquals(animal1,map.objectAt(vec1));

        assertTrue(animal2.isAt(vec2));
        assertEquals(animal2,map.objectAt(vec2));

        assertTrue(animal3.isAt(vec3));
        assertEquals(animal3,map.objectAt(vec3));

        assertTrue(animal4.isAt(vec4));
        assertEquals(animal4,map.objectAt(vec4));

        //przód tył

        map.move(animal5,MoveDirection.FORWARD);
        assertTrue(animal5.isAt(new Vector2d(2,3)));
        assertEquals(animal5,map.objectAt(new Vector2d(2,3)));
        map.move(animal5,MoveDirection.BACKWARD);
        assertTrue(animal5.isAt(new Vector2d(2,2)));
        assertEquals(animal5,map.objectAt(new Vector2d(2,2)));
    }
}
