package by.epam.classes.transport.util;

import by.epam.classes.transport.exception.TransportDataException;
import by.epam.classes.transport.exception.TransportDataNotFoundException;
import by.epam.classes.transport.util.data.Reader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ReaderTest {
    private static final String VALID_PATH = "./src/test/resources/DataTest";
    private static final String INVALID_PATH = "./src/test/resources/Fake";
    private static final String NULL_PATH = null;
    private static final Reader reader = new Reader();
    private static final List<String> EXPECTED_LIST = Arrays.asList(
            "PASSENGER: Siemens, 2004, 10, 30, true",
            "HelloWorld: strange situation",
            "PASSENGER: Siemens, 2010, 15, 40, true",
            "CARGO: Caterpillar, 2006, 20, 30",
            "PASSENGER: Siemens, 1995, 5, 20, false",
            "CARGO: Caterpillar, 2009, 30, 50"
    );


    @Test
    public void shouldReturnCorrectListWhenRead() throws TransportDataException {
        //given - constant EXPECTED_LIST
        //when
        List<String> actualList = reader.readFile(VALID_PATH);
        //then
        Assert.assertEquals(EXPECTED_LIST, actualList);
    }

    @Test(expectedExceptions = TransportDataNotFoundException.class)
    public void shouldThrowTransportDataNotFoundExceptionOnInvalidPath() throws TransportDataException {
        //given - constant INVALID_PATH
        //should throw Exception
        reader.readFile(INVALID_PATH);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnInvalidPath() throws TransportDataException {
        //given - constant NULL_PATH
        //should throw Exception
        reader.readFile(NULL_PATH);
    }

}