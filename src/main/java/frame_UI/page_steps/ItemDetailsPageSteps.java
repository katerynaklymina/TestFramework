package frame_UI.page_steps;

import org.openqa.selenium.WebElement;
import frame_UI.pages.selenium.ItemDetailsPage;

import java.util.stream.Collectors;

public class ItemDetailsPageSteps {

    private ItemDetailsPage itemDetailsPage = new ItemDetailsPage();

    public ItemDetailsPage getItemDetailsPage(){
        return itemDetailsPage;
    }
    public boolean isLikeIconDisplayed() {
        return itemDetailsPage.getLikeIcon().isDisplayed();
    }

    public String getStringFromAdditionalInfoList() {
        return itemDetailsPage.getAdditionalInfoList().stream()
                .map(WebElement::getText)
                .collect(Collectors.joining(", "));
    }

    public boolean isListContainsExpectedItem(String text) {
        boolean b = false;
        for (WebElement w : itemDetailsPage.getAdditionalInfoList()) {
            if (w.getText().contains(text))
                b = true;
        }
        return b;
    }

    public void clickOnDeliveryAndPaymentMethodsButton() {
        itemDetailsPage.getDeliveryAndPaymentMethodsButton().click();
    }

    public String getStringFromAdditionalInfoTabs() {
        return itemDetailsPage.getAdditionalInfoTabs().stream()
                .map(WebElement::getText)
                .collect(Collectors.joining(", "));
    }

    public void clickOnItemOfAdditionalInfoList(String text) {
        for (WebElement a : itemDetailsPage.getAdditionalInfoTabs()) {
            if (a.getText().contains(text)) {
                a.click();
            }
        }
    }

    public boolean isCharacteristicTableDisplayed() {
        return itemDetailsPage.getCharacteristicTable().isDisplayed();
    }

    public boolean isCharacteristicTableRowsDisplayed() {
        boolean d = false;
        for (WebElement w : itemDetailsPage.getCharacteristicTableRows()) {
            d = w.isDisplayed();
        }
        return d;
    }

}
