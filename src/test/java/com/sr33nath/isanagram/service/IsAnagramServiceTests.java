package com.sr33nath.isanagram.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

@SpringBootTest
public class IsAnagramServiceTests {

    @ParameterizedTest
    @MethodSource("validAnagramsArgs")
    void testValidAnagrams(String firstString, String secondString){
        IsAnagramServiceImpl isAnagramService = new IsAnagramServiceImpl();
        assertTrue(isAnagramService.check(firstString, secondString));
    }

    @ParameterizedTest
    @MethodSource("validAnagramsWithUnicodeEscapeCharSpaceArgs")
    void testValidAnagramsWithUnicodeEscapeSpaceChars(String firstString, String secondString){
        IsAnagramServiceImpl isAnagramService = new IsAnagramServiceImpl();
        assertTrue(isAnagramService.check(firstString, secondString));
    }

    @ParameterizedTest
    @MethodSource("invalidAnagramsArgs")
    void testInValidAnagrams(String firstString, String secondString){
        IsAnagramServiceImpl isAnagramService = new IsAnagramServiceImpl();
        assertFalse(isAnagramService.check(firstString, secondString));
    }

    @ParameterizedTest
    @MethodSource("emptyArgs")
    void testEmptyInput(String firstString, String secondString){
        IsAnagramServiceImpl isAnagramService = new IsAnagramServiceImpl();
        assertFalse(isAnagramService.check(firstString, secondString));
    }

    private static Stream<Arguments> validAnagramsArgs(){
        return Stream.of(
                Arguments.of("AAA", "AAA"),
                Arguments.of("ABA", "AAB")
        );
    }

    private static Stream<Arguments> invalidAnagramsArgs(){
        return Stream.of(
                Arguments.of("AAA", "ACA"),
                Arguments.of("ABA", "AbA")
        );
    }

    private static Stream<Arguments> emptyArgs(){
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of("", null),
                Arguments.of("", ""),
                Arguments.of(null, null)
        );
    }

    private static Stream<Arguments> validAnagramsWithUnicodeEscapeCharSpaceArgs(){
        return Stream.of(
                Arguments.of("\u0000\t\n\rabcg\uffff ", "\uffff \t\nab\rcg\u0000")
        );
    }

}
