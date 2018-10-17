package by.epam.classes.transport.util.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String PATTERN =
            "((PASSENGER|CARGO)[:])*\\s*" +
                    "[a-zA-Z]*[,]\\s*" +
                    "(\\d+[,]*\\s*)+" +
                    "(true|false)*";


    public boolean isValid(String lineToCheck) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(lineToCheck);
        return matcher.matches();
    }
}
