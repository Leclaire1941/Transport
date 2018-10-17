package by.epam.classes.transport.run;

import by.epam.classes.transport.builder.BuildFactory;
import by.epam.classes.transport.builder.Builder;
import by.epam.classes.transport.entity.AbstractWagon;
import by.epam.classes.transport.entity.WagonType;
import by.epam.classes.transport.exception.TransportDataException;
import by.epam.classes.transport.util.data.Reader;
import by.epam.classes.transport.util.data.Validator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*package*/ class WagonsDirector {
    private final static Logger LOGGER = Logger.getLogger(WagonsDirector.class);
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_DATA = 1;
    private static final String SEPARATOR = ":\\s";
    private static final Reader READER = new Reader();
    private static final Validator VALIDATOR = new Validator();

    /*package*/ List<AbstractWagon> createListOfWagons(String filename) throws TransportDataException {
        List<String> dataList = READER.readFile(filename);
        List<AbstractWagon> wagonsToReturn = new ArrayList<>();

        for (String lineWithData : dataList) {
            if (VALIDATOR.isValid(lineWithData)) {

                String[] oneLineArray = lineWithData.split(SEPARATOR);
                List<String> separatedLine = Arrays.asList(oneLineArray);

                String type = separatedLine.get(INDEX_OF_TYPE);
                Enum wagonType = WagonType.valueOf(type);
                String classData = separatedLine.get(INDEX_OF_DATA);

                Builder builder = new BuildFactory().create((WagonType) wagonType);
                AbstractWagon wagon = builder.buildWagon(classData);
                wagonsToReturn.add(wagon);
            }
        }
        LOGGER.debug("Wagons were created successful. Wagons amount is - " + wagonsToReturn.size());
        return wagonsToReturn;
    }
}
