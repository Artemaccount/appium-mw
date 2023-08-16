package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String DRIVER_URL = "http://127.0.0.1:4723";
    private static final String ANDROID_PLATFORM_NAME = "android";
    private static final String IOS_PLATFORM_NAME = "iOS";
    private static final String MW_PLATFORM_NAME = "mobile_web";

    private Platform() {
    }

    private static Platform platform;

    public static Platform getInstance() {
        if (platform == null) {
            platform = new Platform();
        }
        return platform;
    }

    public boolean isAndroid() {
        return System.getenv("platformName").equals(ANDROID_PLATFORM_NAME);
    }

    public boolean isIOS() {
        return System.getenv("platformName").equals(IOS_PLATFORM_NAME);
    }
    public boolean isMW() {
        return System.getenv("platformName").equals(MW_PLATFORM_NAME);
    }

    public RemoteWebDriver getDriver() throws MalformedURLException {
        String platformName = System.getenv("platformName");
        switch (platformName) {
            case ANDROID_PLATFORM_NAME:
                DesiredCapabilities androidCaps = new DesiredCapabilities();
                androidCaps.setCapability("deviceOrientation", "portrait");
                androidCaps.setCapability("platformName", "android");
                androidCaps.setCapability("deviceName", "AndroidTestDevice");
                androidCaps.setCapability("avd", "andem");
                androidCaps.setCapability("platformVersion", "14");
                androidCaps.setCapability("automationName", "UiAutomator2");
                androidCaps.setCapability("appPackage", "org.wikipedia");
                androidCaps.setCapability("appActivity", ".main.MainActivity");
                androidCaps.setCapability("app", "/Users/user/Desktop/java/appiumAuto/apks/wikipedia.apk");
                return new AndroidDriver(new URL(DRIVER_URL), androidCaps);
            case IOS_PLATFORM_NAME:
                DesiredCapabilities iosCaps = new DesiredCapabilities();
                iosCaps.setCapability("deviceOrientation", "portrait");
                iosCaps.setCapability("platformName", "iOS");
                iosCaps.setCapability("deviceName", "iPhone 12");
                iosCaps.setCapability("platformVersion", "14.3");
                iosCaps.setCapability("automationName", "XCUITest");
                iosCaps.setCapability("app", "/Users/user/Desktop/java/appiumAuto/apks/wikipedia.app");
                return new IOSDriver(new URL(DRIVER_URL), iosCaps);
            case MW_PLATFORM_NAME:
                Map<String, Object> deviceMetrics = new HashMap<>();
                deviceMetrics.put("width", 360);
                deviceMetrics.put("height", 640);
                deviceMetrics.put("pixelRatio", 3.0);

                Map<String, Object> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", deviceMetrics);
                mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

                return new ChromeDriver(chromeOptions);
            default:
                throw new RuntimeException("unknown platform name " + platformName);
        }
    }


}
