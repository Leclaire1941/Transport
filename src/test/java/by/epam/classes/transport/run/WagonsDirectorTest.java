package by.epam.classes.transport.run;

import by.epam.classes.transport.entity.AbstractWagon;
import by.epam.classes.transport.entity.CargoWagon;
import by.epam.classes.transport.entity.CoachWagon;
import by.epam.classes.transport.exception.TransportDataException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WagonsDirectorTest {
    private static final String VALID_PATH = "./src/test/resources/DataTest";
    private static final WagonsDirector WAGONS_DIRECTOR = new WagonsDirector();
    private List<AbstractWagon> expectedList = null;

    @BeforeClass
    public void setUp() {
        expectedList = new ArrayList<>();
        expectedList.add(new CoachWagon(
                "Siemens", 2004, 10, 30, true));
        expectedList.add(new CoachWagon(
                "Siemens", 2010, 15, 40, true));
        expectedList.add(new CargoWagon(
                "Caterpillar", 2006, 20, 30));
        expectedList.add(new CoachWagon(
                "Siemens", 1995, 5, 20, false));
        expectedList.add(new CargoWagon(
                "Caterpillar", 2009, 30, 50));
    }

    @AfterClass
    public void tearDown() {
        expectedList = null;
    }


    @Test
    public void shouldReturnCorrectListWithWagons() throws TransportDataException {
        //given - setUp(expectedList)
        //when
        List<AbstractWagon> actualList = WAGONS_DIRECTOR.createListOfWagons(VALID_PATH);
        //then
        Assert.assertEquals(expectedList, actualList);
    }
}