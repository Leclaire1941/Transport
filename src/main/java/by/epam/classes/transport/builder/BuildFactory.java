package by.epam.classes.transport.builder;

import by.epam.classes.transport.entity.WagonType;

public class BuildFactory {

    public Builder create(WagonType wagonType) {
        Builder builder;
        switch (wagonType) {
            case CARGO:
                builder = new CargoWagonBuilder();
                break;
            case PASSENGER:
                builder = new CoachWagonBuilder();
                break;
            default:
                throw new IllegalArgumentException("unknown type: " + wagonType);
        }
        return builder;
    }

}
