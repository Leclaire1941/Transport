package by.epam.classes.transport.entity;

public abstract class AbstractWagon {
    private String producerName;
    private int year;
    private int lengthInMeters;

    public AbstractWagon() {
    }

    public AbstractWagon(String producerName, int year, int lengthInMeters) {
        this.producerName = producerName;
        this.year = year;
        this.lengthInMeters = lengthInMeters;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLengthInMeters() {
        return lengthInMeters;
    }

    public void setLengthInMeters(int lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AbstractWagon that = (AbstractWagon) o;
        if (year != that.year)
            return false;
        if (lengthInMeters != that.lengthInMeters)
            return false;
        return producerName.equals(that.producerName);
    }

    @Override
    public int hashCode() {
        int result = producerName.hashCode();
        result = 31 * result + year;
        result = 31 * result + lengthInMeters;
        return result;
    }

    @Override
    public String toString() {
        return "AbstractWagon{" +
                "producerName='" + producerName + '\'' +
                ", year=" + year +
                ", lengthInMeters=" + lengthInMeters +
                '}';
    }
}
