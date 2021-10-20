package page_steps.selenium;

import pages.selenium.SearchPage;

public class SearchPageSteps {

    private SearchPage searchPage = new SearchPage();


    public SearchPage getSearchPage(){
        return searchPage;
    }

    public void inputText(String buttonText) {
        searchPage.getSearchField().sendKeys(buttonText);
    }

    public void clickOnSearchButton() {
        searchPage.getSearchButton().click();
    }

    public boolean isListContainExpectedText(String inputText) {
        boolean condition = false;
        for (int i = 0; i < searchPage.getItemsTextList().size(); i++) {
            if (searchPage.getItemsTextList().get(i).getText().toLowerCase().contains(inputText.toLowerCase())) {
                condition = true;
            }
        }
        return condition;
    }


    public void clickOnFirstItemInList() {
        // itemsTextList.stream().findFirst().get().click();
        searchPage.getItemsTextList().get(0).click();
    }

    public boolean isSearchButtonEnabled(){
        return searchPage.getSearchButton().isEnabled();
    }
}



