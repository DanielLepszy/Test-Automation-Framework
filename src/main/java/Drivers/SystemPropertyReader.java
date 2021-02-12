package Drivers;

import Readers.PropertyReader;
import org.openqa.selenium.Platform;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public interface SystemPropertyReader extends PropertyReader {

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
