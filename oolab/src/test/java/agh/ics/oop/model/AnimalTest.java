package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    void toStringIsCorrect() {
        //given
        Animal animal1 = new Animal(new Vector2d(1,1));
        Animal animal2 = new Animal();

        //then
        assertEquals("current_direction=NORTH, position=(1,1)" , animal1.toString());
        assertEquals("current_direction=NORTH, position=(2,2)" , animal2.toString());
    }

    @Test
    void isAtIsCorrect(){
        Animal animal1 = new Animal(new Vector2d(1,1));
        Animal animal2 = new Animal();

        assertTrue(animal1.isAt(new Vector2d(1,1)));
        assertTrue(animal2.isAt(new Vector2d(2,2)));
        assertFalse(animal2.isAt(null));
    }

//    @Test
//    void moveIsCorrect(){
//        Vector2d vec_1 = new Vector2d(1,4);
//        Vector2d vec_2 = new Vector2d(4,1);
//        Vector2d vec_3 = new Vector2d(0,1);
//        Vector2d vec_4 = new Vector2d(1,0);
//
//        Animal animal1 = new Animal(vec_1);
//        Animal animal2 = new Animal(vec_2);
//        Animal animal3 = new Animal(vec_3);
//        Animal animal4 = new Animal(vec_4);
//        Animal animal5 = new Animal();
//
//        //kierunki
//
//        //w prawo/ wschód
//        animal2.move(MoveDirection.RIGHT);
//        //w lewo/ zachód
//        animal3.move(MoveDirection.LEFT);
//        //w dol/ południe
//        animal4.move(MoveDirection.RIGHT);
//        animal4.move(MoveDirection.RIGHT);
//
//        assertEquals(animal2.getDirection(),MapDirection.EAST);
//        assertEquals(animal3.getDirection(),MapDirection.WEST);
//        assertEquals(animal4.getDirection(),MapDirection.SOUTH);
//
//        //krawedzie
//
//        //górna
//        animal1.move(MoveDirection.FORWARD);
//        //prawa
//        animal2.move(MoveDirection.FORWARD);
//        //lewa
//        animal3.move(MoveDirection.FORWARD);
//        //dolna
//        animal4.move(MoveDirection.FORWARD);
//
//        assertTrue(animal1.isAt(vec_1));
//        assertTrue(animal2.isAt(vec_2));
//        assertTrue(animal3.isAt(vec_3));
//        assertTrue(animal4.isAt(vec_4));
//
//        //przód tył
//
//        animal5.move(MoveDirection.FORWARD);
//        assertTrue(animal5.isAt(new Vector2d(2,3)));
//        animal5.move(MoveDirection.BACKWARD);
//        assertTrue(animal5.isAt(new Vector2d(2,2)));
//
//    }

}
