package by.epam.classes.transport.entity;

import java.util.List;

public class Train {
    private List<AbstractWagon> wagonList;

    public Train(List<AbstractWagon> wagonList) {
        this.wagonList = wagonList;
    }

    public List<AbstractWagon> getWagonList() {
        return wagonList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Train train = (Train) o;
        return wagonList.equals(train.wagonList);
    }

    @Override
    public int hashCode() {
        return wagonList.hashCode();
    }

    @Override
    public String toString() {
        return "Train{" +
                "wagonList=" + wagonList +
                '}';
    }
}
