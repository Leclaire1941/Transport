package by.epam.classes.transport.util;

import by.epam.classes.transport.entity.AbstractWagon;
import by.epam.classes.transport.entity.Train;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;

public class Sorter {
    private final static Logger LOGGER = Logger.getLogger(Sorter.class);

    private class WagonYearComparator implements Comparator<AbstractWagon> {
        public int compare(AbstractWagon o1, AbstractWagon o2) {
            int firstWagonYear = o1.getYear();
            int secondWagonYear = o2.getYear();

            return firstWagonYear - secondWagonYear;
        }
    }

    private class WagonYearAndLengthComparator implements Comparator<AbstractWagon> {
        public int compare(AbstractWagon o1, AbstractWagon o2) {
            int firstWagonYear = o1.getYear();
            int secondWagonYear = o2.getYear();
            int firstWagonLength = o1.getLengthInMeters();
            int secondWagonLength = o2.getLengthInMeters();

            int yearComparingResult = firstWagonYear - secondWagonYear;
            if (yearComparingResult == 0) {
                return firstWagonLength - secondWagonLength;
            }

            return firstWagonYear - secondWagonYear;
        }
    }


    public Train sortWagonsByYear(Train train) {
        if (train == null) {
            throw new IllegalArgumentException("Train is null");
        }

        WagonYearComparator yearComparator = new WagonYearComparator();
        Collections.sort(train.getWagonList(), yearComparator);

        LOGGER.debug("Wagons in train were sorted");
        return train;
    }


    public Train sortWagonsByYearAndLength(Train train) {
        if (train == null) {
            throw new IllegalArgumentException("Train is null");
        }

        WagonYearAndLengthComparator yearAndLengthComparator = new WagonYearAndLengthComparator();
        Collections.sort(train.getWagonList(), yearAndLengthComparator);

        LOGGER.debug("Wagons in train were sorted");
        return train;
    }

}
