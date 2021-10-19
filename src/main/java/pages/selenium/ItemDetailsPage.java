package pages.selenium;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ItemDetailsPage extends BasePage {

    public ItemDetailsPage() {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='container']//i[@class='icon icon-like']")
    private WebElement likeIcon;

    @FindBy(xpath = "//a[text() ='Купить']")
    private WebElement buyButton;

    @FindBy(xpath = "//a[text() ='Купить в 1 клик']")
    private WebElement buyInOneClick;

    @FindBy(xpath = "//span[text() ='Купить в рассрочку']")
    private WebElement buyInInstallment;

    @FindBy(xpath = "//div[@class = 'additional-info__text']")
    private List<WebElement> additionalInfoList;

    @FindBy(xpath = "//a[text() ='Способы доставки и оплаты']")
    private WebElement deliveryAndPaymentMethodsButton;

    @FindBy(xpath = "//div[@id='feature2']//a[contains(@href,'feature')]//span[@class='tab-item']")
    private List<WebElement> additionalInfoTabs;

    @FindBy(xpath = "//div[contains(@class, 'md-12 characteristic-table')]//table")
    private WebElement characteristicTable;

    @FindBy(xpath = "//div[contains(@class, 'md-12 characteristic-table')]//table//tr")
    private List<WebElement> characteristicTableRows;


}
