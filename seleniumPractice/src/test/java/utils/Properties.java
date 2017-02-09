package utils;

/**
 * Created by karthik on 9/2/17.
 */
public class Properties {
    private static final PropertiesReader propertiesReader = new PropertiesReader();

    public static final String url = propertiesReader.getUrl();
}
