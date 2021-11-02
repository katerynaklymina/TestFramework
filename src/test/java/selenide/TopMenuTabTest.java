package selenide;

import org.testng.annotations.Test;
import pages.selenide.SearchPage;
import pages.selenide.TopMenuTab;
import test_data.TestData;
import test_data.data_provider.DataProviderClass;

import static com.codeborne.selenide.Selenide.open;
import static constants.HostConstants.AVIC_HOST;

public class TopMenuTabTest {

    @Test(dataProvider = "dataForSearch", dataProviderClass = DataProviderClass.class)
    public void verifySearchFunctionality(String searchData) {
        SearchPage searchPage = new SearchPage();
        open(AVIC_HOST);
        searchPage.inputSearchField(searchData);
        searchPage.assertSearchList(searchData);
    }

    @Test
    public void verifyTopMenuTabFunctionality() {
        TopMenuTab topMenuTab = new TopMenuTab();
        open(AVIC_HOST);

        topMenuTab.isMenuTabPanelLinkListDisplayed();
        topMenuTab.isPhoneLogosListDisplayed();
        topMenuTab.assertTopMenuListTitles(TestData.EXPECTED_MENU_TAB_LIST);

        topMenuTab.clickOnTheButton("Ещё");
        topMenuTab.isMenuDropdownListDisplayed();
        topMenuTab.assertTopMenuDropdownListTitles(TestData.EXPECTED_DROPDOWN_LIST);

        topMenuTab.clickOnTheButton("RU");
        topMenuTab.isLanguageDropdownListDisplayed();
        topMenuTab.assertTopMenuDropdownListTitles(TestData.EXPECTED_DROPDOWN_LANG);
    }
}
