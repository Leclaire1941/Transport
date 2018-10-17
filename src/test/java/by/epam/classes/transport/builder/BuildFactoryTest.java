package by.epam.classes.transport.builder;

import by.epam.classes.transport.entity.WagonType;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BuildFactoryTest {
    private static final Enum CARGO_NAME = WagonType.CARGO;
    private static final Enum COACH_NAME = WagonType.PASSENGER;
    private static final BuildFactory BUILD_FACTORY = new BuildFactory();


    @Test
    public void shouldReturnCargoWagonBuilderWhenCreate() {
        //given
        Class expectedClass = CargoWagonBuilder.class;
        //when
        Class actualClass = BUILD_FACTORY.create((WagonType) CARGO_NAME).getClass();
        //then
        Assert.assertEquals(expectedClass, actualClass);
    }

    @Test
    public void shouldReturnCoachWagonBuilderWhenCreate() {
        //given
        Class expectedClass = CoachWagonBuilder.class;
        //when
        Class actualClass = BUILD_FACTORY.create((WagonType) COACH_NAME).getClass();
        //then
        Assert.assertEquals(expectedClass, actualClass);
    }
}