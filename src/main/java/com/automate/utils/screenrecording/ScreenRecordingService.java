package com.automate.utils.screenrecording;

import com.automate.enums.ConfigProperties;
import com.automate.utils.configloader.PropertyUtils;

import java.io.IOException;

public final class ScreenRecordingService {

    private ScreenRecordingService() {
    }

    public static void startRecording() throws IOException {
        if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
            ScreenRecordingUtils.startScreenRecording();
        }
    }

    public static void stopRecording(String methodName) throws IOException {
        if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
            ScreenRecordingUtils.stopScreenRecording(methodName);
        }

    }
}