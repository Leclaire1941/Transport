package by.epam.classes.transport.builder;

import by.epam.classes.transport.entity.CoachWagon;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoachWagonBuilderTest {

    private static final String COACH_DATA_STRING = "Siemens, 2004, 10, 30, true";
    private CoachWagonBuilder coachWagonBuilder = new CoachWagonBuilder();

    @Test
    public void shouldReturnCoachWagonWithCorrectFields() {
        //given
        CoachWagon expectedWagon = new CoachWagon(
                "Siemens",
                2004,
                10,
                30,
                true);
        //when
        CoachWagon actualWagon = coachWagonBuilder.buildWagon(COACH_DATA_STRING);
        //then
        Assert.assertEquals(expectedWagon, actualWagon);
    }
}