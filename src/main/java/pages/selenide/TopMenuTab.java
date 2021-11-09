package pages.selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class TopMenuTab {
    private final SelenideElement menuTabPanel = $x("//div[@class = 'header-top']");
    private final ElementsCollection menuTabPanelLinkList = $$x("//a[contains(@class,'header-top__item')]");
    private final SelenideElement menuTelephoneNumber = $x("//a[contains(@class, 'primary-phone')]");
    private final SelenideElement menuWorkHours = $x("//div[contains(@class,'time-work')]");
    private final ElementsCollection phoneLogosList = $$x("//li[@class = 'header__soc-item']");
    private final ElementsCollection menuDropdownList = $$x("//ul[@class = 'menu-dropdown']//a");
    private final ElementsCollection languageDropdownList = $$x("//ul[contains(@class, 'menu-dropdown__lang')]//a");

    public void clickOnTheButton(String buttonText) {
        $$(menuTabPanelLinkList).stream().filter(x -> x.getText().equals(buttonText)).findFirst().get().click();
    }

    public void isMenuTabPanelLinkListDisplayed(){
        $$(menuTabPanelLinkList).shouldBe(CollectionCondition.allMatch("Not all elements visible", WebElement::isDisplayed));
    }

    public void isPhoneLogosListDisplayed(){
        $$(phoneLogosList).shouldBe(CollectionCondition.allMatch("Not all elements visible", WebElement::isDisplayed));
    }

    public void isMenuDropdownListDisplayed(){
        $$(menuDropdownList).shouldBe(CollectionCondition.allMatch("Not all elements visible", WebElement::isDisplayed));
    }

    public void isLanguageDropdownListDisplayed(){
        $$(languageDropdownList).shouldBe(CollectionCondition.allMatch("Not all elements visible", WebElement::isDisplayed));
    }

    public void assertTopMenuDropdownListTitles(String expectedTitles){
        List<String> expectedTitlesList = Arrays.asList(expectedTitles.split(","));
        expectedTitlesList.forEach(header->{
            Assert.assertTrue($$(menuDropdownList).stream().map(SelenideElement::getText).collect(Collectors.toList()).contains(header));
        });
    }

    public void assertLangDropdownListTitles(String expectedTitles){
        List<String> expectedTitlesList = Arrays.asList(expectedTitles.split(","));
        expectedTitlesList.forEach(header->{
            Assert.assertTrue($$(languageDropdownList).stream().map(SelenideElement::getText).collect(Collectors.toList()).contains(header));
        });
    }

    public void assertTopMenuListTitles(String expectedTitles){
        List<String> expectedTitlesList = Arrays.asList(expectedTitles.split(","));
        expectedTitlesList.forEach(header->{
            Assert.assertTrue($$(menuTabPanelLinkList).stream().map(SelenideElement::getText).collect(Collectors.toList()).contains(header)); ;
        });
    }

}
