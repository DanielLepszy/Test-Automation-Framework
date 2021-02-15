package UnitTests;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.remote.http.AddSeleniumUserAgent.USER_AGENT;


public class UnitTests {

    @Test
    public void testCollections() throws IOException {
        URL obj = new URL("http://192.168.0.105:4444/wd/hub");
        HttpURLConnection httpConnection = (HttpURLConnection) obj
                .openConnection();

        httpConnection.setRequestMethod("GET");

        httpConnection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {

            BufferedReader responseReader = new BufferedReader(new InputStreamReader(
                    httpConnection.getInputStream()));

            String responseLine;
            StringBuffer response = new StringBuffer();

            while ((responseLine = responseReader.readLine()) != null) {
                response.append(responseLine + "\n");
            }
            responseReader.close();

            // print result
            System.out.println(response.toString());
        }
        assertEquals(200,responseCode);
    }

}

