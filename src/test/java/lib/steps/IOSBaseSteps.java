package lib.steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Arrays;

public class IOSBaseSteps extends BaseSteps{
    public IOSBaseSteps(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    public void swipeElementToLeft(WebElement element) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int rightX = element.getLocation().getX() + 1000;
        int leftX = element.getLocation().getX();
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        fingerSwipe(rightX, middleY, leftX, middleY, 300);
    }

    private void fingerSwipe(int startX, int startY, int endX, int endY, long timeInMillis) {
        PointerInput touchAction = new PointerInput(PointerInput.Kind.TOUCH, "touchAction");
        Interaction moveToStart = touchAction.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY);
        Interaction pressDown = touchAction.createPointerDown(PointerInput.MouseButton.LEFT.asArg());
        Interaction moveToEnd = touchAction.createPointerMove(Duration.ofMillis(timeInMillis), PointerInput.Origin.viewport(), endX, endY);
        Interaction pressUp = touchAction.createPointerUp(PointerInput.MouseButton.LEFT.asArg());

        Sequence swipe = new Sequence(touchAction, 0);
        swipe.addAction(moveToStart);
        swipe.addAction(pressDown);
        swipe.addAction(moveToEnd);
        swipe.addAction(pressUp);

        driver.perform(Arrays.asList(swipe));
    }
}
