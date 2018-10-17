package by.epam.classes.transport.util;

import by.epam.classes.transport.util.data.Validator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorTest {
    private static final Validator validator = new Validator();

    @DataProvider
    public static Object[][] validData() {
        String correctLineOne = "PASSENGER: Siemens, 2004, 10, 30, true";
        String correctLineTwo = "PASSENGER: MinskKristal, 2015, 23, 506, false";
        String correctLineThree = "CARGO: MTZ, 2017, 200, 35";
        String correctLineFour = "CARGO: Caterpillar, 2006, 20, 30";

        return new Object[][]{
                {correctLineOne, true},
                {correctLineTwo, true},
                {correctLineThree, true},
                {correctLineFour, true},

        };
    }

    @DataProvider
    public static Object[][] notValidData() {
        String incorrectLineOne = "777PASSENGER: Siemens, 2004, 10, 30, true";
        String incorrectLineTwo = "PASSENGER: Siemens, MISTAKE, 10, 30, true";
        String incorrectLineThree = "HEAD: Siemens, 2004, 10, 30, true";
        String incorrectLineFour = "PASSENGER: Siemens, 2004, Hello_world, 30, true";

        return new Object[][]{
                {incorrectLineOne, false},
                {incorrectLineTwo, false},
                {incorrectLineThree, false},
                {incorrectLineFour, false},
        };
    }


    @Test(dataProvider = "validData")
    public void shouldReturnTrueWhenIsValid(String value, boolean expectedResult) {
        //given - dataProvider = "validData"
        //when
        boolean actualResult = validator.isValid(value);
        //then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(dataProvider = "notValidData")
    public void shouldReturnFalseWhenIsNotValid(String value, boolean expectedResult) {
        //given - dataProvider = "notValidData"
        //when
        boolean actualResult = validator.isValid(value);
        //then
        Assert.assertEquals(expectedResult, actualResult);
    }

}