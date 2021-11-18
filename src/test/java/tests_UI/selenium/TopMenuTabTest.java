package tests_UI.selenium;

import frame_UI.test_data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import frame_UI.page_steps.TopMenuTabSteps;
import frame_UI.utils.Wait;

public class TopMenuTabTest extends BaseTest {

    private TopMenuTabSteps topMenuTabSteps;

    @Test
    public void verifyTopMenuPanel() {
        topMenuTabSteps = new TopMenuTabSteps();
        Wait.waitVisibilityOfElement(topMenuTabSteps.getTopMenuTab().getMenuTabPanel());

        Assert.assertTrue(topMenuTabSteps.isMenuTabPanelDisplayed(), "Panel is not displayed.");
        Assert.assertTrue(topMenuTabSteps.isMenuWorkHoursDisplayed(), "Work hours are not displayed.");
        Assert.assertTrue(topMenuTabSteps.isMenuTelephoneNumberDisplayed(), "Telephone number is not displayed.");
        Assert.assertTrue(topMenuTabSteps.isPhoneLogosListDisplayed(), "Phone logos are not displayed.");
        String actualResult = topMenuTabSteps.getStringFromMenuTabPanelList();
        Assert.assertEquals(actualResult, TestData.EXPECTED_MENU_TAB_LIST, "Expected result and actual are different.");
        topMenuTabSteps.clickOnTheButton("Ещё");
        String actualResultForDropdown = topMenuTabSteps.getStringFromMenuDropdownList();
        Assert.assertEquals(actualResultForDropdown, TestData.EXPECTED_DROPDOWN_LIST, "Expected result and actual are different.");
        topMenuTabSteps.clickOnTheButton("RU");
        String actualResultForDropdownLang = topMenuTabSteps.getStringFromLanguageDropdownList();
        Assert.assertEquals(actualResultForDropdownLang, TestData.EXPECTED_DROPDOWN_LANG, "Expected result and actual are different.");
    }

}
