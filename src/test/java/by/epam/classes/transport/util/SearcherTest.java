package by.epam.classes.transport.util;

import by.epam.classes.transport.entity.AbstractWagon;
import by.epam.classes.transport.entity.CargoWagon;
import by.epam.classes.transport.entity.CoachWagon;
import by.epam.classes.transport.entity.Train;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearcherTest {
    private static final Searcher SEARCHER = new Searcher();
    private static final int PASSENGERS = 40;
    private static final String PRODUCER_NAME = "Siemens";
    private static final int YEAR = 2000;
    private List<AbstractWagon> expectedSiemensWagons = null;
    private List<AbstractWagon> expectedFortyPassengerWagons = null;
    private Train train = null;


    @BeforeClass
    public void setUp() {
        List<AbstractWagon> listToCreateTrain = new ArrayList<>();
        listToCreateTrain.add(new CoachWagon(
                "Siemens", 2010, 15, 40, true));
        listToCreateTrain.add(new CargoWagon(
                "Caterpillar", 2009, 30, 50));
        listToCreateTrain.add(new CargoWagon(
                "Caterpillar", 2006, 20, 30));
        listToCreateTrain.add(new CoachWagon(
                "Siemens", 2004, 10, 30, true));
        listToCreateTrain.add(new CoachWagon(
                "Siemens", 1995, 5, 20, false)
        );
        train = new Train(listToCreateTrain);

        expectedSiemensWagons = new ArrayList<>();
        expectedSiemensWagons.add(new CoachWagon(
                "Siemens", 2010, 15, 40, true));
        expectedSiemensWagons.add(new CoachWagon(
                "Siemens", 2004, 10, 30, true)
        );

        expectedFortyPassengerWagons = new ArrayList<>();
        expectedFortyPassengerWagons.add(new CoachWagon(
                "Siemens", 2010, 15, 40, true)
        );
    }

    @AfterClass
    public void tearDown() {
        train = null;
        expectedSiemensWagons = null;
        expectedFortyPassengerWagons = null;
    }


    @Test
    public void shouldReturnListWithSiemensWagonsAndYearMoreThan2000() {
        //given - setUp(train) & setUp(expectedSiemensWagons)
        //when
        List<AbstractWagon> actualSiemensList =
                SEARCHER.identifyWagonsWithCertainProducerAndYearAbove(train, PRODUCER_NAME, YEAR);
        //then
        Assert.assertEquals(expectedSiemensWagons, actualSiemensList);
    }

    @Test
    public void shouldReturnFortyPassengersWagons() {
        //given - setUp(train) & setUp(expectedFortyPassengerWagons)
        //when
        List<AbstractWagon> actualFortyPassengerWagons =
                SEARCHER.identifyWagonsWithCertainPassengers(train, PASSENGERS);
        //then
        Assert.assertEquals(expectedFortyPassengerWagons, actualFortyPassengerWagons);
    }


}