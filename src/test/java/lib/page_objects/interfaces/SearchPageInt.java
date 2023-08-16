package lib.page_objects.interfaces;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface SearchPageInt {

    void searchInWiki(String value);
    List<WebElement> getSearchResults();

    void goToMainMenu();

}
