package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void emptyList() {
        //given
        String[] array1 = {};

        //when
        List<MoveDirection> directions1 = OptionsParser.convertDirections(array1);
        List<MoveDirection> example = new ArrayList<MoveDirection>() {{add(MoveDirection.RIGHT);}};
        List<MoveDirection> empty = new ArrayList<MoveDirection>();

        //then
        assertEquals(empty, directions1);
        assertNotEquals(example,directions1);
    }

    @Test
    void manyCorrectElements() {
        String[] array1 = {"f","b","l","r"};

        //when
        List<MoveDirection> directions1 = OptionsParser.convertDirections(array1);

        //then
        List<MoveDirection> expected = new ArrayList<MoveDirection>() {{add(MoveDirection.FORWARD); add(MoveDirection.BACKWARD); add(MoveDirection.LEFT); add(MoveDirection.RIGHT);}};
        assertEquals(expected, directions1);
    }

    @Test
    void correctElementsAndIncorrect() {
        String[] array1 = {"aa","f","b","l","cef","r","de"};

        //when
        List<MoveDirection> directions1 = OptionsParser.convertDirections(array1);

        //then
        List<MoveDirection> expected = new ArrayList<MoveDirection>(){{add(MoveDirection.FORWARD); add(MoveDirection.BACKWARD); add(MoveDirection.LEFT); add(MoveDirection.RIGHT);}};
        assertEquals(expected, directions1);
    }

}