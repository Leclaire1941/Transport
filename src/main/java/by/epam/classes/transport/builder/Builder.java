package by.epam.classes.transport.builder;

import by.epam.classes.transport.entity.AbstractWagon;

public abstract class Builder {
    /*package*/ static final String SEPARATOR = ",\\s";
    private static final int PRODUCER_NAME_INDEX = 0;
    private static final int YEAR_INDEX = 1;
    private static final int LENGTH_INDEX = 2;

    /*package*/ void fillCommonFields(AbstractWagon wagon, String dataLine) {
        String[] data = dataLine.split(SEPARATOR);

        String producerName = data[PRODUCER_NAME_INDEX];
        wagon.setProducerName(producerName);

        int productionDate = Integer.parseInt(data[YEAR_INDEX]);
        wagon.setYear(productionDate);

        int lengthInMeters = Integer.parseInt(data[LENGTH_INDEX]);
        wagon.setLengthInMeters(lengthInMeters);
    }

    public abstract AbstractWagon buildWagon(String type);
}
