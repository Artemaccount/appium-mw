package lib.page_objects.interfaces;

import io.qameta.allure.Step;

public interface MainPageInt {

    @Step("Skip onboarding")
    void skipOnboarding();

    @Step("Opening saved list")
    void openSavedList();

    @Step("Back to search page")
    void backToSearchPage(String searchWord);

}
