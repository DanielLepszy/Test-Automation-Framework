package Readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public interface PropertyReader {

    default String readProperty(String property) {
        String fileName = "src/main/resources/configuration.properties";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        FileReader reader = null;
        Properties p = new Properties();
        try {
            reader = new FileReader(file);
            p.load(reader);

        } catch (IOException e){
            e.printStackTrace();
        }

        return p.getProperty(property);
    }
}
