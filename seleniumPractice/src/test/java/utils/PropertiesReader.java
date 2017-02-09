package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.Properties;

/**
 * Created by karthik on 9/2/17.
 */
public class PropertiesReader {

    private java.util.Properties prop = new Properties();

    public PropertiesReader() {
        try {
            String env = System.getProperty("env");
            System.out.println("ENV: " + env);

            if (null == env) env = "local";

            String propertiesFilePath = env + ".properties";
            InputStream inputStream;
            inputStream = getInputStream(propertiesFilePath);
            prop.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream getInputStream(String propertiesFilePath) {
        return this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
    }


    public String getUrl() {
        return prop.getProperty("url");
    }
}
