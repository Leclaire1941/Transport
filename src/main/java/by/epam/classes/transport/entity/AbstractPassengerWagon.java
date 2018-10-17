package by.epam.classes.transport.entity;

public abstract class AbstractPassengerWagon extends AbstractWagon {
    private int peopleCapacity;

    /*package*/ AbstractPassengerWagon() {
    }

    /*package*/ AbstractPassengerWagon(String producerName, int year, int lengthInMeters, int peopleCapacity) {
        super(producerName, year, lengthInMeters);
        this.peopleCapacity = peopleCapacity;
    }

    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        AbstractPassengerWagon that = (AbstractPassengerWagon) o;
        return peopleCapacity == that.peopleCapacity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + peopleCapacity;
        return result;
    }

    @Override
    public String toString() {
        return "AbstractPassengerWagon{" +
                "producerName='" + getProducerName() + '\'' +
                ", year=" + getYear() +
                ", lengthInMeters=" + getLengthInMeters() +
                " peopleCapacity=" + peopleCapacity +
                '}';
    }
}
