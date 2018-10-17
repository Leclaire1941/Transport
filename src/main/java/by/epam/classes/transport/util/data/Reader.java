package by.epam.classes.transport.util.data;

import by.epam.classes.transport.exception.TransportDataException;
import by.epam.classes.transport.exception.TransportDataNotFoundException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static final Logger LOGGER = Logger.getLogger(Reader.class);

    public List<String> readFile(String path) throws TransportDataException {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Check file name.");
        }

        BufferedReader bufferedReader = null;
        List<String> dataList = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while (bufferedReader.ready()) {
                String lineFromFile = bufferedReader.readLine();
                dataList.add(lineFromFile);
            }

        } catch (FileNotFoundException e) {
            throw new TransportDataNotFoundException("Check file name " + path, e);
        } catch (IOException e) {
            throw new TransportDataException("Error while reading file " + path, e);

        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    LOGGER.error("Error instead of closing Reader.", e);
                }
            }
        }

        LOGGER.debug("Read process from " + path + " was successful.");
        return dataList;
    }

}
