package utils;
import base.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    public class ConfigReader extends BaseClass {
        public static String getProperty(String key) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("config.properties");
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Error while reading config.properties file", e);
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return properties.getProperty(key);
        }
    }

