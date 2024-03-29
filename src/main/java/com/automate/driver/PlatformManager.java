package com.automate.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlatformManager {

    private static ThreadLocal<String> platformName = new ThreadLocal<>();

    public static String getPlatformName() {
        return platformName.get();
    }

    public static void setPlatformName(String platform) {
        platformName.set(platform);
    }

    public static void unloadPlatformName() {
        platformName.remove();
    }
}
