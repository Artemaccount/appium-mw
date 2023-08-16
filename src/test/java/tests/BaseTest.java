package tests;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lib.Platform;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.HashMap;

public class BaseTest {
    protected RemoteWebDriver driver;
    private static AppiumDriverLocalService service;

    @BeforeAll
    public static void setItUp() {
        startServer();
        if (service == null || !service.isRunning()) {
            throw new RuntimeException("An appium server node is not started!");
        }
    }

    @AfterAll
    public static void stopAppium() {
        stopServer();
    }

    public static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        HashMap<String, String> environment = new HashMap();
        //environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "/Users/user/Library/Android/sdk");

        builder
                .withEnvironment(environment)
                .withAppiumJS(new File("/usr/local/bin/appium"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("AppiumLog.txt"));

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public static void stopServer() {
        service.stop();
    }


    @BeforeEach
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
