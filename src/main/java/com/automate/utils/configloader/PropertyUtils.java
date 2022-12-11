package com.automate.utils.configloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.automate.constants.FrameworkConstants;
import com.automate.enums.ConfigProperties;

public final class PropertyUtils {

    private PropertyUtils() {
    }

    private static final Properties property = new Properties();

    static void loadProperties(String propertyFilePath) throws IOException {
     FileInputStream input = new FileInputStream(propertyFilePath);
            property.load(input);

    }

    public static String getPropertyValue(ConfigProperties key) throws IOException {
        loadProperties(FrameworkConstants.getConfigPropertiesPath());
        if (Objects.isNull(property.getProperty(key.name().toLowerCase())) || Objects.isNull(key.name().toLowerCase())) {

        }
        return property.getProperty(key.name().toLowerCase());
    }
}
