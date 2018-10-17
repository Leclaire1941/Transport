package by.epam.classes.transport.util;

import by.epam.classes.transport.entity.AbstractWagon;
import by.epam.classes.transport.entity.CargoWagon;
import by.epam.classes.transport.entity.CoachWagon;
import by.epam.classes.transport.entity.Train;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final static Logger LOGGER = Logger.getLogger(Calculator.class);

    /*package*/ List<CoachWagon> defineCoachWagonsList(Train train) {
        List<CoachWagon> coachWagons = new ArrayList<>();

        for (AbstractWagon wagon : train.getWagonList()) {
            if (wagon.getClass() == CoachWagon.class) {
                coachWagons.add((CoachWagon) wagon);
            }
        }
        return coachWagons;
    }

    private List<CargoWagon> defineCargoWagonsList(Train train) {
        List<CargoWagon> cargoWagons = new ArrayList<>();

        for (AbstractWagon wagon : train.getWagonList()) {
            if (wagon.getClass() == CargoWagon.class) {
                cargoWagons.add((CargoWagon) wagon);
            }
        }
        return cargoWagons;
    }


    public int calculatePassengersAmount(Train train) {
        if (train == null) {
            throw new IllegalArgumentException("Train is null");
        }

        List<CoachWagon> coachWagons = defineCoachWagonsList(train);
        int passengerAmount = 0;
        for (CoachWagon wagon : coachWagons) {
            passengerAmount += wagon.getPeopleCapacity();
        }
        LOGGER.debug("Passenger amount calculated - " + passengerAmount);
        return passengerAmount;
    }


    public int calculateBaggageAmount(Train train) {
        if (train == null) {
            throw new IllegalArgumentException("Train is null");
        }

        List<CargoWagon> cargoWagons = defineCargoWagonsList(train);
        int baggageAmount = 0;
        for (CargoWagon wagon : cargoWagons) {
            baggageAmount += wagon.getBaggageCapacity();
        }
        LOGGER.debug("Baggage amount calculated - " + baggageAmount);
        return baggageAmount;
    }

}
