package page_steps.selenium;

import org.openqa.selenium.WebElement;
import pages.selenium.TopMenuTab;

import java.util.stream.Collectors;

public class TopMenuTabSteps {
    private TopMenuTab topMenuTab = new TopMenuTab();

    public TopMenuTab getTopMenuTab(){
        return topMenuTab;
    }

    public boolean isMenuTabPanelDisplayed() {
        return topMenuTab.getMenuTabPanel().isDisplayed();
    }

    public boolean isMenuTelephoneNumberDisplayed() {
        return topMenuTab.getMenuTelephoneNumber().isDisplayed();
    }

    public boolean isMenuWorkHoursDisplayed() {
        return topMenuTab.getMenuWorkHours().isDisplayed();
    }

    public void isMenuTabPanelLinkListDisplayed() {
       /* for(int i =0;i<=menuTabPanelLinkList.size();i++){
            menuTabPanelLinkList.get(i).isDisplayed();
        }*/
        for (WebElement a : topMenuTab.getMenuTabPanelLinkList()) {
            a.isDisplayed();
        }
    }

    public boolean isMenuTabPanelLinkListDisplayed2() {
        boolean c = false;
        for (WebElement a : topMenuTab.getMenuTabPanelLinkList()) {
            c = a.isDisplayed();
        }
        return c;
    }

    public boolean isPhoneLogosListDisplayed() {
        boolean d = false;
        for (WebElement w : topMenuTab.getPhoneLogosList()) {
            d = w.isDisplayed();
        }
        return d;
    }

    public String getStringFromMenuTabPanelList() {
        return topMenuTab.getMenuTabPanelLinkList().stream()
                .map(WebElement::getText)
                .collect(Collectors.joining(","));
    }

    public void clickOnTheButton(String buttonText) {
        for (WebElement w : topMenuTab.getMenuTabPanelLinkList()) {
            if (w.getText().equals(buttonText)) {
                w.click();
            }
        }
    }

    public String getStringFromMenuDropdownList() {
        return topMenuTab.getMenuDropdownList().stream()
                .map(WebElement::getText)
                .collect(Collectors.joining(","));
    }

    public String getStringFromLanguageDropdownList() {
        return topMenuTab.getLanguageDropdownList().stream()
                .map(WebElement::getText)
                .collect(Collectors.joining(","));
    }

}

