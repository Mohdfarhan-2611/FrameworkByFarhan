package org.example.Utils;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertiesReader {

    private PropertiesReader(){}
    private static Properties properties = new Properties();
    private static final String PROPERTYREADERPATH = System.getProperty("user.dir")+"/src/test/resources/data.properties";
    private static final Map<String, String> propertyreadermap = new HashMap<>();


    static {

        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTYREADERPATH);
            properties.load(fileInputStream);
            for (Map.Entry<Object, Object> entry : properties.entrySet())
            {
                propertyreadermap.put(String.valueOf(entry.getKey()).toLowerCase(), String.valueOf(entry.getValue()).trim());
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public static String readKey(String key) throws Exception {
      if(Objects.isNull(key) || Objects.isNull(propertyreadermap.get(key.toLowerCase())))
      {
          throw new Exception("Property name "+key+" is not found in PropertyReader");
      }

      return propertyreadermap.get(key.toLowerCase());

    }

}
