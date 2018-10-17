package by.epam.classes.transport.entity;

public class CoachWagon extends AbstractPassengerWagon {
    private boolean hasWiFi;

    public CoachWagon() {
    }

    public CoachWagon(String producerName, int year, int lengthInMeters, int peopleCapacity, boolean hasWiFi) {
        super(producerName, year, lengthInMeters, peopleCapacity);
        this.hasWiFi = hasWiFi;
    }

    public boolean isHasWiFi() {
        return hasWiFi;
    }

    public void setHasWiFi(boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        CoachWagon that = (CoachWagon) o;
        return hasWiFi == that.hasWiFi;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (hasWiFi ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CoachWagon{" +
                "producerName='" + getProducerName() + '\'' +
                ", year=" + getYear() +
                ", lengthInMeters=" + getLengthInMeters() +
                " peopleCapacity=" + getPeopleCapacity() +
                " hasWiFi=" + hasWiFi +
                '}';
    }
}
