package lib.page_objects.interfaces;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface SearchPageInt {

    @Step("Search in wiki : {value}")
    void searchInWiki(String value);

    @Step("Getting search results")
    List<WebElement> getSearchResults();

    @Step("Go to main menu")
    void goToMainMenu();

}
