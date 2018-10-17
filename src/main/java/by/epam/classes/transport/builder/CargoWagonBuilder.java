package by.epam.classes.transport.builder;

import by.epam.classes.transport.entity.CargoWagon;

public class CargoWagonBuilder extends Builder {
    private static final int BAGGAGE_CAPACITY_INDEX = 3;

    @Override
    public CargoWagon buildWagon(String dataLine) {
        CargoWagon cargoWagon = new CargoWagon();
        fillCommonFields(cargoWagon, dataLine);

        String[] data = dataLine.split(Builder.SEPARATOR);
        int baggageCapacity = Integer.parseInt(data[BAGGAGE_CAPACITY_INDEX]);
        cargoWagon.setBaggageCapacity(baggageCapacity);

        return cargoWagon;
    }
}
