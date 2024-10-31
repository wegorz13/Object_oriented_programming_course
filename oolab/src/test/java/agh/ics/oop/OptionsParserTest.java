package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    void emptyList() {
        //given
        String[] array1 = {};

        //when
        MoveDirection[] directions1 = OptionsParser.convertDirections(array1);
        MoveDirection[] example = {MoveDirection.RIGHT};

        //then
        assertArrayEquals(new MoveDirection[0], directions1);
        assertFalse(Arrays.equals(example, directions1));
    }

    @Test
    void manyCorrectElements() {
        String[] array1 = {"f","b","l","r"};

        //when
        MoveDirection[] directions1 = OptionsParser.convertDirections(array1);

        //then
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.BACKWARD,MoveDirection.LEFT, MoveDirection.RIGHT};
        assertArrayEquals(expected, directions1);
    }

    @Test
    void correctElementsAndIncorrect() {
        String[] array1 = {"aa","f","b","l","cef","r","de"};

        //when
        MoveDirection[] directions1 = OptionsParser.convertDirections(array1);

        //then
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.BACKWARD,MoveDirection.LEFT, MoveDirection.RIGHT};
        assertArrayEquals(expected, directions1);
    }

}