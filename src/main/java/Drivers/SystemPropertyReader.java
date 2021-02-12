package Drivers;

import org.openqa.selenium.Platform;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public interface SystemPropertyReader {

    default String readProperty(String property) throws IOException {
        String fileName = "browser.properties";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        FileReader reader = new FileReader(file);
        Properties p = new Properties();
        p.load(reader);

        return p.getProperty(property);
    }

    default Browser chosenBrowser() throws IOException {
        String browserType = readProperty("BROWSER").toUpperCase();
        List<Browser> browsers = Arrays.asList(Browser.values());
        return browsers.stream()
                .filter(browser -> browser.name().toUpperCase(Locale.ROOT).equals(browserType)).collect(Collectors.toList()).get(0);
    }

    default String getBrowserVersionFromSystem() throws IOException {
        return readProperty("VERSION").toUpperCase();
    }

    default RunningTypes chosenRunningProcess() throws IOException {
        String runningType = readProperty("RUNNING_TYPE").toUpperCase();
        List<RunningTypes> types = Arrays.asList(RunningTypes.values());
        return types.stream().filter(type -> type.name().toUpperCase().equals(runningType)).collect(Collectors.toList()).get(0);
    }

    default Platform getPlatformFromSystem() throws IOException {
        String chosenPlatform = readProperty("PLATFORM").toUpperCase();
        if (chosenPlatform.equals("")) return Platform.WINDOWS;
        else {
            List<Platform> platforms = Arrays.asList(Platform.values());
            return platforms.stream()
                    .filter(platform -> platform.name().toUpperCase().equals(chosenPlatform)).collect(Collectors.toList()).get(0);
        }
    }
}
