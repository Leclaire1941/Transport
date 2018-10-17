package by.epam.classes.transport.builder;

import by.epam.classes.transport.entity.CargoWagon;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CargoWagonBuilderTest {
    private static final String CARGO_DATA_STRING = "Caterpillar, 2006, 20, 30";
    private static final CargoWagonBuilder CARGO_WAGON_BUILDER = new CargoWagonBuilder();

    @Test
    public void shouldReturnCargoWagonWithCorrectFields() {
        //given
        CargoWagon expectedWagon = new CargoWagon(
                "Caterpillar",
                2006,
                20,
                30);
        //when
        CargoWagon actualWagon = CARGO_WAGON_BUILDER.buildWagon(CARGO_DATA_STRING);
        //then
        Assert.assertEquals(expectedWagon, actualWagon);
    }
}