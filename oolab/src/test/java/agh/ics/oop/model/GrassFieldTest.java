package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    void objectAtIsCorrect(){
        GrassField field = new GrassField(0);

        Vector2d vec1 = new Vector2d(3,3);
        Animal animal1 = new Animal(vec1);
        field.place(animal1);

        assertEquals(animal1,field.objectAt(vec1));
        assertNull(field.objectAt(new Vector2d(2, 2)));
    }

    @Test
    void findSufficientCornersIsCorrect(){
        GrassField field = new GrassField(10);

        List<Vector2d> corners1 = field.findSufficientCorners();

        Vector2d vec1 = new Vector2d(110,110);
        Animal animal1 = new Animal(vec1);

        Vector2d vec2 = new Vector2d(-110,-110);
        Animal animal2 = new Animal(vec2);

        assertTrue(corners1.get(0).follows(new Vector2d(-10,-10)));
        assertTrue(corners1.get(1).precedes(new Vector2d(10,10)));

        field.place(animal1);
        field.place(animal2);

        List<Vector2d> corners2 = field.findSufficientCorners();
        List<Vector2d> correctCorners = List.of(vec2,vec1);

        assertEquals(corners2, correctCorners);
    }

    @Test
    void getElementsIsCorrect(){

        GrassField field = new GrassField(6);

        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(4,4));

        field.place(animal1);
        field.place(animal2);

        List<WorldElement> elements = field.getElements();

        assertEquals(8,elements.size());
        assertEquals(elements.get(0),animal1);
    }

    @Test
    void generateGrassPositionIsCorrect(){
        GrassField field = new GrassField(10);

        List<WorldElement> elements = field.getElements();
        List<Vector2d> corners = field.findSufficientCorners();

        Vector2d upperRight = new Vector2d((int)floor(sqrt(10*10)),(int)floor(sqrt(10*10)));
        Vector2d lowerLeft = new Vector2d(-(int)floor(sqrt(10*10)),-(int)floor(sqrt(10*10)));

        assertEquals(10,elements.size());
        assertTrue(corners.get(0).follows(lowerLeft));
        assertTrue(corners.get(1).precedes(upperRight));
    }
}
