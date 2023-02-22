package com.parsly.configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties prop = new Properties();
    private static InputStream input = null;
    private static String pathProperties = "config.properties";

    private static void loadProperties() {
        try {
            input = new FileInputStream( pathProperties );
            prop.load( input );
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }

    public static String getProperty( String key ) {
        if( prop.size() == 0 )
            loadProperties();
        if( !prop.containsKey( key ) ) {
            throw new RuntimeException("There is no key [ " + key + " ] in properties file: " + pathProperties);
        }
        return prop.getProperty( key );
    }

}
