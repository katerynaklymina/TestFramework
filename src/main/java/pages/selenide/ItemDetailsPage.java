package pages.selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class ItemDetailsPage {

    private final SelenideElement likeIcon = $x("//div[@class='container']//i[@class='icon icon-like']");
    private final SelenideElement buyButton = $x("//a[text() ='Купить']");
    private final SelenideElement buyInOneClick = $x("//a[text() ='Купить в 1 клик'");
    private final SelenideElement buyInInstallment = $x("//span[text() ='Купить в рассрочку']");
    private final ElementsCollection additionalInfoList = $$x("//div[@class = 'additional-info__text']");
    private final SelenideElement deliveryAndPaymentMethodsButton = $x("//a[text() ='Способы доставки и оплаты']");
    private final ElementsCollection additionalInfoTabs = $$x("//div[@id='feature2']//a[contains(@href,'feature')]//span[@class='tab-item']");
    private final SelenideElement characteristicTable = $x("//div[contains(@class, 'md-12 characteristic-table')]//table");
    private final ElementsCollection characteristicTableRows = $$x("//div[contains(@class, 'md-12 characteristic-table')]//table//tr");

    public void assertLikeIconIsDisplayed(){
        likeIcon.shouldBe(Condition.visible);
    }

    public void assertAdditionalInfoList(String expectedList){
        List<String> expectedInfoList = Arrays.asList(expectedList.split(","));
        expectedInfoList.forEach(h->{
            Assert.assertTrue($$(additionalInfoList).stream().map(SelenideElement::getText).collect(Collectors.toList()).contains(h));
        });
    }

    public void clickOnDeliveryAndPaymentMethodsButton() {
        deliveryAndPaymentMethodsButton.click();
    }

    public void assertAdditionalInfoTabs(String expectedList){
        List<String> expectedInfoTabs = Arrays.asList(expectedList.split(","));
        expectedInfoTabs.forEach(tab->{
            Assert.assertTrue($$(additionalInfoTabs).stream().map(SelenideElement::getText).collect(Collectors.toList()).contains(tab));
        });
    }

    public void clickOnItemOfAdditionalInfoList(String text){
        additionalInfoTabs.stream().filter(s->s.getText().contains(text)).findFirst().get().click();
    }

    public void assertCharacteristicTableIsDisplayed() {
        characteristicTable.shouldBe(Condition.visible);
    }

    public void assertCharacteristicTableRowsDisplayed(){
        $$(characteristicTableRows).shouldBe(CollectionCondition.allMatch("Not all characteristic rows are displayed", WebElement::isDisplayed));
    }

}


