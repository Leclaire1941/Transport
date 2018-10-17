package by.epam.classes.transport.builder;

import by.epam.classes.transport.entity.CoachWagon;

public class CoachWagonBuilder extends Builder {
    private static final int PEOPLE_CAPACITY_INDEX = 3;
    private static final int WIFI_INDEX = 4;

    @Override
    public CoachWagon buildWagon(String dataLine) {
        CoachWagon coachWagon = new CoachWagon();
        fillCommonFields(coachWagon, dataLine);

        String[] data = dataLine.split(Builder.SEPARATOR);
        int peopleCapacity = Integer.parseInt(data[PEOPLE_CAPACITY_INDEX]);
        coachWagon.setPeopleCapacity(peopleCapacity);

        boolean hasWiFi = Boolean.parseBoolean(data[WIFI_INDEX]);
        coachWagon.setHasWiFi(hasWiFi);

        return coachWagon;
    }
}
