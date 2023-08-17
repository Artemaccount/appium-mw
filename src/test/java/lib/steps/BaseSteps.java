package lib.steps;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BaseSteps {

    protected final RemoteWebDriver driver;

    public BaseSteps(RemoteWebDriver driver) {
        this.driver = driver;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    protected void waitForElementDisappeared(String locator) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected WebElement waitForElementVisibility(String locator) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitForElementVisibilityIOS(String locator) {
        By by = getLocatorByString(locator);
        int maxTry = 10;
        boolean exists = false;
        for (int i = 0; i < maxTry; i++) {
            exists = !driver.findElements(by).isEmpty();
            if (exists) {
                break;
            } else {
                waitForSeconds(1);
            }
        }
        if (!exists) {
            throw new RuntimeException(String.format("Element by locator : %s is not visible", locator));
        }
    }

    private void waitForSeconds(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected List<WebElement> waitForList(String locator) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        return driver.findElements(by);
    }

    protected void waitAndClickTo(String locator, int seconds) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(
                ExpectedConditions.presenceOfElementLocated(by)).click();
    }

    protected void waitAndClickTo(String locator) {
        waitAndClickTo(locator, 10);
    }

    protected void waitForElementTitleIsAdd(String locator){
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.attributeContains(by, "title", "Add this page to your watchlist"));
    }

    protected void waitForClickableAndClick(String locator) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void waitAndClickTo(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void waitAndSendKeysTo(String locator, String keys) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(
                ExpectedConditions.presenceOfElementLocated(by)).sendKeys(keys);
    }

    public abstract void swipeElementToLeft(WebElement element);


//    public void checkSearchPageClosed() {
//        waitForElementDisappeared(PAGE_LIST_ITEM_TITLE_XPATH,
//                "element was found");
//    }
//
//    public void checkTitlePresent(WebElement element) {
//        waitAndClickTo(element, "cannot click to element");
//        By by = By.xpath(ITEM_TITLE_XPATH);
//        boolean isElementPresented = true;
//        try {
//            isElementPresented = driver.findElement(by).isDisplayed();
//        } catch (NoSuchElementException e) {
//            isElementPresented = false;
//        } finally {
//            Assertions.assertTrue(isElementPresented, "element is not presented");
//        }
//    }

    protected By getLocatorByString(String locatorWithBy) {
        String[] parts = locatorWithBy.split(":", 2);
        String by = parts[0];
        String locator = parts[1];
        switch (by) {
            case "xpath":
                return By.xpath(locator);
            case "id":
                return By.id(locator);
            case "css":
                return By.cssSelector(locator);
            default:
                throw new IllegalArgumentException("by not found " + by);
        }
    }
}
