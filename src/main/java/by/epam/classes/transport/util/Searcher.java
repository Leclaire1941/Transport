package by.epam.classes.transport.util;

import by.epam.classes.transport.entity.AbstractWagon;
import by.epam.classes.transport.entity.CoachWagon;
import by.epam.classes.transport.entity.Train;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Searcher {
    private static final Calculator CALCULATOR = new Calculator();
    private static final Logger LOGGER = Logger.getLogger(Searcher.class);

    public List<AbstractWagon> identifyWagonsWithCertainPassengers(Train train, int passengers) {
        if (train == null) {
            throw new IllegalArgumentException("Train is null");
        }
        List<AbstractWagon> WagonsWithCertainPassengers = new ArrayList<>();

        List<CoachWagon> coachWagons = CALCULATOR.defineCoachWagonsList(train);
        for (CoachWagon wagon : coachWagons) {
            int peopleCapacity = wagon.getPeopleCapacity();
            if (peopleCapacity == passengers) {
                WagonsWithCertainPassengers.add(wagon);
            }
        }
        LOGGER.debug("List was found successfully - " + WagonsWithCertainPassengers);
        return WagonsWithCertainPassengers;
    }

    public List<AbstractWagon> identifyWagonsWithCertainProducerAndYearAbove(
            Train train, String producerName, int year) {

        if (train == null) {
            throw new IllegalArgumentException("Train is null");
        }
        List<AbstractWagon> WagonsWithCertainProducerAndYear = new ArrayList<>();

        for (AbstractWagon wagon : train.getWagonList()) {
            int wagonYear = wagon.getYear();
            String wagonProducerName = wagon.getProducerName();

            if (wagonProducerName.equals(producerName) && wagonYear > year) {
                WagonsWithCertainProducerAndYear.add(wagon);
            }
        }
        LOGGER.debug("List was found successfully - " + WagonsWithCertainProducerAndYear);
        return WagonsWithCertainProducerAndYear;
    }

}
