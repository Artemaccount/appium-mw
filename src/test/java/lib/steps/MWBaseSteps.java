package lib.steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class MWBaseSteps extends BaseSteps {

    public MWBaseSteps(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    public void swipeElementToLeft(WebElement element) {

    }
}
