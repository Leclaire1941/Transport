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

public class CalculatorTest {
    private static final int EXPECTED_PASSENGER_AMOUNT = 90;
    private static final int EXPECTED_BAGGAGE_AMOUNT = 80;
    private static final Calculator CALCULATOR = new Calculator();
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
    }

    @AfterClass
    public void tearDown() {
        train = null;
    }


    @Test
    public void shouldReturnPassengersAmount() {
        //given - setUp(train) & constant EXPECTED_PASSENGER_AMOUNT
        //when
        int actualPassengerAmount = CALCULATOR.calculatePassengersAmount(train);
        //then
        Assert.assertEquals(EXPECTED_PASSENGER_AMOUNT, actualPassengerAmount);
    }

    @Test
    public void shouldReturnBaggageAmount() {
        //given - setUp(train) & constant EXPECTED_BAGGAGE_AMOUNT
        //when
        int actualBaggageAmount = CALCULATOR.calculateBaggageAmount(train);
        //then
        Assert.assertEquals(EXPECTED_BAGGAGE_AMOUNT, actualBaggageAmount);
    }


}