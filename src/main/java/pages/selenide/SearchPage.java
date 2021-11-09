package pages.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private final SelenideElement searchButton = $x("//button[@class= 'button-reset search-btn']");
    private final SelenideElement searchField = $(By.id("input_search"));
    private final ElementsCollection itemsTextList = $$x("//div[@class='prod-cart__descr']");
    private final SelenideElement itemsText1 = $x("//div[@class='prod-cart__descr']");

    public void inputSearchField(String value){
        searchField.setValue(value);
        searchField.click();
    }

    public void assertSearchList(String s){
        itemsTextList.shouldHave().stream().map(SelenideElement::getText).collect(Collectors.toList()).contains(s);
    }

    public void clickOnFirstItem(){
        itemsTextList.stream().findFirst().get().click();
    }

    public void clickOnSearchButton(){
       searchButton.click();
    }

}
