package tests_UI.selenide;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import frame_UI.pages.selenide.SearchPage;
import frame_UI.pages.selenide.TopMenuTab;
import frame_UI.test_data.TestData;
import frame_UI.test_data.data_provider.DataProviderClass;

import static com.codeborne.selenide.Selenide.open;
import static frame_UI.constants.HostConstants.AVIC_HOST;

public class TopMenuTabTest extends BaseTest{

    TopMenuTab topMenuTab;
    SearchPage searchPage;

    @BeforeMethod
   public void initialize(){
       topMenuTab = new TopMenuTab();
       searchPage = new SearchPage();
       open(AVIC_HOST);
   }

    @Test(dataProvider = "dataForSearch", dataProviderClass = DataProviderClass.class)
    public void verifySearchFunctionality(String searchData) {
        searchPage.inputSearchField(searchData);
        searchPage.assertSearchList(searchData);
    }

    @Test()
    public void verifyTopMenuTabFunctionality() {
        topMenuTab.isMenuTabPanelLinkListDisplayed();
        topMenuTab.isPhoneLogosListDisplayed();
        topMenuTab.assertTopMenuListTitles(TestData.EXPECTED_MENU_TAB_LIST);

        topMenuTab.clickOnTheButton("Ещё");
        topMenuTab.isMenuDropdownListDisplayed();
        topMenuTab.assertTopMenuDropdownListTitles(TestData.EXPECTED_DROPDOWN_LIST);

        topMenuTab.clickOnTheButton("RU");
        topMenuTab.isLanguageDropdownListDisplayed();
        topMenuTab.assertLangDropdownListTitles(TestData.EXPECTED_DROPDOWN_LANG);
    }
}
