package by.epam.classes.transport.util;

import by.epam.classes.transport.entity.AbstractWagon;
import by.epam.classes.transport.entity.CargoWagon;
import by.epam.classes.transport.entity.CoachWagon;
import by.epam.classes.transport.entity.Train;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SorterTest {
    private static final Sorter SORTER = new Sorter();
    private Train trainToSort = null;
    private Train expectedTrainSortedByYear = null;
    private Train expectedTrainSortedByYearAndLength = null;


    @BeforeClass
    public void setUp() {
        List<AbstractWagon> wagonListForTrainToSort = Arrays.asList(
                new CoachWagon(
                        "Siemens", 2000, 16, 20, true),
                new CargoWagon(
                        "Caterpillar", 2004, 20, 50),
                new CoachWagon(
                        "Siemens", 2010, 10, 30, true),
                new CoachWagon(
                        "Siemens", 2000, 15, 30, true)

        );
        trainToSort = new Train(wagonListForTrainToSort);

        List<AbstractWagon> wagonListForExpectedTrainSortedByYear = Arrays.asList(
                new CoachWagon(
                        "Siemens", 2000, 16, 20, true),
                new CoachWagon(
                        "Siemens", 2000, 15, 30, true),
                new CargoWagon(
                        "Caterpillar", 2004, 20, 50),
                new CoachWagon(
                        "Siemens", 2010, 10, 30, true)
        );
        expectedTrainSortedByYear = new Train(wagonListForExpectedTrainSortedByYear);

        List<AbstractWagon> wagonListForExpectedTrainSortedByYearAndLength = Arrays.asList(
                new CoachWagon(
                        "Siemens", 2000, 15, 30, true),
                new CoachWagon(
                        "Siemens", 2000, 16, 20, true),
                new CargoWagon(
                        "Caterpillar", 2004, 20, 50),
                new CoachWagon(
                        "Siemens", 2010, 10, 30, true)
        );
        expectedTrainSortedByYearAndLength = new Train(wagonListForExpectedTrainSortedByYearAndLength);
    }

    @AfterClass
    public void tearDown() {
        trainToSort = null;
        expectedTrainSortedByYear = null;
        expectedTrainSortedByYearAndLength = null;
    }


    @Test
    public void shouldSortWagonsByYear() {
        //given - trainToSort & expectedTrainSortedByYear
        //when
        Train actualTrain = SORTER.sortWagonsByYear(trainToSort);
        //then
        Assert.assertEquals(expectedTrainSortedByYear, actualTrain);
    }

    @Test
    public void testSortWagonsByYearAndLength() {
        //given - trainToSort & expectedTrainSortedByYear
        //when
        Train actualTrain = SORTER.sortWagonsByYearAndLength(trainToSort);
        //then
        Assert.assertEquals(expectedTrainSortedByYearAndLength, actualTrain);
    }
}