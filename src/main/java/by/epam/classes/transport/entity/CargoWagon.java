package by.epam.classes.transport.entity;

public class CargoWagon extends AbstractWagon {
    private int baggageCapacity;
    public static int i = 5;

    public CargoWagon() {
    }

    public CargoWagon(String producerName, int year, int lengthInMeters, int baggageCapacity) {
        super(producerName, year, lengthInMeters);
        this.baggageCapacity = baggageCapacity;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }

    public void setBaggageCapacity(int baggageCapacity) {
        this.baggageCapacity = baggageCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        CargoWagon that = (CargoWagon) o;
        return baggageCapacity == that.baggageCapacity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + baggageCapacity;
        return result;
    }

    @Override
    public String toString() {
        return "CargoWagon{" +
                "producerName='" + getProducerName() + '\'' +
                ", year=" + getYear() +
                ", lengthInMeters=" + getLengthInMeters() +
                " baggageCapacity=" + baggageCapacity +
                '}';
    }
}
