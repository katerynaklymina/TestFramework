package pages.selenium;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class TopMenuTab extends BasePage {

    public TopMenuTab() {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class = 'header-top']")
    private WebElement menuTabPanel;

    @FindBy(xpath = "//a[contains(@class,'header-top__item')]")
    private List<WebElement> menuTabPanelLinkList;

    @FindBy(xpath = "//a[contains(@class, 'primary-phone')]")
    private WebElement menuTelephoneNumber;

    @FindBy(xpath = "//div[contains(@class,'time-work')]")
    private WebElement menuWorkHours;

    @FindBy(xpath = "//li[@class = 'header__soc-item']")
    private List<WebElement> phoneLogosList;

    @FindBy(xpath = "//ul[@class = 'menu-dropdown']//a")
    private List<WebElement> menuDropdownList;

    @FindBy(xpath = "//ul[contains(@class, 'menu-dropdown__lang')]//a")
    private List<WebElement> languageDropdownList;

}
