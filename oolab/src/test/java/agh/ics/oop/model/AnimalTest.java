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


}
