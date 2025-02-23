package org.example.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private static String QKART_STAGING_PATH = System.getProperty("user.dir")+"/src/test/resources/QKart_Staging.Properties";

    static  FileInputStream fileInputStream = null;
    static  Properties properties = null;

    public static String readkey(String key) {

        try {
            fileInputStream = new FileInputStream(QKART_STAGING_PATH);
            properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(key);
        }
            catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
