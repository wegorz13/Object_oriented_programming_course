package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrassTest  {

    @Test
    void getPositionIsCorrect(){
        Grass grass = new Grass(new Vector2d(2,2));

        assertEquals(grass.getPosition(),new Vector2d(2,2));
    }
}
